<%@ page import="ar.com.campochico.OperatoriaDiaria" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
  <g:set var="entityName" value="${message(code: 'contact.label', default: 'OperatoriaDiaria')}" />
  <title><g:message code="default.create.label" args="[entityName]" /></title>
  </head>
  <body>
    <div class="nav">
      <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
      <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
    </div>
    <div class="body">
      <h1><g:message code="default.create.label" args="[entityName]" /></h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <g:hasErrors bean="${operatoriaDiariaInstance}">
        <div class="errors">
          <g:renderErrors bean="${operatoriaDiariaInstance}" as="list" />
        </div>
      </g:hasErrors>

        <g:form action="save" method="post" >
	        <!-- Render the operatoriaDiariaInstance template (_operatoriaDiariaInstance.gsp) here -->
	        <g:render template="operatoriaDiaria" model="['operatoriaDiariaInstance':operatoriaDiariaInstance]"/>
	        
			<fieldset class="buttons">
				<div class="col-lg-10">
					<g:actionSubmit name="create" class="btn btn-primary" action="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</div>
			</fieldset>
      	</g:form>
    </div>
    
    <!-- Render the productoOtorgado template (_productoOtorgado.gsp) hidden so we can clone it -->
    <g:render template='productoOtorgado' model="['productoOtorgado':null,'i':'_clone','hidden':true]"/>
    
  </body>
</html>

