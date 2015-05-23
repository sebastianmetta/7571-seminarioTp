package ar.com.campochico

class Producto {

	String nombre
	
    static constraints = {
		nombre blank:false, nullable:false
    }
}
