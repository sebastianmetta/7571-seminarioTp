package ar.com.campochico

import grails.converters.JSON

import org.joda.time.LocalDate;

class HojaDeRutaController {

	//Helpful when controller actions are exposed as REST service.
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	// Grails inyecta los servicios por convencion de nombres.
	def zonaService

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
			zonaService.exportClientsListByDateToOutputStream(response, localDate, params.exportFormat, params.exportExtension)
		}
		else {
			[	
				zoneName:zonaService.zoneName(localDate),
				clientsList: zonaService.zoneClients(localDate),
				clientsVisitsList: visitaClienteService.getClientVisitsByDate(localDate.toDate()),
				zoneDate: localDate.toDate(),
				vendedorName: zonaService.vendedorName(localDate)
			]
		}


	}

}
