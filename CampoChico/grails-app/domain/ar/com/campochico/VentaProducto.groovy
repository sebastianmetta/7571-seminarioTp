package ar.com.campochico

class VentaProducto {

	Producto producto
	double cantidad
	double precioVentaUnitario

	static constraints = {
		producto blank:false, nullable:false
		cantidad blank:false, nullable:false
		precioVentaUnitario blank:false, nullable:false
	}
}
