<jsp:include page="validaralumno.jsp" />

<%@ page session="true" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.*"%>


<%@page import="java.util.Date"%>



<!DOCTYPE html>
<html lang="es">
<head>


<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">




<title>Asistencia</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
	
	
	<!--google fonts -->
	    <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
	
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	
	<link href="https://fonts.googleapis.com/css2?family=Material+Icons"rel="stylesheet">
	
	
	
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3/js/bootstrap.min.js"></script>
	
	
	
	
	
	<link rel="preconnect" href="https://fonts.gstatic.com" />
    <link href="https://fonts.googleapis.com/css2?family=Tinos:ital,wght@0,400;0,700;1,400;1,700&amp;display=swap" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=DM+Sans:ital,wght@0,400;0,500;0,700;1,400;1,500;1,700&amp;display=swap" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link rel="stylesheet" href="assets/css/snackbar.min.css">
    <link href="assets/index/css/styles.css" rel="stylesheet" />
	
	
	<link href="imagen/logotipoem.ico" type="image/x-icon" rel="shortcut icon" />
	
	
	
	
	
	
	
	
</head>
<body>


			
			
			
	   <img class="bg-video" src="assets/images/bg.jpg" alt="">
			
		
		
		
			
			
		<div class="masthead">
		
		
		
		
		
		
		
		
		<form action="insertasistencia" method="post">
		
		
		
        <div class="masthead-content text-white">
            <div class="container-fluid px-lg-0">
                <div class="widget">
                    <div class="fecha">
                        <p id="diaSemana" class="diaSemana"></p>
                        <p id="dia" class="dia"></p>
                        <p>de </p>
                        <p id="mes" class="mes"></p>
                        <p>del </p>
                        <p id="year" class="year"></p>
                    </div>
                    
                    
                    
                    <div class="reloj">
                        <p id="horas" class="horas"></p>
                        <p>:</p>
                        <p id="minutos" class="minutos"></p>
                        <p>:</p>
                        
                        <div class="caja-segundos">
                            <p id="segundos" class="segundos"></p>
                            <p id="ampm" class="ampm"></p>
                        </div>
                        
                    </div>
                    
                </div>
                
                
                
                
                
                <h1 class="fst-italic lh-1 mb-4">Sistema de registro de asistencia</h1>
                <p class="mb-5">Entradas y salidas de las personas</p>
                
                
                
                
                    <!-- Email address input-->
                    <div class="row input-group-newsletter">
                    
                   
                    
                    
                        <div class="col">
                        
                        
                        
                        
                        
                        <input type="text" class="form-control"name="dni" placeholder="Ingrese dni" required="required">
                        
                        
                        
                        </div>
                        
                        
                        <div class="col">
                        
                        <p>
						<select id="clase" name="clase" class="form-control" required>
					
						<option selected="selected" disabled="disabled" value="">sin Clases</option>
					
						<c:forEach var="clases" items="${listClasesC}">
					
						 
						
						<option>${clases.clase}</option>
						
						</c:forEach>
						
						</select>
					
						</p>
                        
                        
                        </div>
                        
                        
                        
                        <div class="col">
                        
                        <p>
						<select id="materia" name="materia" class="form-control" required>
					
						<option selected="selected" disabled="disabled" value="">sin Clases</option>
					
						<c:forEach var="clases" items="${listClasesC}">
					
						 
						
						<option>${clases.materia}</option>
						
						</c:forEach>
						
						</select>
					
						</p>
                        
                        
                        </div>
                        
                        
                        
                        
                        
                        
                        
                        
                        <div class="col-auto">
                        
                        
                        
                        
                        
                        <button type="submit" class="btn btn-success">Guardar</button>
                        
                        
                        
                        
                        
                        </div>
                        
                        
                        
                        
                        
                    
                    
                    
                    
                    
                    
                    
                    </div>

                    <!-- Social Icons-->
                    <div class="social-icons">
                    
                    
                    
                        <div class="d-flex flex-row flex-lg-column justify-content-center align-items-center h-100 mt-3 mt-lg-0">
                            
                            
                            
                            
                            
                            <div>
                            
                            
                            
                            
                                <label>
                                
                                
                                    <input type="radio" name="tipoasistencia" value="asistio" checked />
                    				<span>asistio</span>
                                </label>
                                
                                
                                <label>
                                
                                
                                
                                
                                    <input type="radio" name="tipoasistencia" value="ausente" />
                     				<span>ausente</span>
                                    
                                    
                                    
                                </label>
                           
                           
                           
                           		<label>
                                
                                
                                
                                
                                    <input type="radio" name="tipoasistencia" value="falto" />
                     				<span>falto</span>
                                    
                                    
                                    
                                </label>
                           
                           
                           
                           
                           
                           
                            </div>
                            
                            
                            
                            
                            
                            
                            
                            
                        </div>
                        
                        
                        
                        
                        
                        
                        
                        
                    </div>
                
                
                
                
                
                
                
                
            </div>
        </div>
        
        
        </form>
        
    </div>
			
			
		<div class="social-icons">
        <div class="d-flex flex-row flex-lg-column justify-content-center align-items-center h-100 mt-3 mt-lg-0">
            <a class="btn btn-primary" href="alumno-institucion-dashboard.jsp">Dash</a>
        </div>
    </div>	
			
			
			
			
			
			
			
			
			
			
			
			
			

			
			
			





			
						
			

			
		
		
		
						
							   
				
				
				
				
							   
							   
							   
							   
			
			
 	  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	
	
	
	
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	  
	  <script src="assets/js/snackbar.min.js"></script>
      <script src="assets/js/axios.min.js"></script>
	 
	  
	  <script src="assets/index/js/scripts.js"></script> 
	  
	  
	  
	  
	
	
	

</body>
</html>