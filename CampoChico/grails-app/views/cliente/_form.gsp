<%@ page import="ar.com.campochico.Cliente" %>



<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'nombre', 'error')} required">
	<label for="nombre" class="col-lg-2 control-label">
		<g:message code="cliente.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-lg-10">
		<g:textField name="nombre" required="" value="${clienteInstance?.nombre}"/>
	</div>

</div>

<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'direccion', 'error')} required">
	<label for="direccion" class="col-lg-2 control-label">
		<g:message code="cliente.direccion.label" default="Direccion" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-lg-10">
		<g:textField name="direccion" required="" value="${clienteInstance?.direccion}"/>
	</div>
</div>

<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'contacto', 'error')} ">
	<label for="contacto" class="col-lg-2 control-label">
		<g:message code="cliente.contacto.label" default="Contacto" />
	</label>
	<div class="col-lg-10">
		<g:textField name="contacto" value="${clienteInstance?.contacto}"/>
	</div>

</div>

<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'mail', 'error')} ">
	<label for="mail" class="col-lg-2 control-label">
		<g:message code="cliente.mail.label" default="Mail" />
	</label>
	<div class="col-lg-10">
		<g:textField name="mail" value="${clienteInstance?.mail}"/>
	</div>
</div>

<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'telefono', 'error')} ">
	<label for="telefono" class="col-lg-2 control-label">
		<g:message code="cliente.telefono.label" default="Telefono" />
	</label>
	<div class="col-lg-10">
		<g:textField name="telefono" value="${clienteInstance?.telefono}"/>
	</div>
</div>
