package ar.com.campochico



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class VisitaClienteController {
	static scaffold = true
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond VisitaCliente.list(params), model:[visitaClienteInstanceCount: VisitaCliente.count()]
    }

    def show(VisitaCliente visitaClienteInstance) {
        respond visitaClienteInstance
    }

    def create() {
        respond new VisitaCliente(params)
    }

    @Transactional
    def save(VisitaCliente visitaClienteInstance) {
        if (visitaClienteInstance == null) {
            notFound()
            return
        }

        if (visitaClienteInstance.hasErrors()) {
            respond visitaClienteInstance.errors, view:'create'
            return
        }

        visitaClienteInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'visitaCliente.label', default: 'VisitaCliente'), visitaClienteInstance.id])
                redirect visitaClienteInstance
            }
            '*' { respond visitaClienteInstance, [status: CREATED] }
        }
    }

    def edit(VisitaCliente visitaClienteInstance) {
        respond visitaClienteInstance
    }

    @Transactional
    def update(VisitaCliente visitaClienteInstance) {
        if (visitaClienteInstance == null) {
            notFound()
            return
        }

        if (visitaClienteInstance.hasErrors()) {
            respond visitaClienteInstance.errors, view:'edit'
            return
        }

        visitaClienteInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'VisitaCliente.label', default: 'VisitaCliente'), visitaClienteInstance.id])
                redirect visitaClienteInstance
            }
            '*'{ respond visitaClienteInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(VisitaCliente visitaClienteInstance) {

        if (visitaClienteInstance == null) {
            notFound()
            return
        }

        visitaClienteInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'VisitaCliente.label', default: 'VisitaCliente'), visitaClienteInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'visitaCliente.label', default: 'VisitaCliente'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
