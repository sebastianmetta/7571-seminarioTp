package ar.com.campochico

class Role {
	public static String ROL_ADMINISTRADOR = "Administrador"
	public static String ROL_EMPLEADO = "Empleado"
	public static String ROL_GERENTE = "Gerente"

	String name

	static hasMany = [ users: User, permissions: String ]
	static belongsTo = User

	static constraints = {
		name(nullable: false, blank: false, unique: true)
	}

	String toString(){
		return name
	}
}
