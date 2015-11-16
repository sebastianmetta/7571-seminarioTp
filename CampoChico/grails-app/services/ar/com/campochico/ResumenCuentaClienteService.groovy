package ar.com.campochico

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.joda.time.LocalDate;

import grails.transaction.Transactional


@Transactional
class ResumenCuentaClienteService {

	//Export plugin
	def exportService
	def grailsApplication  //inject GrailsApplication

	def getResumenCuenta(Cliente cliente, Date fechaDesde, Date fechaHasta) {
		
		List<ResumenCuentaClienteDto> resumen = new ArrayList<ResumenCuentaClienteDto>()
		
		if (!cliente) {
			return resumen
		}
		
		List visitasCliente = VisitaCliente.withCriteria {
			eq('cliente',cliente)
			between('fecha', fechaDesde.clearTime(), fechaHasta.clearTime())
			order('fecha', 'asc')
		}
		//TODO: Obtener saldo desde el inicio hasta fecha desde y ponerlo como primer registro.
		BigDecimal saldoAnterior = BigDecimal.ZERO
		for (VisitaCliente eachVisita : visitasCliente) {
			//Iteramos las ventas de cada fecha del cliente para el saldo deudor
			//BigDecimal subtotalDeudor = BigDecimal.ZERO
			for (VentaProducto eachVentaProducto : eachVisita.getProductosVendidos()) {
				ResumenCuentaClienteDto resumenDto = new ResumenCuentaClienteDto();
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
				//subtotalDeudor.add(resumenDto.getSaldoDeudor())
				resumen.add(resumenDto);
			}
			//Saldo acreedor se llena con importe cobrado
			ResumenCuentaClienteDto resumenDto = new ResumenCuentaClienteDto();
			resumenDto.setFecha(eachVisita.getFecha());
			resumenDto.setDescripcion("Importe cobrado")
			resumenDto.setSaldoDeudor(BigDecimal.ZERO)
			resumenDto.setSaldoAcreedor(new BigDecimal(eachVisita.getImporteCobrado()))
			saldoAnterior = saldoAnterior.add(resumenDto.getSaldoAcreedor().subtract(resumenDto.getSaldoDeudor()))
			resumenDto.setSaldo(saldoAnterior)
			resumen.add(resumenDto);
		}
//		for (ResumenCuentaClienteDto eachDto : resumen) {
//			println eachDto.toString()
//		}
		return resumen
	}

	def exportResumenCuentaClienteToOutputStream(HttpServletResponse servletResponse, Cliente cliente, LocalDate fechaDesde, LocalDate fechaHasta, String exportFormat, String exportExtension) {
		servletResponse.contentType = grailsApplication.config.grails.mime.types[exportFormat]
		servletResponse.setHeader("Content-disposition", "attachment; filename=ResumenCuentaCliente.${exportExtension}")

		Date fecha
		String descripcion
		BigDecimal debe
		BigDecimal haber
		BigDecimal saldo

		List fields = [
			"fecha",
			"descripcion",
			"debe",
			"haber",
			"saldo"
		]
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
