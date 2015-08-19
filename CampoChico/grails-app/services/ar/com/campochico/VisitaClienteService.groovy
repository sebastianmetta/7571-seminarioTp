package ar.com.campochico

import grails.transaction.Transactional

@Transactional
class VisitaClienteService {

	/**
	 * Devuelve todas las Visitas a clientes para la fecha indicada
	 */
	def getClientVisitsByDate(Date fecha) {
		List visitasCliente = VisitaCliente.withCriteria {
			eq('fecha', fecha.clearTime())
		}
		return visitasCliente
	}
	
}
