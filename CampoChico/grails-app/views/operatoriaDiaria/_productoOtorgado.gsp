<asset:javascript src="jquery-1.11.3.js" />

<div id="productoOtorgado${i}" class="productoOtorgado-div col-lg-offset-1" <g:if test="${hidden}">style="display:none;"</g:if>>
    <g:hiddenField name='productoOtorgadosList[${i}].id' value='${productoOtorgado?.id}'/>
    <g:hiddenField name='productoOtorgadosList[${i}].deleted' value='false'/>
	<g:hiddenField name='productoOtorgadosList[${i}].new' value="${productoOtorgado?.id == null?'true':'false'}"/>
>
    <label>Producto: </label>
    <g:select name="productoOtorgadosList[${i}].producto" 
	    from="${ar.com.campochico.Producto.list()}"
    	value = "${productoOtorgado?.producto?.id}"
		optionKey="id" 
		optionValue="nombre" />
	
    <label>Cantidad: </label>
    <g:textField name='productoOtorgadosList[${i}].cantidad' 
    			value="${formatNumber(number:productoOtorgado?.cantidad, type: 'number', maxFractionDigits: 2)}" />
    
    <span id="delete-icon${UUID.randomUUID()}" class="del-productoOtorgado" >
        <label class="glyphicon glyphicon-remove"></label>
    </span>
        
</div>
