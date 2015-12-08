package ar.com.campochico



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import groovy.time.TimeCategory

@Transactional(readOnly = true)
class VisitaClienteController {
	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
	def index(Integer max) {
		redirect(action: "list", params: params)
	}

	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[visitaClienteInstanceList: VisitaCliente.list(params), visitaClienteInstanceTotal: VisitaCliente.count()]
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

		//Se dan de alta los elementos asociados
		int ventaProductoCount = 0
		def ventaProductoAsString = params.get('ventaProductosList[' + ventaProductoCount + ']')
		while(ventaProductoAsString!=null) {
			Venta ventaProducto = new Venta(params.get('ventaProductosList[' + ventaProductoCount + ']'))
			visitaClienteInstance.addToProductosVendidos(ventaProducto)
			ventaProductoCount++
			ventaProductoAsString = params.get('ventaProductosList[' + ventaProductoCount + ']')
		}

		visitaClienteInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [
					message(code: 'visitaCliente.label', default: 'VisitaCliente'),
					visitaClienteInstance.id
				])
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

		visitaClienteInstance.properties = params

		int ventaProductoCount = 0
		def ventaProductoParams = params.get('ventaProductosList[' + ventaProductoCount + ']')
		while(ventaProductoParams!=null) {
			def ventaProducto = Venta.get(ventaProductoParams['id'])
			if (ventaProductoParams['deleted'].equals("true")) {				
				//Baja
				visitaClienteInstance.productosVendidos.remove(ventaProducto)
			}
			else {
				if (ventaProducto) {					
					//Actualización
					ventaProducto.properties=ventaProductoParams
				}
				else {
					//Alta
					ventaProducto = new Venta(params.get('ventaProductosList[' + ventaProductoCount + ']'))
					visitaClienteInstance.addToProductosVendidos(ventaProducto)
				}
			}
			ventaProductoCount++
			ventaProductoParams = params.get('ventaProductosList[' + ventaProductoCount + ']')
		}

		visitaClienteInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [
					message(code: 'VisitaCliente.label', default: 'VisitaCliente'),
					visitaClienteInstance.id
				])
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
				flash.message = message(code: 'default.deleted.message', args: [
					message(code: 'VisitaCliente.label', default: 'VisitaCliente'),
					visitaClienteInstance.id
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
					message(code: 'visitaCliente.label', default: 'VisitaCliente'),
					params.id
				])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}
