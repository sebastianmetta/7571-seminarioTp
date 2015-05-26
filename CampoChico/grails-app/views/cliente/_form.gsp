<%@ page import="ar.com.campochico.Cliente" %>



<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="cliente.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${clienteInstance?.nombre}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'direccion', 'error')} required">
	<label for="direccion">
		<g:message code="cliente.direccion.label" default="Direccion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="direccion" required="" value="${clienteInstance?.direccion}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'contacto', 'error')} ">
	<label for="contacto">
		<g:message code="cliente.contacto.label" default="Contacto" />
	</label>
	<g:textField name="contacto" value="${clienteInstance?.contacto}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'mail', 'error')} ">
	<label for="mail">
		<g:message code="cliente.mail.label" default="Mail" />
	</label>
	<g:textField name="mail" value="${clienteInstance?.mail}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: clienteInstance, field: 'telefono', 'error')} ">
	<label for="telefono">
		<g:message code="cliente.telefono.label" default="Telefono" />
	</label>
	<g:textField name="telefono" value="${clienteInstance?.telefono}"/>

</div>

