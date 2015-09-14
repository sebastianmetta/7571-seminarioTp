package ar.com.campochico

import groovy.transform.ToString;

/**
 * Representa la venta de un producto a un cliente.
 * @author sebastian
 *
 */
@ToString(includeNames=false,includePackage=false)
class VentaProducto {

	Producto producto
	Proveedor proveedor
	double cantidad
	double precioVentaUnitario
	boolean deleted

	//Entidad débil.
	static belongsTo = VisitaCliente

	static transients = [ 'deleted' ]
	
	static constraints = {
		producto blank:false, nullable:false
		proveedor blank:false, nullable:false
		cantidad blank:false, nullable:false
		precioVentaUnitario blank:false, nullable:false
	}
	
}