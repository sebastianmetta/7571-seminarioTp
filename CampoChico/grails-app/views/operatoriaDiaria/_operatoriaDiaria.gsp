<%@ page import="ar.com.campochico.OperatoriaDiaria" %>

<div class="fieldcontain ${hasErrors(bean: operatoriaDiariaInstance, field: 'fecha', 'error')} required">
	<label for="fecha" class="col-lg-2 control-label">
		<g:message code="operatoriaDiaria.fecha.label" default="Fecha" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fecha" precision="day"  value="${operatoriaDiariaInstance?.fecha}"  />
</div>

<div id="vendedorContainer" class="fieldcontain ${hasErrors(bean: operatoriaDiariaInstance, field: 'vendedor', 'error')} required">
	<label for="vendedor" class="col-lg-2 control-label">
		<g:message code="operatoriaDiaria.vendedor.label" default="Vendedor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="vendedor" name="vendedor.id" from="${ar.com.campochico.Vendedor.list()}" optionKey="id" required="" value="${operatoriaDiariaInstance?.vendedor?.id}" class="many-to-one"/>
</div>

<div>
	<g:javascript >
	    var idVendedor = "${params.idVendedor}";
		if( idVendedor ){
			$( "div" ).find("select[id$='vendedor']").val(idVendedor);
		};
		
		var fechaAMostrar = "${params.fechaToShow}";
		if( fechaAMostrar ){
			var dateParts = fechaAMostrar.split('-');
			$( "div" ).find("select[id$='fecha_day']").val(parseInt(dateParts[2]));
			$( "div" ).find("select[id$='fecha_month']").val(parseInt(dateParts[1]));
			$( "div" ).find("select[id$='fecha_year']").val(parseInt(dateParts[0]));
		};
	</g:javascript>
</div>

<div class="fieldcontain ${hasErrors(bean: operatoriaDiariaInstance, field: 'dineroOtorgado', 'error')} required">
	<label for="dineroOtorgado" class="col-lg-2 control-label">
		<g:message code="operatoriaDiaria.dineroOtorgado.label" default="Dinero Otorgado" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="dineroOtorgado" value="${fieldValue(bean: operatoriaDiariaInstance, field: 'dineroOtorgado')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: operatoriaDiariaInstance, field: 'maplesPerdida', 'error')} required">
	<label for="maplesPerdida" class="col-lg-2 control-label">
		<g:message code="operatoriaDiaria.maplesPerdida.label" default="Maples Pérdida" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="maplesPerdida" value="${fieldValue(bean: operatoriaDiariaInstance, field: 'maplesPerdida')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: operatoriaDiariaInstance, field: 'observaciones', 'error')} ">
	<label for="observaciones" class="col-lg-2 control-label">
		<g:message code="visitaCliente.observaciones.label" default="Observaciones" />
	</label>
	<g:textField name="observaciones" value="${operatoriaDiariaInstance?.observaciones}"/>
</div>

<div class="nav" >
	<label for="productosOtorgados" class="col-lg-2 control-label">
		<g:message code="operatoriaDiaria.productosOtorgados.label" default="Productos Otorgados" />
	</label>
</div>

<div class="fieldcontain ${hasErrors(bean: operatoriaDiariaInstance, field: 'productosOtorgados', 'error')} ">
	<g:render template="productoOtorgados" model="['operatoriaDiariaInstance':operatoriaDiariaInstance]" />
</div>

