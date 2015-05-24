package ar.com.campochico

class Zona {
	String nombre
	static hasMany = [
		clientes: Cliente,
		diasVisita: DiaVisitaCliente
	]

	static constraints = {
		nombre blank:false, nullable:false
	}
}
