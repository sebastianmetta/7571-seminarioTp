package ar.com.campochico

import grails.converters.JSON

import org.joda.time.LocalDate;

class HojaDeRutaController {

	//Helpful when controller actions are exposed as REST service.
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	// Grails inyectará el servicio en esta propiedad
	// ¿Cómo sabe que servicio inyectar? Usa una convención para determinar que servicio debe
	// inyectar. En este caso puso en mayúscula la primera letra y busco UserService
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
		//TODO: Revisar que getClientVisitsByDia ande bien. Si anda bien, revisar la vista.
		[zoneName:zonaService.zoneName(localDate),
			clientsList: zonaService.zoneClients(localDate),
			clientsVisitsList: visitaClienteService.getClientVisitsByDate(localDate.toDate()),
			zoneDate: localDate.toDate()
			]
	}

}
