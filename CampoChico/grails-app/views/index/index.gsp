<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Campo Chico - Inicio</title>
	</head>
	<body>
		<div align=center>
			
			<shiro:user>
				<g:if test="${pendingLoadVendedores!= null && !pendingLoadVendedores.isEmpty()}">
					<div class="alert alert-dismissible alert-warning">
						<button type="button" class="close" data-dismiss="alert">x</button>
						<h2>¡Hola <shiro:principal/>! Por favor, revisa estos mensajes: </h2>
						<g:each in="${pendingLoadVendedores}" var="pendingLoadVendedoresItem">
							<p>El vendedor ${pendingLoadVendedoresItem} no tiene cargada su operatoria diaria. <a href="#" class="alert-link">[TODO:link a operatoria diaria con el vendedor seleccionado]</a>.</p>
						</g:each>
					</div>
				</g:if>
				<g:else>
					<h2>¡Hola <shiro:principal/>!</h2>
				</g:else>
				<asset:image src="Logo-Campo-Chico.jpg" />
			</shiro:user>
			<shiro:notUser>
				<h2>Bienvenido al sistema de administración de CAMPO CHICO.</h2>
				<p>Para comenzar, por favor <a href="auth/login">iniciá sesión</a>.</p>
			</shiro:notUser>
			
		</div>
	</body>
</html>