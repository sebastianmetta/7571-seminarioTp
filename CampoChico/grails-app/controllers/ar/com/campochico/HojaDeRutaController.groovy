package ar.com.campochico

import grails.converters.JSON
import org.joda.time.LocalDate;

class HojaDeRutaController {

	//Helpful when controller actions are exposed as REST service.
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		//render (view:'index.gsp')
		
		//TODO: Mover a un servicio
		String todayDay = new LocalDate().dayOfWeek().getAsText()
		List<Zona> todayZone = Zona.withCriteria {
			diasVisita {
				eq('id', DiaVisitaCliente.findByDia(todayDay).getId())
			}
		}
		String todayZoneAsJson = todayZone as JSON
		println "Result As json: " + todayZoneAsJson
		//[todayZone:todayZone]
		[json: todayZoneAsJson]
	}


	def loadHojaDeRuta() {
		String todayDay = new LocalDate().dayOfWeek().getAsText()
		List<Zona> zonaHoy = Zona.withCriteria {
			diasVisita { eq('diasVisita', todayDay) }
		}
		[zona:zonaHoy]
	}
}
