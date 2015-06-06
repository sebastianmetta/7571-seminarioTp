<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Campo Chico - Hoja de ruta</title>
	</head>
	<body>
		<div>Esta es la hoja de ruta.</div>

	<g:each in="${zona}" var="p">
		<li>
			${p}
		</li>
	</g:each>

</body>
</html>