package ar.com.campochico

/**
 * Representa la visita diaria a un cliente. 
 * @author sebastian
 *
 */
class VisitaCliente {
	Date fecha
	Cliente cliente
	List productosVendidos = new ArrayList()
	double importeCobrado
	double importeAdeudado
	String observaciones
	
	static mapping = { productosVendidos cascade:"all-delete-orphan" }
	
	static hasMany = [productosVendidos: Venta]

	static constraints = {
		fecha blank:false, nullable:false
		cliente blank:false, nullable:false
		observaciones nullable:true
	}
	
	@Override
	public String toString() {
		return "Fecha $fecha - Cliente: $cliente";
	}
	
	/**
	 * devuelve una lista de VentaProducto correspondientes al proveedor.
	 * @param proveedor
	 * @return
	 */
	def getProductosVendidosByProveedor(Proveedor proveedor) {
		List productos = Venta.withCriteria {
			eq('proveedor', proveedor)
		}
		return productos
	}
}