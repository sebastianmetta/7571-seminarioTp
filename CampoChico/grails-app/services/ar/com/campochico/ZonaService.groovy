package ar.com.campochico


import org.joda.time.LocalDate
import org.springframework.transaction.annotation.Transactional

class ZonaService {

	/**
	 * @return la Zona correspondiente al día actual o <code>null</code> si no hay definida una zona.
	 */
	@Transactional(readOnly = true)
	def todayZoneName() {
		DiaVisitaCliente todayDay = DiaVisitaCliente.findByDia(new LocalDate().dayOfWeek().getAsText());
		if (todayDay) {			
			List<Zona> todayZone = Zona.withCriteria {
				diasVisita {
					eq('id', todayDay.getId())
				}
			}
			return todayZone.first().getNombre()
		}
		return null;
	}

	/**
	 * @return lista de Clientes correspondientes a la zona del día actual
	 */
	@Transactional(readOnly = true)
	def todayClients() {
		DiaVisitaCliente todayDay = DiaVisitaCliente.findByDia(new LocalDate().dayOfWeek().getAsText());
		if (todayDay) {
			List<Zona> todayZone = Zona.withCriteria {
				diasVisita {
					eq('id', todayDay.getId())
				}
			}
			return todayZone.first().getClientes()
		}
		return null;
	}
}
