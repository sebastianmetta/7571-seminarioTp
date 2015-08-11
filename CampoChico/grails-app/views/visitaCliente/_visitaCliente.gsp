<%@ page import="ar.com.campochico.VisitaCliente" %>

<div class="fieldcontain ${hasErrors(bean: visitaClienteInstance, field: 'fecha', 'error')} required">
	<label for="fecha" class="col-lg-2 control-label">
		<g:message code="visitaCliente.fecha.label" default="Fecha" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fecha" precision="day"  value="${visitaClienteInstance?.fecha}"  />

</div>

<div id="clienteContainer" class="fieldcontain ${hasErrors(bean: visitaClienteInstance, field: 'cliente', 'error')} required">
	<label for="cliente" class="col-lg-2 control-label">
		<g:message code="visitaCliente.cliente.label" default="Cliente" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="cliente" name="cliente.id" from="${ar.com.campochico.Cliente.list()}" optionKey="id" required="" value="${visitaClienteInstance?.cliente?.id}" class="many-to-one"/>
</div>

<div>
	<g:javascript >
	    var idCliente = "${params.idCliente}";
		if( idCliente ){
			$( "div" ).find("select[id$='cliente']").val(idCliente);
		};
	</g:javascript>
</div>

<div class="fieldcontain ${hasErrors(bean: visitaClienteInstance, field: 'importeCobrado', 'error')} required">
	<label for="importeCobrado" class="col-lg-2 control-label">
		<g:message code="visitaCliente.importeCobrado.label" default="Importe Cobrado" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="importeCobrado" value="${fieldValue(bean: visitaClienteInstance, field: 'importeCobrado')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: visitaClienteInstance, field: 'importeAdeudado', 'error')} required">
	<label for="importeAdeudado" class="col-lg-2 control-label">
		<g:message code="visitaCliente.importeAdeudado.label" default="Importe Adeudado" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="importeAdeudado" value="${fieldValue(bean: visitaClienteInstance, field: 'importeAdeudado')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: visitaClienteInstance, field: 'observaciones', 'error')} ">
	<label for="observaciones" class="col-lg-2 control-label">
		<g:message code="visitaCliente.observaciones.label" default="Observaciones" />
	</label>
	<g:textField name="observaciones" value="${visitaClienteInstance?.observaciones}"/>
</div>

<div class="nav" >
	<label for="productosVendidos" class="col-lg-2 control-label">
		<g:message code="visitaCliente.productosVendidos.label" default="Productos Vendidos" />
	</label>
</div>

<div class="fieldcontain ${hasErrors(bean: visitaClienteInstance, field: 'productosVendidos', 'error')} ">
	<!-- Render the ventaProductos template (_ventaProductos.gsp) here -->
	<g:render template="ventaProductos" model="['visitaClienteInstance':visitaClienteInstance]" />
    <!-- Render the phones template (_ventaProductos.gsp) here -->
</div>

