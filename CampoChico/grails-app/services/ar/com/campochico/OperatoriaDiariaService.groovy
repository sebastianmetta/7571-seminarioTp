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
			//TODO: Averiguar como hacer un metodo estatico o cómo conviene reemplazarlo.
			toReturn = new OperatoriaDiaria()
			toReturn.setEmtpyValues()
		}
		return toReturn
	}

}
