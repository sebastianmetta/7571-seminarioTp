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
	
	/**
	 * Devuelve el costo del producto asociado al proveedor
	 * @param producto
	 * @param proveedor
	 * @return
	 */
	public static Double getCostoProductoProveedor(Producto producto, Proveedor proveedor) {
		List<Compra> compraProductoList = Compra.withCriteria {
			eq('producto', producto)
			eq('proveedor', proveedor)
			order('fechaDeCompra','desc')
		}
		if (compraProductoList!=null && !compraProductoList.isEmpty()) {
			return compraProductoList.first().precioUnitario
		} else {
			return 0
		}
	}
}
