<%@ page import="ar.com.campochico.VisitaCliente"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<g:set var="entityName"
	value="${message(code: 'visitaCliente.label', default: 'VisitaCliente')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
	<div class="nav">
		<ul>
			<li>
				<span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label" /></a></span>
			</li> 
			<li>
				<span class="menuButton"><g:link class="list" action="list"> <g:message code="default.list.label" args="[entityName]" /></g:link></span>
			</li> 
			<li>
				<span class="menuButton"><g:link class="create" action="create"> <g:message code="default.new.label" args="[entityName]" /> </g:link></span>
			</li>
		</ul>
	</div>
	
	<div class="body">
		<h1>
			<g:message code="default.show.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message">
				${flash.message}
			</div>
		</g:if>
		<ol class="property-list visitaCliente">

			<g:if test="${visitaClienteInstance?.fecha}">
				<li class="fieldcontain"><span id="fecha-label"
					class="col-lg-2 control-label"><g:message
							code="visitaCliente.fecha.label" default="Fecha" /></span> <span
					class="property-value" aria-labelledby="fecha-label"><g:formatDate
							date="${visitaClienteInstance?.fecha}" /></span></li>
			</g:if>

			<g:if test="${visitaClienteInstance?.cliente}">
				<li class="fieldcontain"><span id="cliente-label"
					class="col-lg-2 control-label"><g:message
							code="visitaCliente.cliente.label" default="Cliente" /></span> <span
					class="col-lg-2 control-label" aria-labelledby="cliente-label"><g:link
							controller="cliente" action="show"
							id="${visitaClienteInstance?.cliente?.id}">
							${visitaClienteInstance?.cliente?.encodeAsHTML()}
						</g:link></span></li>
			</g:if>

			<g:if test="${visitaClienteInstance?.importeCobrado}">
				<li class="fieldcontain">
					<span id="importeCobrado-label" class="col-lg-2 control-label">
						<g:message code="visitaCliente.importeCobrado.label" default="Importe Cobrado" />
					</span> 
					<span class="property-value" aria-labelledby="importeCobrado-label">
						<g:formatNumber number="${visitaClienteInstance.importeCobrado}" type="number" maxFractionDigits="2" />
					</span>
				</li>
			</g:if>

			<g:if test="${visitaClienteInstance?.importeAdeudado}">
				<li class="fieldcontain">
					<span id="importeAdeudado-label" class="col-lg-2 control-label">
						<g:message code="visitaCliente.importeAdeudado.label" default="Importe Adeudado" />
					</span> 
					<span class="property-value" aria-labelledby="importeAdeudado-label">
						<g:formatNumber number="${visitaClienteInstance.importeAdeudado}" type="number" maxFractionDigits="2" />
					</span>
				</li>
			</g:if>
			
			<g:if test="${visitaClienteInstance?.observaciones}">
				<li class="fieldcontain"><span id="observaciones-label"
					class="col-lg-2 control-label"><g:message
							code="visitaCliente.observaciones.label" default="Observaciones" /></span>

					<span class="property-value" aria-labelledby="observaciones-label"><g:fieldValue
							bean="${visitaClienteInstance}" field="observaciones" /></span></li>
			</g:if>

			<g:if test="${visitaClienteInstance?.productosVendidos}">
				<li class="fieldcontain"><span id="productosVendidos-label"
					class="col-lg-2 control-label"><g:message
							code="visitaCliente.productosVendidos.label"
							default="Productos Vendidos" /></span> <g:each
						in="${visitaClienteInstance.productosVendidos}" var="p">
						<span class="col-lg-2 control-label"
							aria-labelledby="productosVendidos-label"><g:link
								controller="venta" action="show" id="${p.id}">
								${p?.encodeAsHTML()}
							</g:link></span>
					</g:each></li>
			</g:if>

		</ol>

		<g:form url="[resource:visitaClienteInstance, action:'delete']" method="DELETE">
			<fieldset class="buttons col-lg-2" >
				<div>
					<g:link class="btn btn-primary" action="edit" resource="${visitaClienteInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-default" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</div>
			</fieldset>
		</g:form>
		
	</div>
</body>
</html>
