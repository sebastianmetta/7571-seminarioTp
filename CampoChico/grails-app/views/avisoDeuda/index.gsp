<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Campo Chico - Aviso de deuda</title>
</head>
<body>
	<div class="col-lg-10">
		<h1>Enviar aviso de deuda.</h1>
		<g:if test="${ mensajeError!=null && !mensajeError.isEmpty() }">
			<div class="alert alert-dismissible alert-warning">
		  		<button type="button" class="close" data-dismiss="alert">×</button>
				No pudo enviarse el aviso: ${ mensajeError }		  
			</div>
		</g:if>
		<g:form action="sendDebtAdvice" method="get" >
			<g:if test="${clienteIdToSelect!=null}">
				<div><b>Cliente: </b><g:select id="cliente" name="clienteId" from="${ar.com.campochico.Cliente.list()}" optionKey="id" required="" class="many-to-one" value="${clienteIdToSelect}"/> </div>
			</g:if>
			<g:else>
				<div><b>Cliente: </b><g:select id="cliente" name="clienteId" from="${ar.com.campochico.Cliente.list()}" optionKey="id" required="" class="many-to-one"/> </div>
			</g:else>
		
			<br>
			<p><b>Contenido del mensaje </b></p>
			<g:textArea name="bodyUserInput" value="${defaultBody}" rows="5" cols="100" escapeHtml="true"/>
	    	<br>			
			<g:actionSubmit name="sendAdvice" class="btn btn-success btn-sm" action="sendDebtAdvice" value="Enviar" onclick="return confirm('¿Está seguro que desea enviar el aviso?')" />
		</g:form>  			
	</div>
	
</body>
</html>