
<%@ page import="ar.com.campochico.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'cliente.label', default: 'Cliente')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
	<div class="nav" role="navigation">
		<ul>
			<li>
				<g:link class="create" action="create">
					<g:message message="Crear un nuevo cliente"/>
				</g:link>
			</li>
		</ul>
	</div>
	<div id="list-cliente" class="content scaffold-list" role="main">
		<h1>
			<g:message message="Lista de clientes"/>
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<table class="table table-striped table-hover ">
			<thead>
				<tr>
					<g:sortableColumn property="nombre"
						title="${message(code: 'cliente.nombre.label', default: 'Nombre')}" />
					<g:sortableColumn property="direccion"
						title="${message(code: 'cliente.direccion.label', default: 'Direccion')}" />
					<g:sortableColumn property="contacto"
						title="${message(code: 'cliente.contacto.label', default: 'Contacto')}" />
					<g:sortableColumn property="mail"
						title="${message(code: 'cliente.mail.label', default: 'Mail')}" />
					<g:sortableColumn property="telefono"
						title="${message(code: 'cliente.telefono.label', default: 'Telefono')}" />
				</tr>
			</thead>
			<tbody>
				<g:each in="${clienteInstanceList}" status="i" var="clienteInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${clienteInstance.id}">
								${fieldValue(bean: clienteInstance, field: "nombre")}
							</g:link></td>

						<td>
							${fieldValue(bean: clienteInstance, field: "direccion")}
						</td>

						<td>
							${fieldValue(bean: clienteInstance, field: "contacto")}
						</td>

						<td>
							${fieldValue(bean: clienteInstance, field: "mail")}
						</td>

						<td>
							${fieldValue(bean: clienteInstance, field: "telefono")}
						</td>

					</tr>
				</g:each>
			</tbody>
		</table>
		<div class="pagination">
			<g:paginate total="${clienteInstanceCount ?: 0}" />
		</div>

	</div>
</body>
</html>
