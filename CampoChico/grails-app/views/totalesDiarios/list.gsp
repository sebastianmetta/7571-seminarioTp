<%@ page import="ar.com.campochico.VisitaCliente"%>
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Campo Chico - Totales diarios</title>
<style>
	#fechaStyle {display:inline-block;margin-right:10px; width:200px; } 
</style>
</head>
<body>
	<calendar:resources lang="es" theme="tiger"/>
	<h1>Totales diarios</h1>
	<div class="span4">
		<g:form action="list" method="get" >
			<div id="fechaStyle">
				<p>Fecha</p>
				<calendar:datePicker name="fechaConsulta" dateFormat="%d/%m/%Y" value="${fechaLastValue }" defaultValue="${new Date()}"/> 
			</div>
			<g:actionSubmit name="listTotals" class="btn btn-success btn-sm" action="list" value="${message(code: 'default.button.find.label', default: 'Buscar')}" />
		</g:form>
	</div>
	<!-- En groovy si la coleccion es vacía devuelva false -->
	<g:if test="${totalesDiarios==null || totalesDiarios.isEmpty()}">
		<div class="alert alert-dismissible alert-warning">
		  	<button type="button" class="close" data-dismiss="alert">×</button>
			No existen resultados en su consulta.		  
		</div>
	</g:if>
	
	<g:if test="${totalesDiarios!=null && !totalesDiarios.isEmpty()}">
	<div class="container">
		<div id="divOperatoriaDiaria" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<p class="text-center text-primary">Datos operatoria diaria</p>
		    <table class="table table-striped table-hover ">
				<thead>
					<tr>
						<th>Fecha</th>
						<th>Vendedor</th>
						<th>Dinero Otorgado</th>
						<th>Maples Pérdida</th>
						<th>Observaciones</th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${operatoriaDiariaList}" var="operatoriaDiariaItem">
						<tr>
							<td><g:formatDate format="dd-MM-yyyy" date="${operatoriaDiariaItem.fecha}"/></td>
							<td>${fieldValue(bean: operatoriaDiariaItem, field: "vendedor")}</td>
							<td>${fieldValue(bean: operatoriaDiariaItem, field: "dineroOtorgado")}</td>
							<td>${fieldValue(bean: operatoriaDiariaItem, field: "maplesPerdida")}</td>
							<td>${fieldValue(bean: operatoriaDiariaItem, field: "observaciones")}</td>
						</tr>
					</g:each>
				</tbody>
			</table>
		    
		</div>
        <div id="divProductos" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<ul>
			<g:each var="totalesProveedor" in="${totalesDiarios}">
	    		<p class="text-center text-primary">Totales diarios para el proveedor <b>${totalesProveedor.key}</b></p>
			    <table class="table table-striped table-hover ">
					<thead>
						<tr>
							<th>Producto</th>
							<th>Cantidad</th>
							<th>Total Venta</th>
							<th>Costo Unitario</th>
							<th>Ganancia</th>
						</tr>
					</thead>
					<tbody>
						<g:each in="${totalesProveedor.value}" var="totalesPorProducto">
							<tr>
								<td>${fieldValue(bean: totalesPorProducto, field: "producto")}</td>
								<td>${fieldValue(bean: totalesPorProducto, field: "cantidadTotal")}</td>
								<td>${fieldValue(bean: totalesPorProducto, field: "totalVenta")}</td>
								<td>${fieldValue(bean: totalesPorProducto, field: "costoUnitario")}</td>
								<td>${fieldValue(bean: totalesPorProducto, field: "ganancia")}</td>
							</tr>
						</g:each>
						<!-- TOTALES -->
						<tr>
							<td><b>TOTAL</b></td>
							<td><b>${totalesProveedor.value.sum { it.cantidadTotal } }</b></td>
							<td><b>${totalesProveedor.value.sum { it.totalVenta } }</b></td>
							<td><b>-</b></td>
							<td><b>${totalesProveedor.value.sum { it.ganancia } }</b></td>
						</tr>
					</tbody>
				</table>
		    </g:each>
		</ul>
	</div>
	</div>
	</g:if>
</body>
</html>