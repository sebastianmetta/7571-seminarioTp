<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Campo Chico">

<title><g:layoutTitle default="Grails" /></title>

<asset:stylesheet src="bootstrap.css" />

<g:layoutHead />

</head>

<body>
	<asset:javascript src="jquery-1.11.3.js" />
	<asset:javascript src="bootstrap.js" />
	
	<%-- top Menu start --%>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="${createLink(uri: '/')}">CAMPO CHICO</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
				<ul class="nav navbar-nav">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
							Acciones<span class="caret"></span>
						</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="${createLink(uri: '/VisitaCliente')}">Visitas a clientes</a></li>
							<li><a href="${createLink(uri: '/HojaRuta')}">Hoja de ruta</a></li>
							<li class="divider"></li>
							<li><a href="${createLink(uri: '/CompraProducto')}">Compra de productos</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
							Edicion<span class="caret"></span>
						</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="${createLink(uri: '/Producto')}">Productos</a></li>
							<li class="divider"></li>
							<li><a href="${createLink(uri: '/Cliente')}">Clientes</a></li>
							<li><a href="${createLink(uri: '/Proveedor')}">Proveedores</a></li>
							<li class="divider"></li>
							<li><a href="${createLink(uri: '/Zona')}">Zonas</a></li>
						</ul>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Cerrar sesión</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<%-- top menu end--%>
	<g:layoutBody />
</body>
</html>