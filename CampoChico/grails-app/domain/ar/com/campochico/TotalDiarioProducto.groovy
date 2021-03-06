package ar.com.campochico

import org.codehaus.groovy.util.HashCodeHelper;

/**
 * Modela para un producto los resultados del dia respecto a las ventas.
 */
class TotalDiarioProducto {

	Producto producto
	double cantidadTotal
	double totalVenta
	double costoUnitario
	double ganancia
	
    static constraints = {
		producto blank:false, nullable:false
		cantidadTotal blank:false, nullable:false
		totalVenta blank:false, nullable:false
		costoUnitario blank:false, nullable:false
		ganancia blank:false, nullable:false
    }
	
	def reset()  {
		cantidadTotal=0
		totalVenta=0
		costoUnitario=0
		ganancia=0
	}
	
	@Override
	public String toString() {
		return "Producto:" + producto + ", CantTotal:" + cantidadTotal+ ", TotVenta:" + totalVenta + ", CostoUnitario:" + costoUnitario + ", Gcia:" + ganancia
	}
	
	def acumularVenta(Venta ventaProducto) {
		if (ventaProducto.producto.equals(this.producto)) {
			this.cantidadTotal+=ventaProducto.cantidad
			this.totalVenta+=(ventaProducto.cantidad * ventaProducto.precioVentaUnitario)
		}
	}
	
	def calcularGanancia() {
		this.ganancia=(this.totalVenta) - (this.cantidadTotal * this.costoUnitario)
	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result
//				+ ((producto == null) ? 0 : producto.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this.is(obj))
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		TotalDiarioProducto other = (TotalDiarioProducto) obj;
//		if (producto == null) {
//			if (other.producto != null)
//				return false;
//		} else if (!producto.equals(other.producto))
//			return false;
//		return true;
//	}
	
	/*
	 * Uso implementación de hashCode y equals explicada por la cátedra:
	 * https://github.com/Nuevas-Tecnologias-FIUBA/grails-user-type/blob/master/grails-app/domain/user/type/Usuario.groovy
	 */
	
	boolean equals(Object o) {
		if (o == null) false
		else if (o.is(this)) true
		// usamos instanceof y no comparación de clases ya que hibernate en algunos casos crea clases
		// on the fly para hacer proxys y en ese caso no matchearían las clases
		else if (!(o instanceof TotalDiarioProducto)) false
		else this.producto.equals(o.producto)
	}

	int hashCode() {
		int hc = HashCodeHelper.initHash()
		hc = HashCodeHelper.updateHash(hc, producto.hashCode())
		hc
	}
}
