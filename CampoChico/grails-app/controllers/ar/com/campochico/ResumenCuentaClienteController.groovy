package ar.com.campochico

import java.text.SimpleDateFormat;

import org.joda.time.LocalDate

class ResumenCuentaClienteController {

	// Grails inyecta los servicios por convencion de nombres.
	def resumenCuentaClienteService

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		Date fechaDesde = new Date()
		Date fechaHasta = new Date()
		Cliente cliente = Cliente.findById(params.clienteId)
		
		def f = new SimpleDateFormat("dd/MM/yyyy")
		if (params.fechaDesdeNew_value) {			
			fechaDesde = f.parse(params.fechaDesdeNew_value)					
		}
		if (params.fechaHastaNew_value) {
			fechaHasta = f.parse(params.fechaHastaNew_value)
		}
		
		if (params?.exportFormat && params?.exportFormat != "html") {
			resumenCuentaClienteService.exportResumenCuentaClienteToOutputStream(null, null, fechaDesde, fechaHasta, "", "")(response, fechaHasta, params.exportFormat, params.exportExtension)
		}
		else {
			[ 	resumenList:resumenCuentaClienteService.getResumenCuenta(cliente, fechaDesde, fechaHasta),
				fechaDesdeLastValue: fechaDesde ,
				fechaHastaLastValue: fechaHasta ,
				clienteIdLastValue: cliente?.id 
			]
		}

	}
}
