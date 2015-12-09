package ar.com.campochico

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.joda.time.LocalDate;

import grails.transaction.Transactional


@Transactional
class ResumenCuentaClienteService {

	def exportService
	def grailsApplication 

	def getResumenCuenta(Cliente cliente, Date fechaDesde, Date fechaHasta) {
		if (!cliente) {
			return new ArrayList<ResumenCuentaCliente>()
		}
		List visitasCliente = VisitaCliente.withCriteria {
			eq('cliente',cliente)
			between('fecha', fechaDesde.clearTime(), fechaHasta.clearTime())
			order('fecha', 'asc')
		}
		return calculateResumen(visitasCliente)
	}

	private def calculateResumen(List visitasCliente) {
		//TODO: Obtener saldo desde el inicio hasta fecha desde y ponerlo como primer registro.
		List<ResumenCuentaCliente> resumen = new ArrayList<ResumenCuentaCliente>()
		
		BigDecimal saldoAnterior = BigDecimal.ZERO
		visitasCliente.each { eachVisita ->
			//Iteramos las ventas de cada fecha del cliente para el saldo deudor
			eachVisita.getProductosVendidos().each { eachVentaProducto ->
				ResumenCuentaCliente resumenDto = new ResumenCuentaCliente();
				resumenDto.setFecha(eachVisita.getFecha().clearTime());
				resumenDto.setDescripcion(
						eachVentaProducto.getProducto().getNombre() + " - " +
						NumberUtils.formatQuantity(eachVentaProducto.getCantidad()) + " x " +
						NumberUtils.formatCurrency(eachVentaProducto.getPrecioVentaUnitario())
						)
				resumenDto.setSaldoDeudor(new BigDecimal(eachVentaProducto.getCantidad() * eachVentaProducto.getPrecioVentaUnitario()))
				resumenDto.setSaldoAcreedor(BigDecimal.ZERO)
				saldoAnterior = saldoAnterior.add(resumenDto.getSaldoAcreedor().subtract(resumenDto.getSaldoDeudor()))
				resumenDto.setSaldo(saldoAnterior)
				resumen.add(resumenDto);
			}
			//Saldo acreedor se llena con importe cobrado
			ResumenCuentaCliente resumenInstance = createResumenInstance(eachVisita)
			saldoAnterior = saldoAnterior.add(resumenInstance.getSaldoAcreedor().subtract(resumenInstance.getSaldoDeudor()))
			resumenInstance.setSaldo(saldoAnterior)
			resumen.add(resumenInstance);
		}
		return resumen
	}
	
	private def createResumenInstance(VisitaCliente visitaCliente) {
		ResumenCuentaCliente resumenInstance = new ResumenCuentaCliente();
		resumenInstance.setFecha(visitaCliente.getFecha());
		resumenInstance.setDescripcion("Importe cobrado")
		resumenInstance.setSaldoDeudor(BigDecimal.ZERO)
		resumenInstance.setSaldoAcreedor(new BigDecimal(visitaCliente.getImporteCobrado()))
		return resumenInstance
	}
	
	def exportResumenCuentaClienteToOutputStream(HttpServletResponse servletResponse, Cliente cliente, LocalDate fechaDesde, LocalDate fechaHasta, String exportFormat, String exportExtension) {
		servletResponse.contentType = grailsApplication.config.grails.mime.types[exportFormat]
		servletResponse.setHeader("Content-disposition", "attachment; filename=ResumenCuentaCliente.${exportExtension}")

		Date fecha
		String descripcion
		BigDecimal debe
		BigDecimal haber
		BigDecimal saldo

		List fields = [ "fecha", "descripcion", "debe", "haber", "saldo" ]
		Map labels = ["fecha":"Fecha", "descripcion":"Descripción", "debe":"Debe", "haber":"Haber", "saldo":"Saldo"]

				// Formatter closure
		def upperCase = { domain, value ->
			return value.toUpperCase()
		}
		
		Map formatters = []
		Map parameters = [title: "Resumen cuenta cliente ${cliente} - ${localDate}"]
		
		def resumenList = this.getResumenCuenta(cliente, fechaDesde, fechaHasta)
		exportService.export(exportFormat, servletResponse.outputStream, resumenList, fields, labels, formatters, parameters)
		[ resumenList: resumenList ]

	}
}
