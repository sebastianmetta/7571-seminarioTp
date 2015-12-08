<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Campo Chico - Aviso de no visita</title>
</head>
<body>
	<div class="col-lg-10">
		<h1>Enviar aviso de no visita.</h1>
		<g:if test="${ mensajeError!=null && !mensajeError.isEmpty() }">
			<div class="alert alert-dismissible alert-warning">
		  		<button type="button" class="close" data-dismiss="alert">×</button>
				No pudo enviarse el aviso: ${ mensajeError }		  
			</div>
		</g:if>
		<g:form action="sendNoVisitAdvice" method="get" >
			<div><b>Zona de venta: </b><g:select id="zonaVenta" name="zonaVentaId" from="${ar.com.campochico.ZonaVenta.list()}" optionKey="id" required="" class="many-to-one"/> </div>
			<br>
			<p><b>Contenido del mensaje </b></p>
			<g:textArea name="bodyUserInput" value="${defaultBody}" rows="5" cols="100" escapeHtml="true"/>
	    	<br>			
			<g:actionSubmit name="sendAdvice" class="btn btn-success btn-sm" action="sendNoVisitAdvice" value="Enviar" onclick="return confirm('¿Está seguro que desea enviar el aviso?')" />
		</g:form>  			
	</div>
</body>
</html>