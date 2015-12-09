package ar.com.campochico

import grails.transaction.Transactional


@Transactional
class OperatoriaDiariaService {

	/**
	 * Devuelve una lista de las Visitas a clientes para la fecha indicada o una instancia vacia si no hay datos. 
	 */
	def getOperatoriaDiariaByDate(Date fecha) {
		List toReturn = OperatoriaDiaria.withCriteria {
			eq('fecha', fecha.clearTime())
		}
		
		if (toReturn==null) {
			toReturn = new OperatoriaDiaria()
			toReturn.setEmtpyValues()
		}
		return toReturn
	}

	/**
	 * @return una lista de vendedores para los cuales en el dia actual no se cargó la operatoria diaria. 
	 * Si no hay cargas pendientes se devuelve una lista vacia. 
	 */
	def getTodayPendingLoad() {
		def toReturn = new ArrayList<Vendedor>()
		def now = new Date()
		now.clearTime()
		Vendedor.list().each { eachVendedor ->
			def operatoriaVendedor = OperatoriaDiaria.withCriteria { 
				between('fecha', now, now+1)
				eq('vendedor', eachVendedor)
     		}
			if (operatoriaVendedor == null || operatoriaVendedor.empty) {				
				toReturn.add(eachVendedor.clone())
			}
		}
		return toReturn
	}
}
