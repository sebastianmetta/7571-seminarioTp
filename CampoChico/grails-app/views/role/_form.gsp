<%@ page import="ar.com.campochico.Role" %>



<div class="fieldcontain ${hasErrors(bean: roleInstance, field: 'name', 'error')} required">
	<label for="name" class="col-lg-2 control-label">
		<g:message code="role.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${roleInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: roleInstance, field: 'permissions', 'error')} ">
	<label for="permissions" class="col-lg-2 control-label">
		<g:message code="role.permissions.label" default="Permissions" />
		
	</label>
	

</div>

<div class="fieldcontain ${hasErrors(bean: roleInstance, field: 'users', 'error')} ">
	<label for="users" class="col-lg-2 control-label">
		<g:message code="role.users.label" default="Users" />
		
	</label>
	

</div>

