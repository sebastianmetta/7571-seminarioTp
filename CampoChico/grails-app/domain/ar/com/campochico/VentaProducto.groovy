package ar.com.campochico

/**
 * Representa la venta de un producto a un cliente.
 * @author sebastian
 *
 */
class VentaProducto {

	//Producto producto
	Producto producto
	double cantidad
	double precioVentaUnitario
	boolean deleted

	//Entidad débil.
	static belongsTo = VisitaCliente

	static transients = [ 'deleted' ]
	
	static constraints = {
		producto blank:false, nullable:false
		cantidad blank:false, nullable:false
		precioVentaUnitario blank:false, nullable:false
	}

	@Override
	public String toString() {
		return producto.toString() + " - " + cantidad + " - " + precioVentaUnitario
	}	
	
}