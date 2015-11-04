package ar.com.campochico

import java.util.List;

import groovy.transform.ToString;

@ToString(includeNames=false,includePackage=false)
class OperatoriaDiaria {
	Date fecha
	Vendedor vendedor
	List productosOtorgados = new ArrayList()
	double dineroOtorgado
	String observaciones

	static hasMany = [productosOtorgados: ProductoOtorgado]

	static mapping = { productosOtorgados cascade:"all-delete-orphan" }

	static constraints = {
		fecha blank:false, nullable:false
		vendedor blank:false, nullable:false
		dineroOtorgado blank:false, nullable:false
		observaciones nullable:true
	}
}
