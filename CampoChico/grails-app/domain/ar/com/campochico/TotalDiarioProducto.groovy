package ar.com.campochico

/**
 * Modela para un producto los resultados del dia respecto a las ventas.
 * @author sebastian
 *
 */
class TotalDiarioProducto {

	Producto producto
	double cantidadTotal
	double totalVenta
	double ganancia
	
    static constraints = {
		producto blank:false, nullable:false
		cantidadTotal blank:false, nullable:false
		totalVenta blank:false, nullable:false
		ganancia blank:false, nullable:false
    }
	
	def reset()  {
		cantidadTotal=0
		totalVenta=0
		ganancia=0
	}
	
	@Override
	public String toString() {
		return "Producto:" + producto + ", CantTotal:" + cantidadTotal+ ", TotVenta:" + totalVenta + ", Gcia:" + ganancia
	}
	
	def acumularVenta(VentaProducto ventaProducto) {
		if (ventaProducto.producto.equals(this.producto)) {
			this.cantidadTotal+=ventaProducto.cantidad
			this.totalVenta+=(ventaProducto.cantidad * ventaProducto.precioVentaUnitario)
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((producto == null) ? 0 : producto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.is(obj))
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TotalDiarioProducto other = (TotalDiarioProducto) obj;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}
	
}
