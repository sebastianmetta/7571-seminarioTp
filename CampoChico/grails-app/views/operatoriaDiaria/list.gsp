
<%@ page import="ar.com.campochico.OperatoriaDiaria"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'operatoriaDiaria.label', default: 'operatoriaDiaria')}" />
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
	<div id="list-operatoriaDiaria" class="content scaffold-list" role="main">
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
						title="${message(code: 'operatoriaDiaria.fecha.label', default: 'Fecha')}" />

					<th><g:message code="operatoriaDiaria.vendedor.label"
							default="Vendedor" /></th>
							
					<g:sortableColumn property="dineroOtorgado"
						title="${message(code: 'operatoriaDiaria.dineroOtorgado.label', default: 'Dinero Otorgado')}" />

					<g:sortableColumn property="observaciones"
						title="${message(code: 'operatoriaDiaria.observaciones.label', default: 'Observaciones')}" />


				</tr>
			</thead>
			<tbody>
				<g:each in="${operatoriaDiariaInstanceList}" status="i"
					var="operatoriaDiariaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td>
							<g:link action="show" id="${operatoriaDiariaInstance.id}">
								<g:formatDate format="yyyy-MM-dd" date="${operatoriaDiariaInstance.fecha}"/>
							</g:link></td>
						<td>
							${fieldValue(bean: operatoriaDiariaInstance, field: "vendedor")}
						</td>

						<td>
							${fieldValue(bean: operatoriaDiariaInstance, field: "dineroOtorgado")}
						</td>
						
						<td>
							${fieldValue(bean: visitaClienteInstance, field: "observaciones")}
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${operatoriaDiariaInstanceCount ?: 0}" />
		</div>
	</div>
</body>
</html>
