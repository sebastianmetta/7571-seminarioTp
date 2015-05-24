package ar.com.campochico

/**
 * Representa la visita diaria a un cliente. 
 * @author sebastian
 *
 */
class VisitaCliente {
	Date fecha
	Cliente cliente
	static hasMany = [productosVendidos: VentaProducto]
	double importeCobrado
	double importeAdeudado
	String observaciones

	static constraints = {
		cliente blank:false, nullable:false
	}
}
