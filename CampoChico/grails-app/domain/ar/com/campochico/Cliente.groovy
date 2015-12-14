package ar.com.campochico

import grails.plugin.mail.MailService;


/**
 * Modela un Cliente.
 * TODO: A futuro, modelar dirección como Value Object (Inmutable). 
		Con esto podremos facilitar la geolocalización de los clientes.
		Se deberan implementar metodos en esta clase como moverA(nuevaDireccion) 
 * @author sebastian
 *
 */
class Cliente {

	String nombre
	String direccion
	String telefono
	String contacto
	String mail
	int ordenDeVisita

	def mailService
	
	static constraints = {
		nombre blank: false, nullable: false
		direccion blank: false, nullable: false
		telefono blank: true, nullable: true
		contacto blank: true, nullable: true
		mail blank: true, nullable: true
		ordenDeVisita blank: false, nullable: false
	}
	
	@Override
	public String toString() {
		return "$nombre";
	}
	
	def intercambiarOrdenVisita(Cliente other) {
		if (other!=null) {
			int aux = this.getOrdenDeVisita()
			this.setOrdenDeVisita(other.getOrdenDeVisita())
			other.setOrdenDeVisita(aux)
		}
	}
	
	def enviarAvisoNoVisita(String contenidoMensaje) {
		mailService.sendMail {
			to mail 
			//subject ['advice.mail.subject.noVisit']
			subject "Asunto de prueba"
			body contenidoMensaje
		}
	}
	
	def enviarRecordatorioDeuda(String contenidoMensaje) {
		mailService.sendMail {
			to mail
			//subject ['advice.mail.subject.debt']
			subject "Asunto de prueba"
			body contenidoMensaje
		 }
	}
}
