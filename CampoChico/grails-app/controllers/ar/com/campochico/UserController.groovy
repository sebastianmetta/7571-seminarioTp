package ar.com.campochico

import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.SecurityUtils
import ar.com.campochico.Role
import ar.com.campochico.User
import org.apache.shiro.crypto.hash.Sha256Hash

class UserController {

	def index() {
		User user = new User()
		[user: user]
	}

	def list() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[userInstanceList: User.list(params), userInstanceTotal: User.count()]
	}

	def show() {
		def userInstance = User.get(params.id)
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'user.label', default: 'user'),
				params.id
			])
			redirect(action: "list")
			return
		}

		[userInstance: userInstance]
	}


	def delete() {
		def userInstance = User.get(params.id)
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'user.label', default: 'user'),
				params.id
			])
			redirect(action: "list")
			return
		}

		try {
			userInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'user.label', default: 'user'),
				params.id
			])
			redirect(action: "list")
		}
		catch (Exception e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'user.label', default: 'user'),
				params.id
			])
			redirect(action: "show", id: params.id)
		}
	}

	def register() {

		// Comprobar si el usuario existe.
		def user = User.findByUsername(params.username)
		if (user) {
			flash.message = "Ya existe un usuario con el nombre '${params.username}', Por favor, elija otro nombre de usuario."
			redirect(action:'index')
		}

		// Creamos el usuario.
		else {

			if (params.password != params.password2) {
				flash.message = "Las contraseñas no coinciden"
				redirect(action:'index')
			}

			else {
				user = new User(
						username: params.username,
						passwordHash: new Sha256Hash(params.password).toHex()
						)

				if (user.save(flush:true)) {
					log.info("ROL SELECCIONADO: " + params.role)
					def userRole =  Role.findByName(params.role)
					user.addToRoles(userRole)
					user.save(flush:true)

					flash.message = "Usuario '${params.username}' con rol '${params.role}' creado con éxito."
					redirect(action:'index')
				}
				else {
					redirect(controller: 'auth', action: 'login')
				}
			}
		}
	}
}