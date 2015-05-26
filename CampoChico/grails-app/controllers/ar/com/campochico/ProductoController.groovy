package ar.com.campochico

import org.springframework.dao.DataIntegrityViolationException

class ProductoController {
	static scaffold = true 
    static allowedMethods = [create: ['GET', 'POST'], edit: ['GET', 'POST'], delete: 'POST']

    def create() {
		switch (request.method) {
		case 'GET':
        	[productoInstance: new Producto(params)]
			break
		case 'POST':
	        def productoInstance = new Producto(params)
	        if (!productoInstance.save(flush: true)) {
	            render view: 'create', model: [productoInstance: productoInstance]
	            return
	        }

			flash.message = message(code: 'default.created.message', args: [message(code: 'producto.label', default: 'Producto'), productoInstance.id])
	        redirect action: 'show', id: productoInstance.id
			break
		}
    }

    def show() {
        def productoInstance = Producto.get(params.id)
        if (!productoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'producto.label', default: 'Producto'), params.id])
            redirect action: 'list'
            return
        }

        [productoInstance: productoInstance]
    }

    def edit() {
		switch (request.method) {
		case 'GET':
	        def productoInstance = Producto.get(params.id)
	        if (!productoInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'producto.label', default: 'Producto'), params.id])
	            redirect action: 'list'
	            return
	        }

	        [productoInstance: productoInstance]
			break
		case 'POST':
	        def productoInstance = Producto.get(params.id)
	        if (!productoInstance) {
	            flash.message = message(code: 'default.not.found.message', args: [message(code: 'producto.label', default: 'Producto'), params.id])
	            redirect action: 'list'
	            return
	        }

	        if (params.version) {
	            def version = params.version.toLong()
	            if (productoInstance.version > version) {
	                productoInstance.errors.rejectValue('version', 'default.optimistic.locking.failure',
	                          [message(code: 'producto.label', default: 'Producto')] as Object[],
	                          "Another user has updated this Producto while you were editing")
	                render view: 'edit', model: [productoInstance: productoInstance]
	                return
	            }
	        }

	        productoInstance.properties = params

	        if (!productoInstance.save(flush: true)) {
	            render view: 'edit', model: [productoInstance: productoInstance]
	            return
	        }

			flash.message = message(code: 'default.updated.message', args: [message(code: 'producto.label', default: 'Producto'), productoInstance.id])
	        redirect action: 'show', id: productoInstance.id
			break
		}
    }

    def delete() {
        def productoInstance = Producto.get(params.id)
        if (!productoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'producto.label', default: 'Producto'), params.id])
            redirect action: 'list'
            return
        }

        try {
            productoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'producto.label', default: 'Producto'), params.id])
            redirect action: 'list'
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'producto.label', default: 'Producto'), params.id])
            redirect action: 'show', id: params.id
        }
    }
}
