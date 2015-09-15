package ar.com.campochico

import grails.converters.JSON

import org.joda.time.LocalDate;

class HojaDeRutaController {

	//Export plugin
	def exportService
	def grailsApplication  //inject GrailsApplication
	
	//Helpful when controller actions are exposed as REST service.
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	// Grails inyecta los servicios por convencion de nombres.
	def zonaService
	
	def visitaClienteService

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		
				if(params?.format && params.format != "html"){
					response.contentType = grailsApplication.config.grails.mime.types[params.format]
					response.setHeader("Content-disposition", "attachment; filename=books.${params.extension}")
					exportService.export(params.format, response.outputStream,Book.list(params), [:], [:])
					[ bookInstanceList: Book.list( params ) ]
				}
				else {					
					LocalDate localDate
					if (params.fechaZona) {
						def fechaAsString = params.fechaZona_year + "-" + params.fechaZona_month + "-" + params.fechaZona_day
								localDate= new LocalDate(fechaAsString)
					}
					else {
						localDate= new LocalDate()
					}
					[zoneName:zonaService.zoneName(localDate),
					 clientsList: zonaService.zoneClients(localDate),
					 clientsVisitsList: visitaClienteService.getClientVisitsByDate(localDate.toDate()),
					 zoneDate: localDate.toDate()
					 ]
				}
				
		
	}

}
