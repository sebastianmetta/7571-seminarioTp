
<%@ page import="ar.com.campochico.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'cliente.label', default: 'Cliente')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
	<div class="nav" role="navigation">
		<ul>
			<li><g:link class="list" action="index">
					<g:message message="Listar clientes"/>
				</g:link></li>
			<li><g:link class="create" action="create">
					<g:message message="Crear un nuevo cliente"/>
				</g:link></li>
		</ul>
	</div>
	<div id="show-cliente" class="content scaffold-show" role="main">
		<h1>
			<g:message message="Mostrar cliente"/>
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<ol class="property-list cliente">

			<g:if test="${clienteInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label" >
						<div class="col-lg-2 control-label" >
							<g:message code="cliente.nombre.label" default="Nombre" />
						</div>
					</span> 
					<span class="property-value" aria-labelledby="nombre-label">
						<div class="col-lg-10">
							<g:fieldValue bean="${clienteInstance}" field="nombre" />
						</div>
					</span>
				</li>
			</g:if>

			<g:if test="${clienteInstance?.direccion}">
				<li class="fieldcontain">
					<span id="direccion-label" class="property-label">
						<div class="col-lg-2 control-label" >
							<g:message code="cliente.direccion.label" default="Direccion" />
						</div>
					</span> 
					<span class="property-value" aria-labelledby="direccion-label">
						<div class="col-lg-10">
							<g:fieldValue bean="${clienteInstance}" field="direccion" />
						</div>
					</span>
				</li>
			</g:if>

			<g:if test="${clienteInstance?.contacto}">
				<li class="fieldcontain">
					<span id="contacto-label" class="property-label">
						<div class="col-lg-2 control-label" >
							<g:message code="cliente.contacto.label" default="Contacto" />
						</div>
					</span>
					<span class="property-value" aria-labelledby="contacto-label">
						<div class="col-lg-10">
							<g:fieldValue bean="${clienteInstance}" field="contacto" />
						</div>
					</span>
				</li>
			</g:if>

			<g:if test="${clienteInstance?.mail}">
				<li class="fieldcontain">
					<span id="mail-label" class="property-label">
						<div class="col-lg-2 control-label" >
							<g:message code="cliente.mail.label" default="Mail" />
						</div>
					</span> 
					<span class="property-value" aria-labelledby="mail-label">
						<div class="col-lg-10">
							<g:fieldValue bean="${clienteInstance}" field="mail" />
						</div>
					</span>
				</li>
			</g:if>

			<g:if test="${clienteInstance?.telefono}">
				<li class="fieldcontain">
					<span id="telefono-label" class="property-label">
						<div class="col-lg-2 control-label" >
							<g:message code="cliente.telefono.label" default="Telefono" />
						</div>
					</span> 
					<span class="property-value" aria-labelledby="telefono-label">
						<div class="col-lg-10">
							<g:fieldValue bean="${clienteInstance}" field="telefono" />
						</div>
					</span>
				</li>
			</g:if>

		</ol>
		
		<g:form url="[resource:clienteInstance, action:'delete']"
			method="DELETE">
			<fieldset class="buttons">
				<div class="col-lg-2">
					<g:link class="btn btn-primary" action="edit" resource="${clienteInstance}">
						<g:message code="default.button.edit.label" default="Edit" />
					</g:link>
					<g:actionSubmit class="btn btn-default" action="delete"
						value="${message(code: 'default.button.delete.label', default: 'Delete')}"
						onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
					</div>
			</fieldset>
		</g:form>
	</div>
</body>
</html>
