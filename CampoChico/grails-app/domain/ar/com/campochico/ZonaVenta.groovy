package ar.com.campochico

/**
 * Representa una Zona de ventas a clientes 
 * @author sebastian
 */
class ZonaVenta {

	String nombre
	List diasVisita
	List clientes
	Vendedor vendedor
	
	static hasMany = [
		diasVisita: DiaVisitaCliente,
		clientes: Cliente
	]
	
	static constraints = {
		nombre blank:false, nullable:false, unique:true
		vendedor blank:false, nullable:false
	}

	@Override
	public String toString() {
		return "Zona [nombre=" + nombre + "]";
	}
	
	def enviarAvisoNoVisitaClientes(String contenidoMensaje){
		for (Cliente eachCliente: clientes) {
			eachCliente.enviarAvisoNoVisita(contenidoMensaje)
		}
	}
	
}