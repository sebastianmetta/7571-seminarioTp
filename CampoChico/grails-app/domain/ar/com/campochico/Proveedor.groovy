package ar.com.campochico

class Proveedor {

	String nombre
	String telefono
	String direccion
	String contacto
	
    static constraints = {
		nombre blank:false, nullable:false
		telefono blank:true, nullable:true
		direccion blank:true, nullable:true
		contacto blank:true, nullable:true
    }
	
	@Override
	public String toString() {
		return nombre;
	}
}
