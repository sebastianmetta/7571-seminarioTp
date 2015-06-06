package ar.com.campochico



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class VentaProductoController {
	static scaffold = true
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond VentaProducto.list(params), model:[ventaProductoInstanceCount: VentaProducto.count()]
    }

    def show(VentaProducto ventaProductoInstance) {
        respond ventaProductoInstance
    }

    def create() {
        respond new VentaProducto(params)
    }

    @Transactional
    def save(VentaProducto ventaProductoInstance) {
        if (ventaProductoInstance == null) {
            notFound()
            return
        }

        if (ventaProductoInstance.hasErrors()) {
            respond ventaProductoInstance.errors, view:'create'
            return
        }

        ventaProductoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ventaProducto.label', default: 'VentaProducto'), ventaProductoInstance.id])
                redirect ventaProductoInstance
            }
            '*' { respond ventaProductoInstance, [status: CREATED] }
        }
    }

    def edit(VentaProducto ventaProductoInstance) {
        respond ventaProductoInstance
    }

    @Transactional
    def update(VentaProducto ventaProductoInstance) {
        if (ventaProductoInstance == null) {
            notFound()
            return
        }

        if (ventaProductoInstance.hasErrors()) {
            respond ventaProductoInstance.errors, view:'edit'
            return
        }

        ventaProductoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'VentaProducto.label', default: 'VentaProducto'), ventaProductoInstance.id])
                redirect ventaProductoInstance
            }
            '*'{ respond ventaProductoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(VentaProducto ventaProductoInstance) {

        if (ventaProductoInstance == null) {
            notFound()
            return
        }

        ventaProductoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'VentaProducto.label', default: 'VentaProducto'), ventaProductoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ventaProducto.label', default: 'VentaProducto'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
