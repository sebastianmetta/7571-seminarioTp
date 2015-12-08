package ar.com.campochico

import groovy.transform.ToString;

import java.util.Date;

@ToString
class ResumenCuentaCliente {

	Date fecha
	String descripcion
	BigDecimal saldoDeudor
	BigDecimal saldoAcreedor
	BigDecimal saldo
	
    static constraints = {
		
    }
	
	
}
