
<%@ page import="ar.com.campochico.VisitaCliente"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'visitaCliente.label', default: 'VisitaCliente')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<div class="nav" role="navigation">
		<ul>
			<li><g:link class="create" action="create">
					<g:message code="default.new.label" args="[entityName]" />
				</g:link></li>
		</ul>
	</div>
	<div id="list-visitaCliente" class="content scaffold-list" role="main">
		<h1>
			<g:message code="default.list.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<table class="table table-striped table-hover">
			<thead>
				<tr>

					<g:sortableColumn property="fecha"
						title="${message(code: 'visitaCliente.fecha.label', default: 'Fecha')}" />

					<th><g:message code="visitaCliente.cliente.label"
							default="Cliente" /></th>
							
					<g:sortableColumn property="importeCobrado"
						title="${message(code: 'visitaCliente.importeCobrado.label', default: 'Importe Cobrado')}" />

					<g:sortableColumn property="importeAdeudado"
						title="${message(code: 'visitaCliente.importeAdeudado.label', default: 'Importe Adeudado')}" />

					<g:sortableColumn property="observaciones"
						title="${message(code: 'visitaCliente.observaciones.label', default: 'Observaciones')}" />


				</tr>
			</thead>
			<tbody>
				<g:each in="${visitaClienteInstanceList}" status="i"
					var="visitaClienteInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td>
							<g:link action="show" id="${visitaClienteInstance.id}">
								<%-- ${fieldValue(bean: visitaClienteInstance, field: "fecha")} --%>
								<g:formatDate format="yyyy-MM-dd" date="${visitaClienteInstance.fecha}"/>
							</g:link></td>
						<td>
							${fieldValue(bean: visitaClienteInstance, field: "cliente")}
						</td>

						<td>
							${fieldValue(bean: visitaClienteInstance, field: "importeCobrado")}
						</td>
						
						<td>
							${fieldValue(bean: visitaClienteInstance, field: "importeAdeudado")}
						</td>

						<td>
							${fieldValue(bean: visitaClienteInstance, field: "observaciones")}
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${visitaClienteInstanceCount ?: 0}" />
		</div>
	</div>
</body>
</html>
