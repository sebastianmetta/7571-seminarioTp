<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta name="layout" content="main" />
  <title>Login</title>
</head>
<body>
	<div class="container">
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
			<g:if test="${flash.message}">
				<div class="alert alert-dismissible alert-danger">
  				  <button type="button" class="close" data-dismiss="alert">×</button>
				  ${flash.message}
				</div>
			</g:if>
            <div class="panel panel-primary" >
				<div class="panel-heading">
				    <div class="panel-title">Iniciar Sesión</div>
				    <!--<div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>-->
				</div>
				<div style="padding-top:30px" class="panel-body" >
				    <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
				
				    <form id="loginform" class="form-horizontal" role="form" action="signIn">
				        <div style="margin-bottom: 25px" class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
						    <input id="username" type="text" class="form-control" name="username" value="" placeholder="Nombre de usuario">                                        
						</div>
						                         
						<div style="margin-bottom: 25px" class="input-group">
						    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
						    <input id="password" type="password" class="form-control" name="password" placeholder="Contraseña">
						</div>
						
						<div class="input-group">
							<div class="checkbox">
								<label>
									<input id="rememberMe" type="checkbox" name="remember" value="1"> Recordarme
								</label>
							</div>
						</div>
						<div class="form-group ">
							<div class="modal-footer">
								<button type="submit" class="btn btn-primary">Iniciar sesión</button>
							</div>
						</div>
					</form>     
				</div>                     
			</div>
		</div>  
	</div>
</body>
</html>
