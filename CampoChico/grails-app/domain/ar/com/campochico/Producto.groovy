package ar.com.campochico

class Producto {
	String nombre
	String descripcion
	
	static constraints = {
		nombre blank:false, nullable:false
		descripcion blank:true, nullable:true
	}
    
}
