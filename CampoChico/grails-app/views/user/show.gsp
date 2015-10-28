<!doctype html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="user" action="index"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>

			<table class="table table-bordered ">
				<thead>
					<tr>
						<th><g:message code="user.username.label" default="Nombre de usuario" /></th>
						<th><g:message code="user.roles.label" default="Roles" /></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${fieldValue(bean: userInstance, field: "username")}</td>
						<td valign="top" style="text-align: left;" class="value">
						    <g:each in="${userInstance.roles}" var="r">
						        ${r?.encodeAsHTML()}
						    </g:each>
						</td>
					</tr>
				</tbody>
			</table>
            
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${userInstance?.id}" />
                    <span class="button"><g:actionSubmit class="btn btn-default" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: '¿Estas seguro?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>