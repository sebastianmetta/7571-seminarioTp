package ar.com.campochico

/**
 * Representa la compra de un producto a un proveedor.
 * @author sebastian
 *
 */
class CompraProducto {

	Date fechaDeCompra
	Producto producto
	Proveedor proveedor
	BigDecimal precioCompra
	double candidad

	static constraints = {
		producto blank:false, nullable:false
		proveedor blank:false, nullable:false
		precioCompra blank:false, nullable:false
		fechaDeCompra blank:false, nullable:false
		cantidad blank:false, nullable:false
	}
}
