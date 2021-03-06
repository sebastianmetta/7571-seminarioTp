
import ar.com.campochico.Compra;
import ar.com.campochico.Role;
import ar.com.campochico.User
import ar.com.campochico.Cliente
import ar.com.campochico.DiaVisitaCliente;
import ar.com.campochico.Producto
import ar.com.campochico.Proveedor
import ar.com.campochico.Vendedor;
import ar.com.campochico.ZonaVenta;
import grails.util.Environment

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate

class BootStrap {

	private static final Log log = LogFactory.getLog(this)

	def init = { servletContext ->
		log.info('Inicializando datos de la aplicación...')

		//Vendedores
		def vendedor1 = new Vendedor(nombre:"Luis Alberto Spinetta", vehiculo:"Camioneta1").save(flush:true)
		def vendedor2 = new Vendedor(nombre:"Jimi Hendrix", vehiculo:"Camioneta2").save(flush:true)
		
		//Roles
		def adminRole = new Role(name: Role.ROL_ADMINISTRADOR)
		adminRole.addToPermissions("*:*")
		adminRole.save(flush:true, failOnError:true)

		def empleadoRole = new Role(name:Role.ROL_EMPLEADO)
		empleadoRole.addToPermissions("Index:*")
		empleadoRole.addToPermissions("Cliente:*")
		empleadoRole.addToPermissions("CompraProducto:*")
		empleadoRole.addToPermissions("HojaDeRuta:*")
		empleadoRole.addToPermissions("Producto:*")
		empleadoRole.addToPermissions("Proveedor:*")
		empleadoRole.addToPermissions("VentaProducto:*")
		empleadoRole.addToPermissions("VisitaCliente:*")
		empleadoRole.addToPermissions("Zona:*")
		empleadoRole.addToPermissions("OperatoriaDiaria:*")
		empleadoRole.addToPermissions("AvisoNoVisita:*")
		empleadoRole.addToPermissions("AvisoDeuda:*")
		empleadoRole.save(flush:true, failOnError:true)

		def gerenteRole = new Role(name:Role.ROL_GERENTE)
		gerenteRole.addToPermissions("Index:*")
		gerenteRole.addToPermissions("Cliente:*")
		gerenteRole.addToPermissions("CompraProducto:*")
		gerenteRole.addToPermissions("HojaDeRuta:*")
		gerenteRole.addToPermissions("Producto:*")
		gerenteRole.addToPermissions("Proveedor:*")
		gerenteRole.addToPermissions("VentaProducto:*")
		gerenteRole.addToPermissions("VisitaCliente:*")
		gerenteRole.addToPermissions("Zona:*")
		gerenteRole.addToPermissions("OperatoriaDiaria:*")
		gerenteRole.addToPermissions("AvisoNoVisita:*")
		gerenteRole.addToPermissions("AvisoDeuda:*")
		//Reportes
		gerenteRole.addToPermissions("ResumenCuentaCliente:*")
		gerenteRole.addToPermissions("TotalesDiarios:*")
		gerenteRole.save(flush:true, failOnError:true)

		//Usuario administrador
		def adminUser = new User(username: "admin", passwordHash: new Sha256Hash("admin").toHex())
		adminUser.addToRoles(adminRole)
		adminUser.save(flush:true, failOnError:true)

		//Usuarios empleados
		def empleadoUser = new User(username: "empleado", passwordHash: new Sha256Hash("empleado").toHex())
		empleadoUser.addToRoles(empleadoRole)
		empleadoUser.save(flush:true, failOnError:true)

		//Usuarios gerentes
		def gerenteUser = new User(username: "gerente", passwordHash: new Sha256Hash("gerente").toHex())
		gerenteUser.addToRoles(gerenteRole)
		gerenteUser.save(flush:true, failOnError:true)


		if ((Environment.current == Environment.DEVELOPMENT) ||
		(Environment.current == Environment.TEST)) {

			Cliente c0 = new Cliente(ordenDeVisita: 1, nombre: 'Cliente 0',direccion: 'Dirección cliente 0',contacto: 'Contacto cliente 0',telefono: '15-6987-4500', mail:'cliente0@mail.com').save()
			Cliente c1 = new Cliente(ordenDeVisita: 2, nombre: 'Cliente 1',direccion: 'Dirección cliente 1',contacto: 'Contacto cliente 1',telefono: '15-6987-4501', mail:'cliente1@mail.com').save()
			Cliente c2 = new Cliente(ordenDeVisita: 3, nombre: 'Cliente 2',direccion: 'Dirección cliente 2',contacto: 'Contacto cliente 2',telefono: '15-6987-4502', mail:'cliente2@mail.com').save()

			Cliente c3 = new Cliente(ordenDeVisita: 1, nombre: 'Cliente 3',direccion: 'Dirección cliente 3',contacto: 'Contacto cliente 3',telefono: '15-6987-4503', mail:'cliente3@mail.com').save()
			Cliente c4 = new Cliente(ordenDeVisita: 2, nombre: 'Cliente 4',direccion: 'Dirección cliente 4',contacto: 'Contacto cliente 4').save()
			Cliente c5 = new Cliente(ordenDeVisita: 3, nombre: 'Cliente 5',direccion: 'Dirección cliente 5',contacto: 'Contacto cliente 5').save()

			Cliente c6 = new Cliente(ordenDeVisita: 1, nombre: 'Cliente 6',direccion: 'Dirección cliente 6',contacto: 'Contacto cliente 6',telefono: '15-6987-4506', mail:'cliente6@mail.com').save()
			Cliente c7 = new Cliente(ordenDeVisita: 2, nombre: 'Cliente 7',direccion: 'Dirección cliente 7',contacto: 'Contacto cliente 7').save()
			Cliente c8 = new Cliente(ordenDeVisita: 3, nombre: 'Cliente 8',direccion: 'Dirección cliente 8',contacto: 'Contacto cliente 8',telefono: '15-6987-4508', mail:'cliente8@mail.com').save()
			Cliente c9 = new Cliente(ordenDeVisita: 4, nombre: 'Cliente 9',direccion: 'Dirección cliente 9',contacto: 'Contacto cliente 9').save()

			Cliente c10 = new Cliente(ordenDeVisita: 1, nombre: 'Cliente 10',direccion: 'Dirección cliente 10',contacto: 'Contacto cliente 10',telefono: '15-6987-4510', mail:'cliente10@mail.com').save()
			Cliente c11 = new Cliente(ordenDeVisita: 2, nombre: 'Cliente 11',direccion: 'Dirección cliente 11',contacto: 'Contacto cliente 11').save()

			def proveRimasa = new Proveedor(nombre: 'Rimasa', direccion: 'Dirección Rimasa', contacto: 'Contacto Rimasa', email: 'rimasa@mail.com').save()
			def proveBeroch = new Proveedor(nombre: 'Beroch', direccion: 'Dirección Beroch', contacto: 'Contacto Beroch', email: 'beroch@mail.com').save()
			def proveOtros = new Proveedor(nombre: 'Otros', direccion: 'No corresponde', contacto: 'No corresponde', email: 'No corresponde').save()

			def cajBco1 = new Producto(nombre: 'CAJ BCO 1', descripcion: 'Cajón huevo blanco nro 1').save()
			def cajBco2 = new Producto(nombre: 'CAJ BCO 2', descripcion: 'Cajón huevo blanco nro 2').save()
			def cajSuper = new Producto(nombre: 'CAJ SUPER', descripcion: 'Cajón huevo súper').save()
			def cajColor = new Producto(nombre: 'CAJ COLOR', descripcion: 'Cajón huevo color').save()
			def maple = new Producto(nombre: 'MAPLE', descripcion: 'Maple').save()

			//Dias de visita y zonas
			String lunes = new LocalDate().withDayOfWeek(DateTimeConstants.MONDAY).dayOfWeek().getAsText()
			String martes = new LocalDate().withDayOfWeek(DateTimeConstants.TUESDAY).dayOfWeek().getAsText()
			String miercoles = new LocalDate().withDayOfWeek(DateTimeConstants.WEDNESDAY).dayOfWeek().getAsText()
			String jueves = new LocalDate().withDayOfWeek(DateTimeConstants.THURSDAY).dayOfWeek().getAsText()
			String viernes = new LocalDate().withDayOfWeek(DateTimeConstants.FRIDAY).dayOfWeek().getAsText()
			String sabado = new LocalDate().withDayOfWeek(DateTimeConstants.SATURDAY).dayOfWeek().getAsText()
			String domingo = new LocalDate().withDayOfWeek(DateTimeConstants.SUNDAY).dayOfWeek().getAsText()

			DiaVisitaCliente dLunes = new DiaVisitaCliente(dia: lunes).save()
			DiaVisitaCliente dMartes = new DiaVisitaCliente(dia: martes).save()
			DiaVisitaCliente dMiercoles = new DiaVisitaCliente(dia: miercoles).save()
			DiaVisitaCliente dJueves = new DiaVisitaCliente(dia: jueves).save()
			DiaVisitaCliente dViernes = new DiaVisitaCliente(dia: viernes).save()
			DiaVisitaCliente dSabado = new DiaVisitaCliente(dia: sabado).save()
			DiaVisitaCliente dDomingo = new DiaVisitaCliente(dia: domingo).save()

			new ZonaVenta(nombre: 'Lunes y Jueves',
			diasVisita: [dLunes, dJueves].asList(),
			clientes: [c0, c1, c2].asList(),
			vendedor: vendedor1).save();
			new ZonaVenta(nombre: 'Martes y Viernes',
			diasVisita: [dMartes, dViernes].asList(),
			clientes: [c3, c4, c5].asList(),
			vendedor: vendedor1).save();
			new ZonaVenta(nombre: 'Miércoles y Sábados',
			diasVisita: [dMiercoles, dSabado].asList(),
			clientes: [c6, c7, c8, c9].asList(),
			vendedor: vendedor2).save();
			new ZonaVenta(nombre: 'Domingos',
			diasVisita: [dDomingo].asList(),
			clientes: [c10, c11].asList(),
			vendedor: vendedor2).save();


			//Compra de productos
			def compraCajBco1 = new Compra(fechaDeCompra: new Date(),producto: cajBco1, proveedor:proveRimasa,precioUnitario: 340, cantidad: 50, total: 17000).save()
			def compraCajBco2= new Compra(fechaDeCompra: new Date(),producto: cajBco2, proveedor:proveBeroch,precioUnitario: 320, cantidad: 30, total: 9600).save()
			def compraCajSuper= new Compra(fechaDeCompra: new Date(),producto: cajSuper, proveedor:proveRimasa,precioUnitario: 400, cantidad: 15, total: 6000).save()
			def compraCajColor= new Compra(fechaDeCompra: new Date(),producto: cajColor, proveedor:proveBeroch,precioUnitario: 360, cantidad: 20, total: 7200).save()
			def compraMaple= new Compra(fechaDeCompra: new Date(),producto: maple, proveedor:proveBeroch,precioUnitario: 28, cantidad: 1, total: 28).save()

		}
	}
	def destroy = {
	}
}
