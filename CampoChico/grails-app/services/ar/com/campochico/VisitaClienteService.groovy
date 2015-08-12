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
	
//	def getClientVisitsByDate(Date dateTo) {
//		List visitasCliente = VisitaCliente.withCriteria {
//			eq('fecha', dateTo.clearTime())
//		}
//		return visitasCliente
//	}
	
}
