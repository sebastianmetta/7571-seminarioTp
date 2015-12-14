package ar.com.campochico

class Proveedor {

	String nombre
	String telefono
	String direccion
	String contacto
	String email
	
    static constraints = {
		nombre blank:false, nullable:false
		telefono blank:true, nullable:true
		direccion blank:true, nullable:true
		contacto blank:true, nullable:true
		email blank: true, nullable: true
    }
	
	@Override
	public String toString() {
		return nombre;
	}
	
	def pedirProducto(Producto producto, double cantidad, Date fechaRequerida) {
		//TODO: A implementar a futuro: Se envía mail con el pedido y se deben proveer metodos para el seguimiento del pedido.
	}
}
