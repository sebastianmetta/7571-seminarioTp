package ar.com.campochico



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import groovy.time.TimeCategory

@Transactional(readOnly = true)
class OperatoriaDiariaController {
	static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	def index(Integer max) {
		redirect(action: "list", params: params)
	}

	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[operatoriaDiariaInstanceList: OperatoriaDiaria.list(params), 
		 operatoriaDiariaInstanceTotal: OperatoriaDiaria.count()]
	}

	def show(OperatoriaDiaria operatoriaDiariaInstance) {
		respond operatoriaDiariaInstance
	}

	def create() {
		respond new OperatoriaDiaria(params)
	}

	@Transactional
	def save(OperatoriaDiaria operatoriaDiariaInstance) {
		if (operatoriaDiariaInstance == null) {
			notFound()
			return
		}

		if (operatoriaDiariaInstance.hasErrors()) {
			respond operatoriaDiariaInstance.errors, view:'create'
			return
		}

		//Se dan de alta los elementos asociados
		int productoOtorgadoCount = 0
		def productoOtorgadoAsString = params.get('productoOtorgadosList[' + productoOtorgadoCount + ']')
		while(productoOtorgadoAsString!=null) {
			ProductoOtorgado productoOtorgado = new ProductoOtorgado(params.get('productoOtorgadosList[' + productoOtorgadoCount + ']'))
			operatoriaDiariaInstance.addToProductosOtorgados(productoOtorgado)
			productoOtorgadoCount++
			productoOtorgadoAsString = params.get('productoOtorgadosList[' + productoOtorgadoCount + ']')
		}

		operatoriaDiariaInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [
					message(code: 'operatoriaDiaria.label', default: 'OperatoriaDiaria'),
					operatoriaDiariaInstance.id
				])
				redirect operatoriaDiariaInstance
			}
			'*' { respond operatoriaDiariaInstance, [status: CREATED] }
		}
	}

	def edit(OperatoriaDiaria operatoriaDiariaInstance) {
		respond operatoriaDiariaInstance
	}

	@Transactional
	def update(OperatoriaDiaria operatoriaDiariaInstance) {
		if (operatoriaDiariaInstance == null) {
			notFound()
			return
		}

		if (operatoriaDiariaInstance.hasErrors()) {
			respond operatoriaDiariaInstance.errors, view:'edit'
			return
		}

		operatoriaDiariaInstance.properties = params

		int productoOtorgadoCount = 0
		def productoOtorgadoParams = params.get('productoOtorgadosList[' + productoOtorgadoCount + ']')
		while(productoOtorgadoParams!=null) {
			def productoOtorgado = ProductoOtorgado.get(productoOtorgadoParams['id'])
			if (productoOtorgadoParams['deleted'].equals("true")) {
				//Baja
				operatoriaDiariaInstance.productosOtorgados.remove(productoOtorgado)
			}
			else {
				if (productoOtorgado) {
					//Actualización
					productoOtorgado.properties=productoOtorgadoParams
				}
				else {
					//Alta
					productoOtorgado = new ProductoOtorgado(params.get('productoOtorgadosList[' + productoOtorgadoCount + ']'))
					operatoriaDiariaInstance.addToProductosOtorgados(productoOtorgado)
				}
			}
			productoOtorgadoCount++
			productoOtorgadoParams = params.get('productoOtorgadosList[' + productoOtorgadoCount + ']')
		}

		operatoriaDiariaInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [
					message(code: 'OperatoriaDiaria.label', default: 'OperatoriaDiaria'),
					operatoriaDiariaInstance.id
				])
				redirect operatoriaDiariaInstance
			}
			'*'{ respond operatoriaDiariaInstance, [status: OK] }
		}
	}

	@Transactional
	def delete(OperatoriaDiaria operatoriaDiariaInstance) {

		if (operatoriaDiariaInstance == null) {
			notFound()
			return
		}

		operatoriaDiariaInstance.delete flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [
					message(code: 'OperatoriaDiaria.label', default: 'OperatoriaDiaria'),
					operatoriaDiariaInstance.id
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
					message(code: 'operatoriaDiaria.label', default: 'OperatoriaDiaria'),
					params.id
				])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}
