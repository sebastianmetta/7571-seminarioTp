package ar.com.campochico

/**
 * Un Vendedor es una persona responsable de un reparto.
 * @author sebastian
 *
 */
class Vendedor {
	String nombre
	String vehiculo
	
    static constraints = {
		nombre blank:false, nullable:false
		vehiculo blank:false, nullable:false
    }
	
	@Override
	public String toString() {
		return "[" + nombre + "," + vehiculo + "]";
	}
}
