package ar.com.campochico

import grails.test.mixin.TestFor;
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@TestFor(VisitaClienteService)
@grails.test.mixin.Mock(VisitaCliente)
class VisitaClienteServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "resumen de cuenta test"() {
		given: "Lista de visitas al cliente"
			List<VisitaCliente> visitas = createVisitasCliente()
			Cliente cliente = Cliente.findBy
        when: "service is called"
		  //"service" represents the grails service you are testing for
			//TODO: Seguir.
		  service.getResumenCuenta(null, null, null)

	  then: "Expect something to happen"
		  //Assertion goes here
    }
	
	private def createVisitasCliente(){
		
		return users //List<User>
   }
}


