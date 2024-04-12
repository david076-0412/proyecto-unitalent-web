<!doctype html>
<html>
<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Aula Virtual UNIMATIC</title>
<link
	href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css'
	rel='stylesheet'>
<link href='' rel='stylesheet'>

<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

<link href="imagen/logotipoem.ico" type="image/x-icon" rel="shortcut icon" />

<script type='text/javascript'
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<style>
body {
	background-position: center;
	background-color: #eee;
	background-repeat: no-repeat;
	background-size: cover;
	color: #505050;
	font-family: "Rubik", Helvetica, Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	line-height: 1.5;
	text-transform: none
}

.forgot {
	background-color: #fff;
	padding: 12px;
	border: 1px solid #dfdfdf
}

.padding-bottom-3x {
	padding-bottom: 72px !important
}

.card-footer {
	background-color: #fff
}

.btn {
	font-size: 13px
}

.form-control:focus {
	color: #495057;
	background-color: #fff;
	border-color: #76b7e9;
	outline: 0;
	box-shadow: 0 0 0 0px #28a745
}
</style>
</head>
<body oncontextmenu='return false' class='snippet-body'>
	<div class="container padding-bottom-3x mb-2 mt-5">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10">
				<div class="forgot">
					<h2>¿Olvidaste tu contraseña?</h2>
					<p>Cambie su contraseña en tres sencillos pasos. 
					¡Esto le ayudará a proteger su contraseña!</p>
					<ol class="list-unstyled">
						<li><span class="text-primary text-medium">1. </span>Introduzca su dirección de 
						correo electrónico a continuación.</li>
						<li><span class="text-primary text-medium">2. </span>Nuestro 
						sistema le enviará una OTP a su correo electrónico</li>
						<li><span class="text-primary text-medium">3. </span>Ingrese la OTP 
						en la página siguiente</li>
					</ol>
				</div>
				<form class="card mt-4" action="forgotPassword" method="POST">
					<div class="card-body">
						<div class="form-group">
							<label for="email-for-pass">Ingresa tu email</label> <input
								class="form-control" type="text" name="email" id="email-for-pass" required="required"><small
								class="form-text text-muted">Ingrese la dirección de correo electrónico registrada. Pues
								envíe una OTP por correo electrónico a esta dirección.</small>
						</div>
						
						<div class="form-group">
							<label for="email-for-pass">Ingresa la Contraseña de aplicaciones</label> <input
								class="form-control" type="text" name="conaplicacion" id="conaplicacion" required=""><small
								class="form-text text-muted">Ingrese la contraseña que esta dentro del Gmail registrada. 
								La contraseñas de aplicaciones esta dentro de la verificación de 2 pasos.</small>
						</div>
						
						
					</div>
					<div class="card-footer">
						<button class="btn btn-success" type="submit">Obtener nueva contraseña</button>
						

						<a href="login.jsp" class="btn btn-danger">Atrás para iniciar sesión</a>
		
						</div>
						
							
							
							
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type='text/javascript'
		src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>
	<script type='text/javascript' src=''></script>
	<script type='text/javascript' src=''></script>
	<script type='text/Javascript'></script>
</body>
</html>