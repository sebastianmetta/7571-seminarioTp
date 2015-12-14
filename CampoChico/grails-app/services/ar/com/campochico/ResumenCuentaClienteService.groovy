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
		//TODO: Obtener saldo desde el inicio hasta fecha desde y ponerlo 
		//como primer registro, bajo concepto "Saldo anterior"
		List<ResumenCuentaCliente> resumen = new ArrayList<ResumenCuentaCliente>()
		
		BigDecimal saldoAnterior = BigDecimal.ZERO
		visitasCliente.each { eachVisita ->
			//Saldo deudor
			eachVisita.getProductosVendidos().each { eachVenta ->
				ResumenCuentaCliente resumenDeCuenta = ResumenCuentaCliente.crearParaSaldoDeudor(eachVisita, eachVenta, saldoAnterior)
				saldoAnterior = resumenDeCuenta.getSaldo()
				resumen.add(resumenDeCuenta);
			}
			//Saldo acreedor
			ResumenCuentaCliente resumenInstance = ResumenCuentaCliente.crearParaSaldoAcreedor(eachVisita)
			saldoAnterior = saldoAnterior.add(resumenInstance.getSaldoAcreedor().subtract(resumenInstance.getSaldoDeudor()))
			resumenInstance.setSaldo(saldoAnterior)
			resumen.add(resumenInstance);
		}
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

		List fields = [ "fecha", "descripcion", "debe", "haber", "saldo" ]
		Map labels = ["fecha":"Fecha", "descripcion":"Descripción", "debe":"Debe", "haber":"Haber", "saldo":"Saldo"]

		// Closure de formateo
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
