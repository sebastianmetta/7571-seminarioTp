<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Login</title>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="span12">
			<g:form class="form-horizontal" action="signIn">
			  <fieldset>
			    <legend>Por favor, completa los campos para iniciar sesion:</legend>
			    <g:if test="${flash.message}">
			    	<p class="text-danger">${flash.message}</p>
			  	</g:if>
			    <input type="hidden" name="targetUri" value="${targetUri}" />
			    <div class="form-group">
			      <label for="username" class="col-lg-2 control-label">Nombre de usuario</label>
			      <div class="col-lg-10">
			        <input class="form-control" name="username" placeholder="Nombre de usuario" type="text" value="${username}">
			      </div>
			    </div>
			    <div class="form-group">
			      <label for="inputPassword" class="col-lg-2 control-label">Contraseña</label>
			      <div class="col-lg-10">
			        <input class="form-control" id="password" name="password" placeholder="Contraseña" type="password" value="">
			        <g:checkBox name="rememberMe" value="${rememberMe}"/> Recordarme
			      </div>
			    </div>
			    <div class="form-group ">
			      <div class="col-lg-10 col-lg-offset-2">
			        <button type="submit" class="btn btn-primary">Iniciar sesion</button>
			      </div>
			    </div>
			  </fieldset>
			</g:form>
  		</div>
  	</div>
  </div>
</body>
</html>
