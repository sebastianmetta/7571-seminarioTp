<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main" />
		<title>Campo Chico - Resumen de cuenta</title>
		<style>
			#fechaDesdeStyle {display:inline-block;margin-right:10px; width:200px; } 
			#fechaHastaStyle {display:inline-block; width:200px; }
			#clienteStyle {display:inline-block;  }
		</style>
	</head>
	<body>
	<calendar:resources lang="es" theme="tiger"/>
	<div>
		<h1>Resumen de cuenta</h1>
		<div style="display: inline-block; text-align: right; width: 100%">
			<div class="btn-group">
		      <a aria-expanded="false" href="#" class="btn btn-primary btn-sm dropdown-toggle" data-toggle="dropdown">
		        Exportar
		        <span class="caret"></span>
		      </a>
		      <ul class="dropdown-menu">
		      	<g:set var="paramsForExcel" value="[exportFormat: 'excel', exportExtension: 'xls']" />
		      	<g:set var="paramsForPDF" value="[exportFormat: 'pdf', exportExtension: 'pdf']" />
		        <li><a href="${createLink(controller:'ResumenCuentaCliente', action:'list', params:paramsForExcel)}">Excel</a></li>
		        <li><a href="${createLink(controller:'ResumenCuentaCliente', action:'list', params:paramsForPDF)}">PDF</a></li>
		       </ul>
	       </div>
	    </div>
	</div>
	<g:form action="list" method="get" >
		<div id="fechaDesdeStyle"> <p>Fecha desde</p> <calendar:datePicker name="fechaDesdeNew" dateFormat="%d/%m/%Y" value="${fechaDesdeLastValue }" defaultValue="${new Date()}"/> </div> 
		<div id="fechaHastaStyle"> <p>Fecha hasta</p> <calendar:datePicker name="fechaHastaNew" dateFormat="%d/%m/%Y" value="${fechaHastaLastValue }" defaultValue="${new Date() - 1}"/> </div> 
		<g:if test="${clienteIdLastValue!=null}">
			<div id="clienteStyle"> <p>Cliente</p> <g:select id="cliente" name="clienteId" from="${ar.com.campochico.Cliente.list()}" optionKey="id" required="" class="many-to-one" value="${clienteIdLastValue}"/> </div>
		</g:if>
		<g:else>
			<div id="clienteStyle"> <p>Cliente</p> <g:select id="cliente" name="clienteId" from="${ar.com.campochico.Cliente.list()}" optionKey="id" required="" class="many-to-one"/> </div>	
		</g:else>
		<g:actionSubmit name="submitQuery" class="btn btn-success btn-sm" action="list" value="${message(code: 'default.button.find.label', default: 'Buscar')}" />
	</g:form>
	<g:if test="${resumenList.isEmpty() && clienteIdLastValue!=null}">
		<div class="alert alert-dismissible alert-warning">
		  	<button type="button" class="close" data-dismiss="alert">×</button>
			No existen resultados en su consulta.		  
		</div>
	</g:if>
	<g:else>
		<table class="table table-striped table-hover ">
			<thead>
				<tr>
					<g:sortableColumn property="nombre" 
						title="${message(code: 'resumenCuenta.fecha.label', default: 'Fecha')}" />
					<g:sortableColumn property="direccion" 
						title="${message(code: 'resumenCuenta.descripcion.label', default: 'Descripción')}" />
					<g:sortableColumn property="telefono"
						title="${message(code: 'resumenCuenta.debe.label', default: 'Debe')}" />
					<g:sortableColumn property="contacto"
						title="${message(code: 'resumenCuenta.haber.label', default: 'Haber')}" />
					<g:sortableColumn property="mail"
						title="${message(code: 'resumenCuenta.saldo.label', default: 'Saldo')}" />
				</tr>
			</thead>
			<tbody>
				<g:each in="${resumenList}" var="resumenInstance">
					<tr>
						<td><g:formatDate format="dd-MM-yyyy" date="${resumenInstance.fecha}"/></td>
						<td>${fieldValue(bean: resumenInstance, field: "descripcion")}</td>
						<td>${fieldValue(bean: resumenInstance, field: "saldoDeudor")}</td>
						<td>${fieldValue(bean: resumenInstance, field: "saldoAcreedor")}</td>
						<td>${fieldValue(bean: resumenInstance, field: "saldo")}</td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</g:else>
	
</body>
</html>