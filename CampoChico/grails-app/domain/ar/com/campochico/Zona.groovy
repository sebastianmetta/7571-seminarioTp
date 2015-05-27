package ar.com.campochico

class Zona {

	String nombre
	static hasMany = [
		clientes: Cliente,
		diasVisita: DiaVisitaCliente
	]

	static constraints = {
		nombre blank:false, nullable:false
		
		clientes(validator: { val, obj ->
			def retval = true
			if (!obj?.clientes?.size()) {
			  retval = 'La zona debe tener al menos 1 cliente'
			}
			return retval
		  })
		
		diasVisita(validator: { val, obj ->
			def retval = true
			if (!obj?.diasVisita?.size()) {
			  retval = 'La zona debe tener al menos 1 día de visita'
			}
			return retval
		  })
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}