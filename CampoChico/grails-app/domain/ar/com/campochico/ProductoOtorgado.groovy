package ar.com.campochico

class ProductoOtorgado {
	
	Producto producto
	double cantidad

	//Entidad débil.
	static belongsTo = OperatoriaDiaria

	static transients = [ 'deleted' ]
		
    static constraints = {
		producto blank:false, nullable:false
		cantidad blank:false, nullable:false
    }
	
	@Override
	public String toString() {
		return "[" + producto.nombre + ", " + cantidad + "]";
	}
}
