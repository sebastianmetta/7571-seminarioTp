package ar.com.campochico


import org.joda.time.LocalDate
import org.springframework.transaction.annotation.Transactional

class ZonaService {

	/**
	 * @return la Zona correspondiente al día actual.
	 */
	@Transactional(readOnly = true)	
    def todayZone() {
		String todayDay = new LocalDate().dayOfWeek().getAsText()
		List<Zona> todayZone = Zona.withCriteria {
			diasVisita {
				eq('id', DiaVisitaCliente.findByDia(todayDay).getId())
			}
		}
		return todayZone.first()
    }
	
	/**
	 * @return lista de Clientes correspondientes a la zona del día actual
	 */
	@Transactional(readOnly = true)
	def todayClients() {
		String todayDay = new LocalDate().dayOfWeek().getAsText()
		List<Zona> todayZone = Zona.withCriteria {
			diasVisita {
				eq('id', DiaVisitaCliente.findByDia(todayDay).getId())
			}
		}
		return todayZone.first().getClientes()
	}
	
}
