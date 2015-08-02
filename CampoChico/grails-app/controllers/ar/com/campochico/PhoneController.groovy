package ar.com.campochico



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PhoneController {
	static scaffold = true
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Phone.list(params), model:[phoneInstanceCount: Phone.count()]
    }

    def show(Phone phoneInstance) {
        respond phoneInstance
    }

    def create() {
        respond new Phone(params)
    }

    @Transactional
    def save(Phone phoneInstance) {
        if (phoneInstance == null) {
            notFound()
            return
        }

        if (phoneInstance.hasErrors()) {
            respond phoneInstance.errors, view:'create'
            return
        }

        phoneInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'phone.label', default: 'Phone'), phoneInstance.id])
                redirect phoneInstance
            }
            '*' { respond phoneInstance, [status: CREATED] }
        }
    }

    def edit(Phone phoneInstance) {
        respond phoneInstance
    }

    @Transactional
    def update(Phone phoneInstance) {
        if (phoneInstance == null) {
            notFound()
            return
        }

        if (phoneInstance.hasErrors()) {
            respond phoneInstance.errors, view:'edit'
            return
        }

        phoneInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Phone.label', default: 'Phone'), phoneInstance.id])
                redirect phoneInstance
            }
            '*'{ respond phoneInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Phone phoneInstance) {

        if (phoneInstance == null) {
            notFound()
            return
        }

        phoneInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Phone.label', default: 'Phone'), phoneInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'phone.label', default: 'Phone'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
