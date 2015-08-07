package ar.com.campochico



import static org.springframework.http.HttpStatus.*
import ar.com.campochico.Phone.PhoneType;
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ContactController {
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index(Integer max) {
		redirect(action: "list", params: params)
	}

	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[contactInstanceList: Contact.list(params), contactInstanceTotal: Contact.count()]
	}

	def show(Contact contactInstance) {
		respond contactInstance
	}

	def create() {
		respond new Contact(params)
	}

	@Transactional
	def save(Contact contactInstance) {
		if (contactInstance == null) {
			notFound()
			return
		}

		if (contactInstance.hasErrors()) {
			respond contactInstance.errors, view:'create'
			return
		}

		//Se dan de alta los elementos asociados
		int phoneCount = 0
		def phoneAsString = params.get('phonesList[' + phoneCount + ']')
		while(phoneAsString!=null) {
			Phone phone = new Phone(params.get('phonesList[' + phoneCount + ']'))
			contactInstance.addToPhones(phone)
			phoneCount++
			phoneAsString = params.get('phonesList[' + phoneCount + ']')
		}

		contactInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [
					message(code: 'contact.label', default: 'Contact'),
					contactInstance.id
				])
				redirect contactInstance
			}
			'*' { respond contactInstance, [status: CREATED] }
		}
	}

	def edit(Contact contactInstance) {
		respond contactInstance
	}

	@Transactional
	def update(Contact contactInstance) {
		if (contactInstance == null) {
			notFound()
			return
		}

		if (contactInstance.hasErrors()) {
			respond contactInstance.errors, view:'edit'
			return
		}

		contactInstance.properties = params

		//Ejemplo de lo que viene en params -> [id:1, deleted:false, new:false, number:47120867, type:H]
		int phoneCount = 0
		def phoneParams = params.get('phonesList[' + phoneCount + ']')
		while(phoneParams!=null) {
			def phone = Phone.get(phoneParams['id'])
			if (phoneParams['deleted'].equals("true")) {				
				//Baja
				contactInstance.phones.remove(phone)
			}
			else {
				if (phone) {					
					//Actualización
					phone.properties=phoneParams
				}
				else {
					//Alta
					phone = new Phone(params.get('phonesList[' + phoneCount + ']'))
					contactInstance.addToPhones(phone)
				}
			}
			phoneCount++
			phoneParams = params.get('phonesList[' + phoneCount + ']')
		}

		contactInstance.save flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.updated.message', args: [
					message(code: 'Contact.label', default: 'Contact'),
					contactInstance.id
				])
				redirect contactInstance
			}
			'*'{ respond contactInstance, [status: OK] }
		}
	}

	@Transactional
	def delete(Contact contactInstance) {

		if (contactInstance == null) {
			notFound()
			return
		}

		contactInstance.delete flush:true

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.deleted.message', args: [
					message(code: 'Contact.label', default: 'Contact'),
					contactInstance.id
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
					message(code: 'contact.label', default: 'Contact'),
					params.id
				])
				redirect action: "index", method: "GET"
			}
			'*'{ render status: NOT_FOUND }
		}
	}
}
