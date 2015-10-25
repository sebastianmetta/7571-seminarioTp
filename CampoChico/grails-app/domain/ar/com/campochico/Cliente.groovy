package ar.com.campochico

class Cliente {

	String nombre
	String direccion
	String telefono
	String contacto
	String mail
	int ordenDeVisita

	static constraints = {
		nombre blank: false, nullable: false
		direccion blank: false, nullable: false
		telefono blank: true, nullable: true
		contacto blank: true, nullable: true
		mail blank: true, nullable: true
		ordenDeVisita blank: false, nullable: false
	}
	
	@Override
	public String toString() {
		return "$nombre";
	}
}
