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
	
	def enviarRecordatorioDeuda() {
		//TODO: Utilizando la dirección de correo, se envía mail al 
		//cliente recordandole que tiene una deuda.
	}
	
	def intercambiarOrdenVisita(Cliente other) {
		if (other!=null) {
			int aux = this.getOrdenDeVisita()
			this.setOrdenDeVisita(other.getOrdenDeVisita())
			other.setOrdenDeVisita(aux)
		}
	}
	
	def enviarAvisoNoVisita() {
		//TODO: Utilizando la dirección de correo, se envía mail al
		//cliente avisandole que no se le visitará en el día actual.
	}
}
