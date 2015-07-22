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
	
	def index() {
		redirect(action: "list", params: params)
	}
	
	def list() {
		[todayClientsList: zonaService.todayClients()]
	}

}
