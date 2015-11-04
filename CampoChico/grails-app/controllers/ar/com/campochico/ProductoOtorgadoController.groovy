package ar.com.campochico



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProductoOtorgadoController {

	static scaffold = true
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ProductoOtorgado.list(params), model:[productoOtorgadoInstanceCount: ProductoOtorgado.count()]
    }

    def show(ProductoOtorgado productoOtorgadoInstance) {
        respond productoOtorgadoInstance
    }

    def create() {
        respond new ProductoOtorgado(params)
    }

    @Transactional
    def save(ProductoOtorgado productoOtorgadoInstance) {
        if (productoOtorgadoInstance == null) {
            notFound()
            return
        }

        if (productoOtorgadoInstance.hasErrors()) {
            respond productoOtorgadoInstance.errors, view:'create'
            return
        }

        productoOtorgadoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'productoOtorgado.label', default: 'ProductoOtorgado'), productoOtorgadoInstance.id])
                redirect productoOtorgadoInstance
            }
            '*' { respond productoOtorgadoInstance, [status: CREATED] }
        }
    }

    def edit(ProductoOtorgado productoOtorgadoInstance) {
        respond productoOtorgadoInstance
    }

    @Transactional
    def update(ProductoOtorgado productoOtorgadoInstance) {
        if (productoOtorgadoInstance == null) {
            notFound()
            return
        }

        if (productoOtorgadoInstance.hasErrors()) {
            respond productoOtorgadoInstance.errors, view:'edit'
            return
        }

        productoOtorgadoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ProductoOtorgado.label', default: 'ProductoOtorgado'), productoOtorgadoInstance.id])
                redirect productoOtorgadoInstance
            }
            '*'{ respond productoOtorgadoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ProductoOtorgado productoOtorgadoInstance) {

        if (productoOtorgadoInstance == null) {
            notFound()
            return
        }

        productoOtorgadoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ProductoOtorgado.label', default: 'ProductoOtorgado'), productoOtorgadoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'productoOtorgado.label', default: 'ProductoOtorgado'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
