package ar.com.campochico

import groovy.transform.ToString;

import java.util.Date;

/**
 * Value Object: 
 * @author sebastian
 *
 */
@ToString
class ResumenCuentaCliente {

	Date fecha
	String descripcion
	BigDecimal saldoDeudor
	BigDecimal saldoAcreedor
	BigDecimal saldo
	
    static constraints = {
		
    }
	
	/**
	 * crea una instancia correspondiente a una visita al cliente
	 */
	static def crearParaSaldoAcreedor(VisitaCliente visitaCliente) {
		ResumenCuentaCliente resumenDeCuenta = new ResumenCuentaCliente();
		resumenDeCuenta.setFecha(visitaCliente.getFecha());
		resumenDeCuenta.setDescripcion("Importe cobrado")
		resumenDeCuenta.setSaldoDeudor(BigDecimal.ZERO)
		resumenDeCuenta.setSaldoAcreedor(new BigDecimal(visitaCliente.getImporteCobrado()))
		resumenDeCuenta
	}
	
	static def crearParaSaldoDeudor(VisitaCliente visitaCliente, Venta venta, BigDecimal saldoAnterior) {
		ResumenCuentaCliente resumenDeCuenta = new ResumenCuentaCliente();
		resumenDeCuenta.setFecha(visitaCliente.getFecha().clearTime());
		resumenDeCuenta.setDescripcion(
				venta.getProducto().getNombre() + " - " +
				NumberUtils.formatQuantity(venta.getCantidad()) + " x " +
				NumberUtils.formatCurrency(venta.getPrecioVentaUnitario())
				)
		resumenDeCuenta.setSaldoDeudor(new BigDecimal(venta.getCantidad() * venta.getPrecioVentaUnitario()))
		resumenDeCuenta.setSaldoAcreedor(BigDecimal.ZERO)
		BigDecimal nuevoSaldo = saldoAnterior.add(resumenDeCuenta.getSaldoAcreedor().subtract(resumenDeCuenta.getSaldoDeudor()))
		resumenDeCuenta.setSaldo(nuevoSaldo)
		resumenDeCuenta
	}
}
