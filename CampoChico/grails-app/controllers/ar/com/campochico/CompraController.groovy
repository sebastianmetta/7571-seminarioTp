package ar.com.campochico



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CompraController {
	static scaffold = true
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Compra.list(params), model:[compraProductoInstanceCount: Compra.count()]
    }

    def show(Compra compraProductoInstance) {
        respond compraProductoInstance
    }

    def create() {
        respond new Compra(params)
    }

    @Transactional
    def save(Compra compraProductoInstance) {
        if (compraProductoInstance == null) {
            notFound()
            return
        }

        if (compraProductoInstance.hasErrors()) {
            respond compraProductoInstance.errors, view:'create'
            return
        }

        compraProductoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'compraProducto.label', default: 'CompraProducto'), compraProductoInstance.id])
                redirect compraProductoInstance
            }
            '*' { respond compraProductoInstance, [status: CREATED] }
        }
    }

    def edit(Compra compraProductoInstance) {
        respond compraProductoInstance
    }

    @Transactional
    def update(Compra compraProductoInstance) {
        if (compraProductoInstance == null) {
            notFound()
            return
        }

        if (compraProductoInstance.hasErrors()) {
            respond compraProductoInstance.errors, view:'edit'
            return
        }

        compraProductoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CompraProducto.label', default: 'CompraProducto'), compraProductoInstance.id])
                redirect compraProductoInstance
            }
            '*'{ respond compraProductoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Compra compraProductoInstance) {

        if (compraProductoInstance == null) {
            notFound()
            return
        }

        compraProductoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CompraProducto.label', default: 'CompraProducto'), compraProductoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'compraProducto.label', default: 'CompraProducto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
