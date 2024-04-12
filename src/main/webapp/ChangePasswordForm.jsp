<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport" content="width=device-width, initial-scale-1.0">


<title>Aula Virtual UNIMATIC</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrapValidator.css">
<link rel="stylesheet" href="css/stylerp.css" />
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">



<link href="imagen/logotipoem.ico" type="image/x-icon" rel="shortcut icon" />

</head>
<body>




<script language="javascript">
function fncSubmit()
{

	if(document.ChangePasswordForm.OldPassword.value == "")
	{
		alert('Please input old password');
		document.ChangePasswordForm.OldPassword.focus();
		return false;
	}	

	if(document.ChangePasswordForm.newpassword.value == "")
	{
		alert('Please input Password');
		document.ChangePasswordForm.newpassword.focus();		
		return false;
	}	

	if(document.ChangePasswordForm.conpassword.value == "")
	{
		alert('Please input Confirm Password');
		document.ChangePasswordForm.conpassword.focus();		
		return false;
	}	

	if(document.ChangePasswordForm.newpassword.value != document.ChangePasswordForm.conpassword.value)
	{
		alert('Confirm Password Not Match');
		document.ChangePasswordForm.conpassword.focus();		
		return false;
	}	

		document.ChangePasswordForm.submit();
}
</script>



  
  
  
  
  
  
  
  
  
  
  
  
  
  <div  class="wrapper">
  
			
			<form name="ChangePasswordForm" method="post" action="processChangePWD.jsp" OnSubmit="return fncSubmit();">
			
			<center>
			
			<div class="brand">
			
			
			<img src="imagen/recovery-password.png" id="logo" class="animated flipInX">
				
				
						
			</div>
			
			
			</center>
			
			
			
			<h1>Recuperar Password</h1>
			
				
				
				
				<div class="input-box">
					
					<input type="password" name="OldPassword" placeholder="Antigua Password" id="OLDpwd" size="20" required="required"/>
					<span class="eye" onclick="myFunction1()">
					<i id="hide1" class="bx bx-show"></i>
					<i id="hide2" class="bx bx-hide"></i>
					
					</span>
				</div>
				
				
				<div class="input-box">
					<input type="password" name="newpassword" placeholder="Nueva Password" id="newpassword" required="required"/>
					
					<span class="eye" onclick="myFunction2()">
					<i id="hide3" class="bx bx-show"></i>
					<i id="hide4" class="bx bx-hide"></i>
					
					
					
					
				</div>
				
				
				<div class="input-box">
					<input type="password" name="conpassword" placeholder="Confirmar Password" id="conpassword" required="required"/>
					<span class="eye" onclick="myFunction3()">
					<i id="hide5" class="bx bx-show"></i>
					<i id="hide6" class="bx bx-hide"></i>
					
				</div>
				
				
				
				
				
				
				<button type="submit" class="btn" value="Save">Enviar</button>
				
				
				
				
				
				
				
			</form>
		</div>
  
  
  
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  	<script src="js/bootstrapValidator.js"></script>
	<script src="js/script.js"></script>
  
  
  
  	
  	
  	
  	<script>
	
		function myFunction1(){
			var x = document.getElementById("OLDpwd");
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
		
		
		
		
		function myFunction2(){
			var x = document.getElementById("newpassword");
			var y = document.getElementById("hide3");
			var z = document.getElementById("hide4");
			
			
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
		
		
		
		
		
		function myFunction3(){
			var x = document.getElementById("conpassword");
			var y = document.getElementById("hide5");
			var z = document.getElementById("hide6");
			
			
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