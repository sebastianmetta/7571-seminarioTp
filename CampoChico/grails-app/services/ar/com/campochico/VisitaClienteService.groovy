package ar.com.campochico

import grails.transaction.Transactional

@Transactional
class VisitaClienteService {

	/**
	 * Devuelve todas las Visitas a clientes para la fecha indicada
	 */
    def getClientVisitsByDia(Date fecha) {
		return VisitaCliente.findByFecha(fecha)
    }
	
	def getTodayClientVisits() {
		List visitasCliente = VisitaCliente.withCriteria {
			eq('fecha', new Date().clearTime())
		}
		return visitasCliente
    }
}
