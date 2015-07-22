<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Campo Chico - Hoja de ruta</title>
</head>
<body>
	<h1>Los clientes de hoy son:</h1>
	<table class="table table-striped table-hover ">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Dirección</th>
				<th>Teléfono</th>
				<th>Contacto</th>
				<th>Mail</th>
			</tr>
		</thead>
		<tbody>
			<g:each in="${todayClientsList}" var="clienteInstance">
				<tr>
					<td>${fieldValue(bean: clienteInstance, field: "nombre")}</td>
					<td>${fieldValue(bean: clienteInstance, field: "direccion")}</td>
					<td>${fieldValue(bean: clienteInstance, field: "telefono")}</td>
					<td>${fieldValue(bean: clienteInstance, field: "contacto")}</td>
					<td>${fieldValue(bean: clienteInstance, field: "mail")}</td>
				</tr>
			</g:each>
		</tbody>
	</table>
</body>
</html>