package ar.com.campochico

import grails.converters.JSON

import org.joda.time.LocalDate;

class HojaDeRutaController {

	//Helpful when controller actions are exposed as REST service.
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	// Grails inyecta los servicios por convencion de nombres.
	def zonaVentaService

	def visitaClienteService

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		LocalDate localDate
		if (params.fechaZona) {
			def fechaAsString = params.fechaZona_year + "-" + params.fechaZona_month + "-" + params.fechaZona_day
			localDate= new LocalDate(fechaAsString)
		}
		else {
			localDate= new LocalDate()
		}
		if (params?.exportFormat && params?.exportFormat != "html") {
			zonaVentaService.exportClientsListByDateToOutputStream(response, localDate, params.exportFormat, params.exportExtension)
		}
		else {
			[	
				zoneName:zonaVentaService.zoneName(localDate),
				clientsList: zonaVentaService.zoneClients(localDate),
				clientsVisitsList: visitaClienteService.getClientVisitsByDate(localDate.toDate()),
				zoneDate: localDate.toDate(),
				vendedorName: zonaVentaService.vendedorName(localDate)
			]
		}


	}

}
