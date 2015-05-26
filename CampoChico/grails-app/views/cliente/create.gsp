<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'cliente.label', default: 'Cliente')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>
</head>
<body>
	<div class="nav" role="navigation">
		<ul>
			<li><g:link class="list" action="index">
					<g:message message="Listar clientes"/>
				</g:link></li>
		</ul>
	</div>
	<div id="create-cliente" class="content scaffold-create" role="main">
		<h1>
			<g:message message="Crear un nuevo cliente"/>
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
		<g:form url="[resource:clienteInstance, action:'save']">
			<fieldset class="form">
				<g:render template="form" />
			</fieldset>
			<fieldset class="buttons">
				<div class="col-lg-10 col-lg-offset-2">
					<button type="reset" class="btn btn-default">Cancelar</button>
					<g:submitButton name="create" class="btn btn-primary"
						value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</div>
			</fieldset>
		</g:form>
	</div>
</body>
</html>
