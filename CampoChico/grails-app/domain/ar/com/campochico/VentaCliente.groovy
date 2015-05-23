package ar.com.campochico

class VentaCliente {

	Date fecha
	Cliente cliente
	List<VentaProducto> ventasProductos
	double importeCobrado
	double importeAdeudado
	
    static constraints = {
    }
}
