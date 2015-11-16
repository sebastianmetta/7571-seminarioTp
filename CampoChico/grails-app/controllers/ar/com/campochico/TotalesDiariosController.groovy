package ar.com.campochico

import java.text.SimpleDateFormat
import org.joda.time.LocalDate

class TotalesDiariosController {

    //Helpful when controller actions are exposed as REST service.
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	// Grails inyecta los servicios por convencion de nombres.
	def totalesDiariosService

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		LocalDate localDate
		if (params.fechaConsulta) {
			def fechaAsString = params.fechaConsulta_year + "-" + params.fechaConsulta_month + "-" + params.fechaConsulta_day
			localDate= new LocalDate(fechaAsString)
		}
		else {
			localDate= new LocalDate()
		}
		[	
			fechaLastValue: localDate.toDate(),
			totalesDiarios: totalesDiariosService.obtenerTotalesVentas(localDate.toDate()),
		]
	}
}
