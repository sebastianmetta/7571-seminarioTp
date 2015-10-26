<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Campo Chico - Inicio</title>
	</head>
	<body>
		<div align=center>
			
			<shiro:user>
				<h2>¡Hola <shiro:principal/>!</h2>
				<asset:image src="Logo-Campo-Chico.jpg" />				
			</shiro:user>
			<shiro:notUser>
				<h2>Bienvenido al sistema de administración de CAMPO CHICO.</h2>
				<p>Para comenzar, por favor <a href="auth/login">iniciá sesión</a>.</p>
			</shiro:notUser>
			
		</div>
	</body>
</html>