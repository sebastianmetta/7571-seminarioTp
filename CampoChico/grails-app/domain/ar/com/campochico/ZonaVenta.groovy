package ar.com.campochico

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate

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
		nombre blank:false, nullable:false
		vendedor blank:false, nullable:false
	}

	@Override
	public String toString() {
		return "Zona [nombre=" + nombre + "]";
	}
	
	def enviarAvisoNoVisitaClientes(){
		for (Cliente eachCliente: clientes) {
			eachCliente.enviarAvisoNoVisita()
		}
	}
	
}