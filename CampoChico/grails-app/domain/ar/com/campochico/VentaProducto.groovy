package ar.com.campochico

/**
 * Representa la venta de un producto a un cliente.
 * @author sebastian
 *
 */
class VentaProducto {

	Producto producto
	double cantidad
	double precioVentaUnitario

	//Entidad débil.
	static belongsTo = VisitaCliente

	static constraints = {
		producto blank:false, nullable:false
		cantidad blank:false, nullable:false
		precioVentaUnitario blank:false, nullable:false
	}
}