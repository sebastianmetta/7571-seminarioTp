package ar.com.campochico

class Zona {
	String nombre
	static hasMany = [clientes: Cliente]

	static constraints = {
		nombre blank:false, nullable:false
	}
}
