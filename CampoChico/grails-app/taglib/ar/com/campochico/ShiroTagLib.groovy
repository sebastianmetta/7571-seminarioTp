package ar.com.campochico
import org.apache.shiro.SecurityUtils

class ShiroTagLib {

	static namespace = "shiroui"

	def roleSelect = {attrs->
		def allRoles = Role.list()
		if (allRoles) {
		out << g.select(name:attrs.name, optionKey:'id', from:allRoles, multiple:true, size:(attrs.size ?: 10), value:(attrs.value ?: []), noSelection:['':''], 'class':"many-to-many")
		} else {
			out << "<i>-</i>"
		}
	}

}
