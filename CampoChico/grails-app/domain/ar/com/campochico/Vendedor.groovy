package ar.com.campochico

import groovy.transform.AutoClone;

/**
 * Modela un Vendedor, que es una persona responsable de un reparto.
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
		//TODO: A futuro se necesita calcular para un vendedor sus estadisticas de venta
		//ver si corresponde aca o en servicio.
	}
}
