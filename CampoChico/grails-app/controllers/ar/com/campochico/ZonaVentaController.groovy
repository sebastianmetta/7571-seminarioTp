package ar.com.campochico



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.joda.time.LocalDate;

@Transactional(readOnly = true)
class ZonaVentaController {
	static scaffold = true

	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	// Grails inyecta los servicios por convencion de nombres.
	def zonaVentaService

	def visitaClienteService
		
	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond ZonaVenta.list(params), model:[zonaInstanceCount: ZonaVenta.count()]
	}

	def show(ZonaVenta zonaVentaInstance) {
		respond zonaVentaInstance
	}

	def create() {
		respond new ZonaVenta(params)
	}

	def zonaDelDia() {
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

	@Transactional
	def save(ZonaVenta zonaVentaInstance) {
		if (zonaVentaInstance == null) {
			notFound()
			return
		}

		if (zonaVentaInstance.hasErrors()) {
			respond zonaVentaInstance.errors, view:'create'
			return
		}

		zonaVentaInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [
					message(code: 'zona.label', default: 'Zona'),
					zonaVentaInstance.id
				])
				redirect zonaVentaInstance
			}
			'*' { respond zonaVentaInstance, [status: CREATED] }
		}
	}

	def edit(ZonaVenta zonaVentaInstance) {
		respond zonaVentaInstance
	}

	@Transactional
	def update(ZonaVenta zonaInstance) {
		if (zonaInstance == null) {
			notFound()
			return
		}

		if (zonaInstance.hasErrors()) {
			respond zonaInstance.errors, view:'edit'
			return
		}

		zonaInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [
					message(code: 'Zona.label', default: 'Zona'),
					zonaInstance.id
				])
				redirect zonaInstance
			}
			'*'{ respond zonaInstance, [status: OK] }
		}
	}

	@Transactional
	def delete(ZonaVenta zonaVentaInstance) {

		if (zonaVentaInstance == null) {
			notFound()
			return
		}

		zonaVentaInstance.delete flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [
					message(code: 'Zona.label', default: 'Zona'),
					zonaVentaInstance.id
				])
				redirect action:"index", method:"GET"
			}
			'*'{ render status: NO_CONTENT }
		}
	}

	protected void notFound() {
		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.not.found.message', args: [
					message(code: 'zona.label', default: 'Zona'),
					params.id
				])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}
