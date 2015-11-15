<%@ page import="ar.com.campochico.VisitaCliente"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Campo Chico - Totales diarios</title>
</head>
<body>
	<div>
		<div style="display: inline-block; text-align: right; width: 100%">
			<div class="btn-group">
		      <a aria-expanded="false" href="#" class="btn btn-primary btn-sm dropdown-toggle" data-toggle="dropdown">
		        Exportar
		        <span class="caret"></span>
		      </a>
		      <ul class="dropdown-menu">
		      	<g:set var="paramsForExcel" value="[exportFormat: 'excel', exportExtension: 'xls']" />
		      	<g:set var="paramsForPDF" value="[exportFormat: 'pdf', exportExtension: 'pdf']" />
		        <li><a href="${createLink(controller:'TotalesDiarios', action:'list', params:paramsForExcel)}">Excel</a></li>
		        <li><a href="${createLink(controller:'TotalesDiarios', action:'list', params:paramsForPDF)}">PDF</a></li>
		       </ul>
	       </div>
	    </div>
	</div>
	<g:form action="list" method="get" >
		<g:datePicker name="fechaConsulta" value="${zoneDate}" precision="day"/>
		<g:actionSubmit name="listTotals" class="btn btn-success btn-sm" action="list" value="${message(code: 'default.button.find.label', default: 'Buscar')}" />
	</g:form>
	<!-- TODO: Iterar mapa y mpostrar datos. -->
</body>
</html>