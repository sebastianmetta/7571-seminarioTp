<%@ page import="ar.com.campochico.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'cliente.label', default: 'Cliente')}" />
<title><g:message code="default.edit.label" args="[entityName]" /></title>
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
	<div id="edit-cliente" class="content scaffold-edit" role="main">
		<h1>
			<g:message message="Editar cliente"/>
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<g:hasErrors bean="${clienteInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${clienteInstance}" var="error">
					<li
						<g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
							error="${error}" /></li>
				</g:eachError>
			</ul>
		</g:hasErrors>
		<g:form url="[resource:clienteInstance, action:'update']" method="PUT">
			<g:hiddenField name="version" value="${clienteInstance?.version}" />
			<fieldset class="form">
				<g:render template="form" />
			</fieldset>
			<fieldset class="buttons">
				<div class="col-lg-10 col-lg-offset-2">
					<g:actionSubmit class="save" class="btn btn-primary" action="update"
						value="${message(code: 'default.button.update.label', default: 'Update')}" />
				</div>
			</fieldset>
		</g:form>
	</div>
</body>
</html>
