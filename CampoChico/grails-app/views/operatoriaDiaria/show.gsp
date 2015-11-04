<%@ page import="ar.com.campochico.OperatoriaDiaria"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="layout" content="main" />
<g:set var="entityName"
	value="${message(code: 'operatoriaDiaria.label', default: 'OperatoriaDiaria')}" />
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
		<ol class="property-list operatoriaDiaria">

			<g:if test="${operatoriaDiariaInstance?.fecha}">
				<li class="fieldcontain"><span id="fecha-label"
					class="col-lg-2 control-label"><g:message
							code="operatoriaDiaria.fecha.label" default="Fecha" /></span> <span
					class="property-value" aria-labelledby="fecha-label"><g:formatDate
							date="${operatoriaDiariaInstance?.fecha}" /></span></li>
			</g:if>

			<g:if test="${operatoriaDiariaInstance?.vendedor}">
				<li class="fieldcontain"><span id="cliente-label"
					class="col-lg-2 control-label"><g:message
							code="operatoriaDiaria.vendedor.label" default="Vendedor" /></span> <span
					class="col-lg-2 control-label" aria-labelledby="vendedor-label"><g:link
							controller="vendedor" action="show"
							id="${operatoriaDiariaInstance?.vendedor?.id}">
							${operatoriaDiariaInstance?.vendedor?.encodeAsHTML()}
						</g:link></span></li>
			</g:if>

			<g:if test="${operatoriaDiariaInstance?.dineroOtorgado}">
				<li class="fieldcontain">
					<span id="operatoriaDiaria-label" class="col-lg-2 control-label">
						<g:message code="operatoriaDiaria.dineroOtorgado.label" default="Dinero Otorgado" />
					</span> 
					<span class="property-value" aria-labelledby="dineroOtorgado-label">
						<g:formatNumber number="${operatoriaDiariaInstance.dineroOtorgado}" type="number" maxFractionDigits="2" />
					</span>
				</li>
			</g:if>

			<g:if test="${operatoriaDiariaInstance?.observaciones}">
				<li class="fieldcontain"><span id="observaciones-label"
					class="col-lg-2 control-label"><g:message
							code="operatoriaDiaria.observaciones.label" default="Observaciones" /></span>

					<span class="property-value" aria-labelledby="observaciones-label"><g:fieldValue
							bean="${operatoriaDiariaInstance}" field="observaciones" /></span></li>
			</g:if>

			<g:if test="${operatoriaDiariaInstance?.productosOtorgados}">
				<li class="fieldcontain"><span id="productosOtorgados-label"
					class="col-lg-2 control-label"><g:message
							code="operatoriaDiaria.productosOtorgados.label"
							default="Productos Otorgados" /></span> <g:each
						in="${operatoriaDiariaInstance.productosOtorgados}" var="p">
						<span class="col-lg-2 control-label"
							aria-labelledby="productosOtorgados-label"><g:link
								controller="productoOtorgado" action="show" id="${p.id}">
								${p?.encodeAsHTML()}
							</g:link></span>
					</g:each></li>
			</g:if>

		</ol>

		<g:form url="[resource:operatoriaDiariaInstance, action:'delete']" method="DELETE">
			<fieldset class="buttons col-lg-2" >
				<div>
					<g:link class="btn btn-primary" action="edit" resource="${operatoriaDiariaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="btn btn-default" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: '¿Esta seguro?')}');" />
				</div>
			</fieldset>
		</g:form>
		
	</div>
</body>
</html>
