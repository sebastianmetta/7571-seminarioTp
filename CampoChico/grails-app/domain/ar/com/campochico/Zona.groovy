package ar.com.campochico

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate

/**
 * Representa una Zona de clientes 
 * @author sebastian
 */
class Zona {

	String nombre
	List diasVisita
	List clientes
	
	static hasMany = [
		diasVisita: DiaVisitaCliente,
		clientes: Cliente
	]

	static constraints = {
		nombre blank:false, nullable:false
	}

	@Override
	public String toString() {
		return "Zona [nombre=" + nombre + "]";
	}
	
}