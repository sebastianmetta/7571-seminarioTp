<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Campo Chico - Hoja de ruta</title>
</head>
<body>
	<h1>Zona: ${todayZoneName}</h1>
	<h2>Los clientes de hoy son:</h2>
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
			<g:each in="${todayClientsList}" var="clienteInstance">
				<tr>
					<td>${fieldValue(bean: clienteInstance, field: "nombre")}</td>
					<td>${fieldValue(bean: clienteInstance, field: "direccion")}</td>
					<td>${fieldValue(bean: clienteInstance, field: "telefono")}</td>
					<td>${fieldValue(bean: clienteInstance, field: "contacto")}</td>
					<td>${fieldValue(bean: clienteInstance, field: "mail")}</td>
					<td>
						<g:set var="visitaCliente" value="${todayClientsVisitsList.findAll{ it.cliente?.id == clienteInstance.id }}"/>
						<g:if test="${!visitaCliente.isEmpty()}">
     						<g:link controller="visitaCliente" action="show" id="${visitaCliente.id}">
     							Ver
							</g:link>
						</g:if>
						<g:else>
						    <g:link controller="visitaCliente" action="create" params="[idCliente: "${clienteInstance.id}"]">
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