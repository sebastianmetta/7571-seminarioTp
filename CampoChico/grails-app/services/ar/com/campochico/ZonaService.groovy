package ar.com.campochico


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.joda.time.LocalDate
import org.springframework.transaction.annotation.Transactional

class ZonaService {

	//Export plugin
	def exportService
	def grailsApplication  //inject GrailsApplication

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

	/**
	 * @return la Zona correspondiente a la fecha o <code>null</code> si no hay definida una zona.
	 */
	def exportClientsListByDateToOutputStream(HttpServletResponse servletResponse, LocalDate localDate, String exportFormat, String exportExtension) {
		servletResponse.contentType = grailsApplication.config.grails.mime.types[exportFormat]
		servletResponse.setHeader("Content-disposition", "attachment; filename=Clientes.${exportExtension}")

		Date fecha
		Cliente cliente
		List productosVendidos = new ArrayList()
		double importeCobrado
		double importeAdeudado
		String observaciones

		List fields = [
			"nombre",
			"direccion",
			"telefono",
			"contacto",
			"Cobrado",
			"Adeudado",
			"Productos Vendidos",
			"Observaciones"
		]
		Map labels = ["nombre":"Nombre", "direccion":"Dirección", "telefono":"Teléfono", "contacto":"Contacto"]
		// Formatter closure
		def upperCase = { domain, value ->
			return value.toUpperCase()
		}
		Map formatters = [nombre: upperCase]
		//Map parameters = [title: "Clientes correspondientes a ${localDate}" , "column.widths": [0.3, 0.5, 0.2, 0.2, 0.1]]
		Map parameters = [title: "Hoja De  Ruta ${localDate}"]

		exportService.export(exportFormat, servletResponse.outputStream, this.zoneClients(localDate), fields, labels, formatters, parameters)
		[ clientsInstanceList: this.zoneClients(localDate) ]

	}

}
