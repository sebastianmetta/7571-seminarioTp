<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Register</title>
    <meta name="layout" content="main"/>
</head>

<body>
  <%--
  <g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
  </g:if>

  <g:hasErrors bean="${user}">
    <div class="alert alert-error">
        <g:renderErrors bean="${user}" as="list"/>
    </div>
  </g:hasErrors>

  <g:form action="register">
    <table>
      <tbody>
        <tr>
          <td>Nombre de usuario:</td>
          <td><input type="text" name="username" value="${username}" /></td>
        </tr>
        <tr>
          <td>Contraseña:</td>
          <td><input type="password" name="password" value="" /></td>
        </tr>
        <tr>
          <td>Confirmar contraseña:</td>
          <td><input type="password" name="password2" value="" /></td>
        </tr>
        <tr>
        	<td>Rol</td>
        	<td><g:select id="rol" name="rol" from="${ar.com.campochico.Role.list()}" optionKey="id" required="" class="many-to-one" /></td>
        </tr>
        <tr>
          <td />
          <td><input type="submit" value="Crear" /></td>
        </tr>
      </tbody>
    </table>
  </g:form>
--%>

	<div class="container">
		<div class="row">
			<div class="span12">
				<g:form class="form-horizontal" action="register">
					<fieldset>
						<legend>Crear un nuevo usuario:</legend>
						<g:if test="${flash.message}">
							<p class="text-danger">
								${flash.message}
							</p>
						</g:if>
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
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-lg-2 control-label">Repetir contraseña</label>
							<div class="col-lg-10">
								<input class="form-control" id="password2" name="password2" placeholder="Repetir contraseña" type="password" value="">
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputPassword" class="col-lg-2 control-label">Rol del usuario</label>
							<div class="col-lg-10">
								<g:select id="role" name="role" from="${ar.com.campochico.Role.list()}" optionKey="name" required="" class="many-to-one" />
							</div>
						</div>
						
						<div class="form-group ">
							<div class="col-lg-10 col-lg-offset-2">
								<button type="submit" class="btn btn-primary">Crear usuario</button>
							</div>
						</div>
					</fieldset>
				</g:form>
			</div>
		</div>
	</div>

</body>

</html>