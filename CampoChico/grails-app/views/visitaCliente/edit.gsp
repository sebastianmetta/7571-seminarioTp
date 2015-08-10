<%@ page import="ar.com.campochico.VisitaCliente" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'visitaCliente.label', default: 'VisitaCliente')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="edit-visitaCliente" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${visitaClienteInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${visitaClienteInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:visitaClienteInstance, action:'update']" method="PUT" >
				<g:hiddenField name="version" value="${visitaClienteInstance?.version}" />
				<g:hiddenField name="id" value="${visitaClienteInstance?.id}" />
                
                <!-- Render the visitaCliente template (_visitaCliente.gsp) here -->
                <g:render template="visitaCliente" model="['visitaClienteInstance':visitaClienteInstance]"/>
                
				<fieldset class="buttons">
					<div class="col-lg-10">
						<g:actionSubmit class="btn btn-primary" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
					</div>
				</fieldset>
			</g:form>
		</div>
		<!-- Render the ventaProducto template (_ventaProducto.gsp) hidden so we can clone it -->
        <g:render template='ventaProducto' model="['ventaProducto':null,'i':'_clone','hidden':true]"/>
	</body>
</html>

