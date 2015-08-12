package ar.com.campochico


import org.joda.time.LocalDate
import org.springframework.transaction.annotation.Transactional

class ZonaService {
	
	/**
	 * @return lista de Clientes correspondientes a la zona del día actual
	 */
	@Transactional(readOnly = true)
	def zoneClients(LocalDate localDate) {
		DiaVisitaCliente dayToSearch = DiaVisitaCliente.findByDia(localDate.dayOfWeek().getAsText());
		if (dayToSearch) {
			List<Zona> zoneToReturn = Zona.withCriteria {
				diasVisita {
					eq('id', dayToSearch.getId())
				}
			}
			return zoneToReturn.first().getClientes()
		}
		return null;
	}
	
	/**
	 * @return la Zona correspondiente a la fecha o <code>null</code> si no hay definida una zona.
	 */
	@Transactional(readOnly = true)
	def zoneName (LocalDate localDate) {
		DiaVisitaCliente dayToSearch = DiaVisitaCliente.findByDia(localDate.dayOfWeek().getAsText());
		if (dayToSearch) {
			List<Zona> zoneToReturn = Zona.withCriteria {
				diasVisita {
					eq('id', dayToSearch.getId())
				}
			}
			return zoneToReturn.first().getNombre()
		}
		return null;
	}
	
}
