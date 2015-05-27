
import ar.com.campochico.Cliente
import ar.com.campochico.DiaVisitaCliente
import ar.com.campochico.Producto
import ar.com.campochico.Proveedor
import grails.util.Environment

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

class BootStrap {

	private static final Log log = LogFactory.getLog(this)

	def init = { servletContext ->
		log.info('Inicializando datos de la aplicación...')
		new DiaVisitaCliente(dia:'Lunes').save();
		new DiaVisitaCliente(dia:'Martes').save();
		new DiaVisitaCliente(dia:'Miércoles').save();
		new DiaVisitaCliente(dia:'Jueves').save();
		new DiaVisitaCliente(dia:'Viernes').save();
		new DiaVisitaCliente(dia:'Sábado').save();
		
		if ((Environment.current == Environment.DEVELOPMENT) ||
			(Environment.current == Environment.TEST)) {
			new Cliente(nombre: 'Cliente 0',direccion: 'Dirección cliente 0',contacto: 'Contacto cliente 0').save()
			new Cliente(nombre: 'Cliente 1',direccion: 'Dirección cliente 1',contacto: 'Contacto cliente 1').save()
			new Cliente(nombre: 'Cliente 2',direccion: 'Dirección cliente 2',contacto: 'Contacto cliente 2').save()
			new Cliente(nombre: 'Cliente 3',direccion: 'Dirección cliente 3',contacto: 'Contacto cliente 3').save()
			new Cliente(nombre: 'Cliente 4',direccion: 'Dirección cliente 4',contacto: 'Contacto cliente 4').save()
			new Cliente(nombre: 'Cliente 5',direccion: 'Dirección cliente 5',contacto: 'Contacto cliente 5').save()
			new Cliente(nombre: 'Cliente 6',direccion: 'Dirección cliente 6',contacto: 'Contacto cliente 6').save()
			new Cliente(nombre: 'Cliente 7',direccion: 'Dirección cliente 7',contacto: 'Contacto cliente 7').save()
			new Cliente(nombre: 'Cliente 8',direccion: 'Dirección cliente 8',contacto: 'Contacto cliente 8').save()
			new Cliente(nombre: 'Cliente 9',direccion: 'Dirección cliente 9',contacto: 'Contacto cliente 9').save()
			
			new Proveedor(nombre: 'Rimasa', direccion: 'Dirección Rimasa', contacto: 'Contacto Rimasa').save()
			new Proveedor(nombre: 'Beroch', direccion: 'Dirección Beroch', contacto: 'Contacto Beroch').save()
			
			new Producto(nombre: 'CAJ BCO 1', descripcion: 'Cajón huevo blanco nro 1').save()
			new Producto(nombre: 'CAJ BCO 2', descripcion: 'Cajón huevo blanco nro 2').save()
			new Producto(nombre: 'CAJ SUPER', descripcion: 'Cajón huevo súper').save()
			new Producto(nombre: 'CAJ COLOR', descripcion: 'Cajón huevo color').save()
			new Producto(nombre: 'MAPLE', descripcion: 'Maple').save()
		}
	}
	def destroy = {
	}
}
