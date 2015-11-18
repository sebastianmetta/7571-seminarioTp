package ar.com.campochico

import java.util.List;

import groovy.transform.ToString;

@ToString(includeNames=false,includePackage=false)
class OperatoriaDiaria {
	Date fecha
	Vendedor vendedor
	List productosOtorgados = new ArrayList()
	double dineroOtorgado
	double maplesPerdida
	String observaciones

	static hasMany = [productosOtorgados: ProductoOtorgado]

	static mapping = { productosOtorgados cascade:"all-delete-orphan" }

	static constraints = {
		fecha blank:false, nullable:false
		vendedor blank:false, nullable:false
		dineroOtorgado blank:false, nullable:false
		maplesPerdida blank:false, nullable:false
		observaciones nullable:true
	}
	
	def setEmtpyValues() {
		this.fecha = new Date()
		this.vendedor = null
		this.dineroOtorgado=0
		this.maplesPerdida=0
		//TODO: Ver como obtener mensajes i18n
		//this.observaciones=message(code: "operatoriaDiaria.not.foundByDate")
		this.observaciones="No se ha creado la operatoria diaria de hoy"
	}
}
