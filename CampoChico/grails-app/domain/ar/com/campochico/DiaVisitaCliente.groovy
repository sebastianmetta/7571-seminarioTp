package ar.com.campochico

class DiaVisitaCliente {
	String dia
    static constraints = {
		dia blank:false, nullable:false
    }
	
	@Override
	public String toString() {
		return dia;
	}
}
