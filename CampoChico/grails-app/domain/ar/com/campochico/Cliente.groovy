package ar.com.campochico

class Cliente {

	String nombre
	String direccion
	String telefono
	String contacto
	String mail

	static constraints = {
		nombre blank: false, nullable: false
		direccion blank: false, nullable: false
	}
}
