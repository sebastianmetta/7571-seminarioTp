package ar.com.campochico

import grails.transaction.Transactional


@Transactional
class TotalesDiariosService {

	def visitaClienteService

	/**
	 * Devuelve un mapa con el siguiente formato:</br>
	 * <b>Clave:</b> Proveedor </br>
	 * <b>Valor:</b> Mapa que contiene como clave <b>Producto<b> 
	 * y como valor una listade TotalDiarioProducto. </br>  
	 * <u>Por ejemplo:</u>
	 * 
	 * <li>Beroch, [(Huevo Super, 54, 19500, 1250),(Huevo 1, 42, 13500, 720)]</li>
	 * <li>Rimasa, [(Huevo Super, 48, 17040, 1140),(Huevo 1, 34, 11540, 585)]</li>
	 * </br>
	 * 
	 * @param fecha
	 * @return
	 */
	def obtenerTotalesVentas(Date fecha) {
		Map<Proveedor, List<TotalDiarioProducto>> totalesVentas = new HashMap<Proveedor, List<TotalDiarioProducto>>()

		for (Proveedor eachProveedor : Proveedor.list()) {
			List<TotalDiarioProducto> totalesDiariosProductos = new ArrayList<TotalDiarioProducto>()

			List<VisitaCliente> visitasClientes = visitaClienteService.getClientVisitsByDate(fecha)

			for (VisitaCliente eachVisita : visitasClientes){
				List productosVendidos = eachVisita.getProductosVendidosByProveedor(eachProveedor)

				for(VentaProducto eachVenta : productosVendidos) {
					TotalDiarioProducto totalDiarioProducto = getOrAddProducto(eachVenta.getProducto(),totalesDiariosProductos)
					totalDiarioProducto.acumularVenta(eachVenta)
				}
				
			}

			if (totalesDiariosProductos.size()>0) {
				totalesVentas.put(eachProveedor, totalesDiariosProductos)
			}
		}
		return totalesVentas
	}
	
	/**
	 * Si el producto esta en la lista, devuelve la instancia de TotalDiarioProducto sino crea la misma, la agrega a la lista y la devuelve
	 * @param producto Producto a buscar
	 * @param totalesDiariosProductos Lista en donde buscar
	 * @return una instancia de TotalDiarioProducto correspondiente al producto
	 */
	private TotalDiarioProducto getOrAddProducto(Producto producto, List<TotalDiarioProducto> totalesDiariosProductos) {
		for (TotalDiarioProducto each : totalesDiariosProductos) {
			if (producto.equals(each.getProducto())) {
				return each
			}
		}
		TotalDiarioProducto toReturn = new TotalDiarioProducto();
		toReturn.reset()
		toReturn.setProducto(producto)
		totalesDiariosProductos.add(toReturn)
		return toReturn
	}
}

