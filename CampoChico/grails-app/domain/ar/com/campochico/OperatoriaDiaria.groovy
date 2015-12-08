package ar.com.campochico

import java.util.List;
import org.joda.time.LocalDate

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
		//Restricción: No puede haber más de 1 operatoria diara por (fecha, vendedor) 
		vendedor blank:false, nullable:false, validator: { 
			//1er parametro: campo vendedor, 2do: instancia de op diaria, 3ro: Obj error
			val, obj, errors  ->
				def opDiaria = OperatoriaDiaria.withCriteria {
					eq('fecha', obj.fecha)
					eq('vendedor', val)
				  }
				if (opDiaria==null || opDiaria.isEmpty()) {
					return true
				} else {
					errors.reject(['operatoriaDiara.unique.fechaAndVendedor']) 
				}
			}
		dineroOtorgado blank:false
		maplesPerdida blank:false
		observaciones nullable:true
	}
	
	def setEmtpyValues() {
		this.fecha = new Date()
		this.vendedor = null
		this.dineroOtorgado=0
		this.maplesPerdida=0
		this.observaciones=['operatoriaDiara.not.foundByDate']
	}
	
	def registrarPerdida(int maplesPerdida){
		this.maplesPerdida+=maplesPerdida
	}

}
