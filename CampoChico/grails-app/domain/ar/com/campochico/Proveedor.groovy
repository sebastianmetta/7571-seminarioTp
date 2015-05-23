package ar.com.campochico

class Proveedor {

	String nombre
	String telefono
	String direccion
	String contacto
	
    static constraints = {
		nombre blank:false, nullable:false
    }
}
