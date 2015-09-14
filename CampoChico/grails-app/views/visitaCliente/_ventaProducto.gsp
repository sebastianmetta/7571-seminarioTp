<asset:javascript src="jquery-1.11.3.js" />

<div id="ventaProducto${i}" class="ventaProducto-div col-lg-offset-1" <g:if test="${hidden}">style="display:none;"</g:if>>
    <g:hiddenField name='ventaProductosList[${i}].id' value='${ventaProducto?.id}'/>
    <g:hiddenField name='ventaProductosList[${i}].deleted' value='false'/>
	<g:hiddenField name='ventaProductosList[${i}].new' value="${ventaProducto?.id == null?'true':'false'}"/>
    
    <%-- 
    <g:select name="ventaProductosList[${i}].producto"
        from="${ar.com.campochico.Producto.list()}"
        value = "${ventaProductoproducto?.nombre}"
        optionKey="id" />
    --%>
    <label>Producto: </label>
    <g:select name="ventaProductosList[${i}].producto" 
	    from="${ar.com.campochico.Producto.list()}"
    	value = "${ventaProducto?.producto?.id}"
		optionKey="id" 
		optionValue="nombre" />
	
	<label>Proveedor: </label>	
	<g:select name="ventaProductosList[${i}].proveedor" 
	    from="${ar.com.campochico.Proveedor.list()}"
    	value = "${ventaProducto?.proveedor?.id}"
		optionKey="id" 
		optionValue="nombre" />
	
    <label>Cantidad: </label>
    <g:textField name='ventaProductosList[${i}].cantidad' 
    			value="${formatNumber(number:ventaProducto?.cantidad, type: 'number', maxFractionDigits: 2)}" />
    
    <label>Precio unitario: </label>
    <g:textField name='ventaProductosList[${i}].precioVentaUnitario' 
    			value="${formatNumber(number:ventaProducto?.precioVentaUnitario, type: 'number', maxFractionDigits: 2)}" />

    <span id="delete-icon${UUID.randomUUID()}" class="del-ventaProducto" >
        <label class="glyphicon glyphicon-remove"></label>
    </span>
        
</div>
