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
				<shiro:user>
				<ul class="nav navbar-nav">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
							Acciones<span class="caret"></span>
						</a>
						<ul class="dropdown-menu" role="menu">
							<!-- <li><a href="${createLink(uri: '/VisitaCliente')}">Visitas a clientes</a></li>-->
							<li><a href="${createLink(uri: '/OperatoriaDiaria')}">Operatoria Diaria</a></li>
							<li class="divider"></li>
							<li><a href="${createLink(uri: '/HojaDeRuta')}">Hoja de ruta</a></li>
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
							<li><a href="${createLink(uri: '/Vendedor')}">Vendedores</a></li>
							<li><a href="${createLink(uri: '/Zona')}">Zonas</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
							Ventas<span class="caret"></span>
						</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="${createLink(uri: '/VentaProducto')}">Venta productos</a></li>
							<li><a href="${createLink(uri: '/VisitaCliente')}">Visita cliente</a></li>
						</ul>
					</li>
					<shiro:hasPermission permission="ResumenCuentaCliente:*">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
								Reportes<span class="caret"></span>
							</a>
								<ul class="dropdown-menu" role="menu">
										<li><a href="${createLink(uri: '/ResumenCuentaCliente')}">Resumenes de cuentas</a></li>
								</ul>
						</li>
					</shiro:hasPermission>
					<shiro:hasPermission permission="User:*">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
								Usuarios<span class="caret"></span>
							</a>
								<ul class="dropdown-menu" role="menu">
										<li><a href="${createLink(uri: '/User')}">Crear usuario</a></li>
										<li><a href="${createLink(uri: '/User/list')}">Listar usuarios</a></li>
								</ul>
						</li>
					</shiro:hasPermission>
				</ul>
				</shiro:user>
				<ul class="nav navbar-nav navbar-right">
					<shiro:user>
						<li><g:link controller="auth" action="signOut">Cerrar sesion de <shiro:principal/> </g:link></li>
					</shiro:user>
					<shiro:notUser>
						<li><g:link controller="auth" action="login">Iniciar sesion</g:link></li>
					</shiro:notUser> 
				</ul>
			</div>
		</div>
	</nav>
	<%-- top menu end--%>
	<g:layoutBody />
</body>
</html>