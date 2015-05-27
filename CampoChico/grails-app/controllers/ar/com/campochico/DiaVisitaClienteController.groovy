package ar.com.campochico



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DiaVisitaClienteController {

	static scaffold = true

	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		respond DiaVisitaCliente.list(params), model:[diaVisitaClienteInstanceCount: DiaVisitaCliente.count()]
	}

	def show(DiaVisitaCliente diaVisitaClienteInstance) {
		respond diaVisitaClienteInstance
	}

	def create() {
		respond new DiaVisitaCliente(params)
	}

	@Transactional
	def save(DiaVisitaCliente diaVisitaClienteInstance) {
		if (diaVisitaClienteInstance == null) {
			notFound()
			return
		}

		if (diaVisitaClienteInstance.hasErrors()) {
			respond diaVisitaClienteInstance.errors, view:'create'
			return
		}

		diaVisitaClienteInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [
					message(code: 'diaVisitaCliente.label', default: 'DiaVisitaCliente'),
					diaVisitaClienteInstance.id
				])
				redirect diaVisitaClienteInstance
			}
			'*' { respond diaVisitaClienteInstance, [status: CREATED] }
		}
	}

	def edit(DiaVisitaCliente diaVisitaClienteInstance) {
		respond diaVisitaClienteInstance
	}

	@Transactional
	def update(DiaVisitaCliente diaVisitaClienteInstance) {
		if (diaVisitaClienteInstance == null) {
			notFound()
			return
		}

		if (diaVisitaClienteInstance.hasErrors()) {
			respond diaVisitaClienteInstance.errors, view:'edit'
			return
		}

		diaVisitaClienteInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [
					message(code: 'DiaVisitaCliente.label', default: 'DiaVisitaCliente'),
					diaVisitaClienteInstance.id
				])
				redirect diaVisitaClienteInstance
			}
			'*'{ respond diaVisitaClienteInstance, [status: OK] }
		}
	}

	@Transactional
	def delete(DiaVisitaCliente diaVisitaClienteInstance) {

		if (diaVisitaClienteInstance == null) {
			notFound()
			return
		}

		diaVisitaClienteInstance.delete flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [
					message(code: 'DiaVisitaCliente.label', default: 'DiaVisitaCliente'),
					diaVisitaClienteInstance.id
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
					message(code: 'diaVisitaCliente.label', default: 'DiaVisitaCliente'),
					params.id
				])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}
