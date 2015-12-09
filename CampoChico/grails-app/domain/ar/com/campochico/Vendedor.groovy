package ar.com.campochico

import groovy.transform.AutoClone;

/**
 * Un Vendedor es una persona responsable de un reparto.
 * @author sebastian
 *
 */
@AutoClone
class Vendedor {
	String nombre
	String vehiculo
	
    static constraints = {
		nombre blank:false, nullable:false
		vehiculo blank:false, nullable:false
    }
	
	@Override
	public String toString() {
		return nombre;
	}
	
	def calcularEstadisticasVenta(Date fechaDesde, Date fechaHasta) {
		//TODO: ver si corresponde aca o en servicio.
	}
}
