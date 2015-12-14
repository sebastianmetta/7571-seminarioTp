package ar.com.campochico

import org.codehaus.groovy.util.HashCodeHelper;

class Producto {
	String nombre
	String descripcion
	
	static constraints = {
		nombre blank:false, nullable:false, unique: true
		descripcion blank:true, nullable:true
	}
    
	@Override
	public String toString() {
		return nombre;
	}
	

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
//		return result;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this.is(obj))
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Producto other = (Producto) obj;
//		if (nombre == null) {
//			if (other.nombre != null)
//				return false;
//		} else if (!nombre.equals(other.nombre))
//			return false;
//		return true;
//	}

	/*
	 * Uso implementación de hashCode y equals explicada por la cátedra:
	 * https://github.com/Nuevas-Tecnologias-FIUBA/grails-user-type/blob/master/grails-app/domain/user/type/Usuario.groovy
	 */
	
	boolean equals(Object o) {
		if (o == null) false
		else if (o.is(this)) true
		// usamos instanceof y no comparación de clases ya que hibernate en algunos casos crea clases
		// on the fly para hacer proxys y en ese caso no matchearían las clases
		else if (!(o instanceof Producto)) false
		else this.nombre == o.nombre
	}

	int hashCode() {
		int hc = HashCodeHelper.initHash()
		hc = HashCodeHelper.updateHash(hc, nombre)
		hc
	}
	
	
	
}
