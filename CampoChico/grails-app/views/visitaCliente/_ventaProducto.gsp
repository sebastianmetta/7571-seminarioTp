<asset:javascript src="jquery-1.11.3.js" />

<div id="ventaProducto${i}" class="ventaProducto-div col-lg-offset-1" <g:if test="${hidden}">style="display:none;"</g:if>>
    <g:hiddenField name='ventaProductosList[${i}].id' value='${ventaProducto?.id}'/>
    <g:hiddenField name='ventaProductosList[${i}].deleted' value='false'/>
	<g:hiddenField name='ventaProductosList[${i}].new' value="${ventaProducto?.id == null?'true':'false'}"/>
    
    <label>Producto: </label>
    <g:select name="ventaProductosList[${i}].producto"
        from="${ar.com.campochico.Producto.list()}"
        value = "${producto?.nombre}"
        optionKey="id" />
    
    <label>Cantidad: </label>
    <g:textField name='ventaProductosList[${i}].cantidad' value='${ventaProducto?.cantidad}' />
    
    <label>Precio unitario: </label>
    <g:textField name='ventaProductosList[${i}].precioVentaUnitario' value='${ventaProducto?.precioVentaUnitario}' />

    <span id="delete-icon${UUID.randomUUID()}" class="del-ventaProducto" >
        <img src="${resource(dir:'images', file:'icon_delete.png')}" style="vertical-align:middle;"/>
    </span>
        
</div>
