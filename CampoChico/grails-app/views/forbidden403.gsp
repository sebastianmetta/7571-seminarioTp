<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Campo Chico">

<title>Campo Chico</title>

<asset:stylesheet src="bootstrap.css" />

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
		</div>
	</nav>
	<%-- top menu end--%>
	
	<div align=center>
		<shiro:user>
			<h2>Estimado <shiro:principal/>:</h2>
		</shiro:user>
		<shiro:notUser>
			<h2>Estimado invitado:</h2>
		</shiro:notUser>
		<p>Lo sentimos pero no tenes permiso para ver esta página.</p>
		<asset:image src="forbidden.jpg" />
	</div>
</body>
</html>