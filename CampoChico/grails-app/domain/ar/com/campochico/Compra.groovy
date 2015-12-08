package ar.com.campochico

/**
 * Representa la compra de un producto a un proveedor.
 * @author sebastian
 *
 */
class Compra {

	Date fechaDeCompra
	Producto producto
	Proveedor proveedor
	double precioUnitario
	double cantidad
	double total

	static constraints = {
		fechaDeCompra blank:false, nullable:false
		producto blank:false, nullable:false
		proveedor blank:false, nullable:false
		precioUnitario blank:false, nullable:false
		cantidad blank:false, nullable:false
		total blank:false, nullable:false
	}
}
