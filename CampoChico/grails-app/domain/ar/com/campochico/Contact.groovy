package ar.com.campochico

class Contact {

	static constraints = {
		firstName(blank:false)
		lastName(blank:false)
	}

	String firstName
	String lastName
	String nickName
	List phones = new ArrayList()
	static hasMany = [ phones:Phone ]

	static mapping = { phones cascade:"all-delete-orphan" }

	def getPhonesList() {
		//return LazyList.decorate(phones, FactoryUtils.instantiateFactory(Phone.class))
		return phones
	}

	def String toString() {
		return "${lastName}, ${firstName}"
	}
}
