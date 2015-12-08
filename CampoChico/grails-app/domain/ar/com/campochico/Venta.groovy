package ar.com.campochico

import groovy.transform.ToString;

/**
 * Modela la venta de un producto a un cliente.</br>
 * Una venta 
 * 
 * @author sebastian
 */
@ToString(includeNames=false,includePackage=false)
class Venta {

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