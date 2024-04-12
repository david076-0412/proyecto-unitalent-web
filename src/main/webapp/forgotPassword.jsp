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
					<h2>�Olvidaste tu contrase�a?</h2>
					<p>Cambie su contrase�a en tres sencillos pasos. 
					�Esto le ayudar� a proteger su contrase�a!</p>
					<ol class="list-unstyled">
						<li><span class="text-primary text-medium">1. </span>Introduzca su direcci�n de 
						correo electr�nico a continuaci�n.</li>
						<li><span class="text-primary text-medium">2. </span>Nuestro 
						sistema le enviar� una OTP a su correo electr�nico</li>
						<li><span class="text-primary text-medium">3. </span>Ingrese la OTP 
						en la p�gina siguiente</li>
					</ol>
				</div>
				<form class="card mt-4" action="forgotPassword" method="POST">
					<div class="card-body">
						<div class="form-group">
							<label for="email-for-pass">Ingresa tu email</label> <input
								class="form-control" type="text" name="email" id="email-for-pass" required="required"><small
								class="form-text text-muted">Ingrese la direcci�n de correo electr�nico registrada. Pues
								env�e una OTP por correo electr�nico a esta direcci�n.</small>
						</div>
						
						<div class="form-group">
							<label for="email-for-pass">Ingresa la Contrase�a de aplicaciones</label> <input
								class="form-control" type="text" name="conaplicacion" id="conaplicacion" required=""><small
								class="form-text text-muted">Ingrese la contrase�a que esta dentro del Gmail registrada. 
								La contrase�as de aplicaciones esta dentro de la verificaci�n de 2 pasos.</small>
						</div>
						
						
					</div>
					<div class="card-footer">
						<button class="btn btn-success" type="submit">Obtener nueva contrase�a</button>
						

						<a href="login.jsp" class="btn btn-danger">Atr�s para iniciar sesi�n</a>
		
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