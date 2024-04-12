<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport" content="width=device-width, initial-scale-1.0">


<title>Aula Virtual UNITALENT</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrapValidator.css">
<link rel="stylesheet" href="css/styleadm.css" />
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

<link href="imagen/logotipoem.ico" type="image/x-icon" rel="shortcut icon" />


	<link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/estilosadm.css">




	




</head>

<body>
	
	
	
	
	
	
	
	
	<div class="contenedor-formulario contenedor">
	
		<div class="imagen-formulario">
		
		</div>
		
		
		
		<div  class="wrapper">
			
			
			
			<form id="panel-i" action="panel-inicio.jsp" method="post">
			
			<button type="submit" class="close" data-dismiss="modal" 
		  	aria-hidden="true">&times;</button>
		  	</form>
		  	
		  	<form id="formLogin" action="admin" method="post">
			
			<center><div class="brand">
						
						
						<img src="imagen/logo2CUNIMATIC.png" id="logo" class="animated flipInX">
						
						
					</div></center>
			
			
			<h1>Iniciar Sesión</h1>
			
				<input type="hidden" name="tipo" value="iniciarSesion" />
				
				
				<div class="input-box">
					
					<input type="email" name="correo" placeholder="Correo de Usuario" required/>
					<i class='bx bxs-user'></i>
				</div>
				
				
				<div class="input-box">
				
				
					
					
					
					<input id="myInput" 
					type="password" 
					
					name="clave" 
					placeholder="Contraseña" required/>
					
					<span class="eye" onclick="myFunction()">
					<i id="hide1" class="bx bx-show"></i>
					<i id="hide2" class="bx bx-hide"></i>
					
					</span>
					
					
					
					
				</div>
				
				<div class="remember-forgot">
				<a href="forgotPassword.jsp">Recuperar Password?</a>
				</div>
				
				
				
				<button type="submit" class="btn">Iniciar sesión</button>
				
				
				
				
				<c:set var="mensaje" value="${requestScope.mensaje}" />
				<c:if test="${not empty mensaje}">
					<div id="alertLogin" class="alert alert-danger alert-dismissible fade in">
						${mensaje}
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					</div>
				</c:if>
				
				
			</form>
		</div>
		
		
		
	</div>
        
	
	
	
	
	
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script src="js/bootstrapValidator.js"></script>
	<script src="js/script.js"></script>
	
	
	<script>
	
		function myFunction(){
			var x = document.getElementById("myInput");
			var y = document.getElementById("hide1");
			var z = document.getElementById("hide2");
			
			
			if(x.type === 'password'){
				x.type = "text";
				y.style.display = "block";
				z.style.display = "none";
			}else{
				x.type = "password";
				y.style.display="none";
				z.style.display="block";
			}
			
			
			
			
			
			
		}
	
	
	
	</script>
	
	
	
	
	
	
	
	
	
</body>




</html>