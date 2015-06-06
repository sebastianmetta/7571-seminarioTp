package ar.com.campochico



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CompraProductoController {
	static scaffold = true
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CompraProducto.list(params), model:[compraProductoInstanceCount: CompraProducto.count()]
    }

    def show(CompraProducto compraProductoInstance) {
        respond compraProductoInstance
    }

    def create() {
        respond new CompraProducto(params)
    }

    @Transactional
    def save(CompraProducto compraProductoInstance) {
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

    def edit(CompraProducto compraProductoInstance) {
        respond compraProductoInstance
    }

    @Transactional
    def update(CompraProducto compraProductoInstance) {
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
    def delete(CompraProducto compraProductoInstance) {

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
