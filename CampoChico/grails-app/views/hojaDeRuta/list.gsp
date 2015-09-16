<%@ page import="ar.com.campochico.VisitaCliente"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Campo Chico - Hoja de ruta</title>
</head>
<body>
	<div>
		<h1>Hoja de ruta zona: ${zoneName}</h1>
		<div style="display: inline-block; text-align: right; width: 100%">
			<div class="btn-group">
		      <a aria-expanded="false" href="#" class="btn btn-primary btn-sm dropdown-toggle" data-toggle="dropdown">
		        Exportar
		        <span class="caret"></span>
		      </a>
		      <ul class="dropdown-menu">
		      	<g:set var="paramsForExcel" value="[exportFormat: 'excel', exportExtension: 'xls']" />
		      	<g:set var="paramsForPDF" value="[exportFormat: 'pdf', exportExtension: 'pdf']" />
		        <li><a href="${createLink(controller:'HojaDeRuta', action:'list', params:paramsForExcel)}">Excel</a></li>
		        <li><a href="${createLink(controller:'HojaDeRuta', action:'list', params:paramsForPDF)}">PDF</a></li>
		       </ul>
	       </div>
	    </div>
	</div>
	<g:form action="list" method="get" >
		<g:datePicker name="fechaZona" value="${zoneDate}" precision="day"/>
		<g:actionSubmit name="listZone" class="btn btn-success btn-sm" action="list" value="${message(code: 'default.button.find.label', default: 'Buscar')}" />
	</g:form>
	<table class="table table-striped table-hover ">
		<thead>
			<tr>
				<g:sortableColumn property="nombre" 
					title="${message(code: 'cliente.nombre.label', default: 'Nombre')}" />
				<g:sortableColumn property="direccion" 
					title="${message(code: 'cliente.direccion.label', default: 'Dirección')}" />
				<g:sortableColumn property="telefono"
					title="${message(code: 'cliente.telefono.label', default: 'Teléfono')}" />
				<g:sortableColumn property="contacto"
					title="${message(code: 'cliente.contacto.label', default: 'Contacto')}" />
				<g:sortableColumn property="mail"
					title="${message(code: 'cliente.contacto.mail', default: 'Mail')}" />
				<g:sortableColumn property="visita" title="Visita" />
			</tr>
		</thead>
		<tbody>
			<g:each in="${clientsList}" var="clienteInstance">
				<tr>
					<td>${fieldValue(bean: clienteInstance, field: "nombre")}</td>
					<td>${fieldValue(bean: clienteInstance, fieldbar: "direccion")}</td>
					<td>${fieldValue(bean: clienteInstance, field: "telefono")}</td>
					<td>${fieldValue(bean: clienteInstance, field: "contacto")}</td>
					<td>${fieldValue(bean: clienteInstance, field: "mail")}</td>
					<td>
						<%
						def visitaCliente = null
						clientsVisitsList.each {
							VisitaCliente eachVisita = it  
    						if (eachVisita.cliente.id == clienteInstance.id) {
								visitaCliente = eachVisita
    						}
						}
						%>
						<g:if test="${visitaCliente!=null}">
     						<g:link controller="visitaCliente" action="show" id="${visitaCliente.id}">
     							Ver
							</g:link>
						</g:if>
						<g:else>
							<g:link controller="visitaCliente" action="create" params="[idCliente: "${clienteInstance.id}", fechaToShow:"${zoneDate.format('yyyy-MM-dd')}"]">
						    	Crear
							</g:link>
						</g:else>
					</td>
				</tr>
			</g:each>
		</tbody>
	</table>
</body>
</html>