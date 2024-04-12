<jsp:include page="validaralumno.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
        <title>Pagina de la Institucion Educativa</title>
	    <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.minsl.css">
	    <!----css3---->
        <link rel="stylesheet" href="css/custom.css">
		
		
		<!--google fonts -->
	
	    <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
	
	
	<!--google material icon-->
      <link href="https://fonts.googleapis.com/css2?family=Material+Icons"rel="stylesheet">
      
      
      <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

	  <link href="imagen/logotipoem.ico" type="image/x-icon" rel="shortcut icon" />

  </head>
  <body>
  

<div class="wrapper">


        <div class="body-overlay"></div>
		
		<!-------------------------sidebar------------>
		     <!-- Sidebar  -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3><img src="imagen/logotipoempresa.png" class="img-fluid"/><span>UNITALENT</span></h3>
            </div>
            <ul class="list-unstyled component m-0">
		  <li class="active">
		  <a href="alumno-institucion-dashboard.jsp" class="dashboard"><i class="material-icons">dashboard</i>
		  Pagina de la Institucion Educativa</a>
		  </li>
		  
		  <li class="dropdown">
		  <a href="alumno-perfil.jsp" class="dashboard"><i class="material-icons">aspect_ratio</i>
		  Perfil</a>
		  
		  
		  
		  
		  <li class="dropdown">
		  <a href="listarcursosalumnos?name=<c:out value='${sessionScope.alumnos.name} ${sessionScope.alumnos.apellido}' />" class="dashboard"><i class="material-icons">apps</i>
		  Cursos</a>
		  </li>
		  
		 
		  
		  <li class="dropdown">
		  <a href="<%=request.getContextPath()%>/asistenciagrabar" class="dashboard"><i class="material-icons">equalizer</i>
		  Asistencia</a>
		  </li>
		  
		  
		  
		  <li class="dropdown">
		  <a href="listartareaalumnos?name=<c:out value='${sessionScope.alumnos.name} ${sessionScope.alumnos.apellido}' />" class="dashboard"><i class="material-icons">extension</i>
		  Tarea</a>
		  </li>
		  
		  
		  
		  
		   
		  <li class="dropdown">
		  <a href="alumnos?tipo=cerrarSesion" class=""><i class="material-icons">date_range</i>Logout </a>
		  </li>
		 
		
		</ul>

           
        </nav>
		
		
		
		
		<!--------page-content---------------->
		
		<div id="content">
		   
		   <!--top--navbar----design--------->
		   
		   <div class="top-navbar">
		      <div class="xp-topbar">

                <!-- Start XP Row -->
                <div class="row"> 
                    <!-- Start XP Col -->
                    <div class="col-2 col-md-1 col-lg-1 order-2 order-md-1 align-self-center">
                        <div class="xp-menubar">
                               <span class="material-icons text-white">signal_cellular_alt
							   </span>
                         </div>
                    </div> 
                    <!-- End XP Col -->

                    <!-- Start XP Col -->
                    <div class="col-md-5 col-lg-3 order-3 order-md-2">
                        <div class="xp-searchbar">
                            <form>
                                
                            </form>
                        </div>
                    </div>
                    <!-- End XP Col -->

                    <!-- Start XP Col -->
                    <div class="col-10 col-md-6 col-lg-8 order-1 order-md-3">
                        <div class="xp-profilebar text-right">
							 <nav class="navbar p-0">
                        <ul class="nav navbar-nav flex-row ml-auto">   
                            
                            
                            <li class="nav-item dropdown">
                            
                            
                            
                            
                                <c:if test="${alumnos.perfil != null}">
                                
                                <a class="nav-link" href="#" data-toggle="dropdown">
								<img src="perfilimagen/<c:out value='${sessionScope.alumnos.perfil}' />" style="width:40px; border-radius:50%;"/>
								<span class="xp-user-live"></span>
								</a>
                                
                                
                                </c:if>
                                
                                <c:if test="${alumnos.perfil == null}">
                                
                                <a class="nav-link" href="#" data-toggle="dropdown">
								<img src="img/user.png" style="width:40px; border-radius:50%;"/>
								<span class="xp-user-live"></span>
								</a>
                                
                                </c:if>
								
								
								
								
								
								<ul class="dropdown-menu small-menu">
                                    <li>
                                        <a href="alumno-perfil.jsp">
										  <span class="material-icons">
											person_outline
											</span>Perfil

										</a>
                                    </li>
                                    
                                    <li>
                                        <a href="alumnos?tipo=cerrarSesion"><span class="material-icons">
										logout</span>Cerrar Sesion</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    
               
            </nav>
							
                        </div>
                    </div>
                    <!-- End XP Col -->

                </div> 
                <!-- End XP Row -->

            </div>
		     <div class="xp-breadcrumbbar text-center">
                <h4 class="page-title">Dashboard</h4> 
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="alumno-institucion-dashboard.jsp">Inicio</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
                    
					      
                  </ol>                
            </div>
			 
		   </div><center><p><h6><img src="imagen/logotipoempresa.png" class="img-fluid" style="width:170px; border-radius:50%;"/></h6></p></center>
		   
		   
		<div class="main-content">
		   
		   
		   <div class="row">
			  
			  <div class="col-md-12">
				
				<div class="table-wrapper">
				
					<div class="table-title">
    
     					<div class="row">
     
      						<div class="col-sm-6 p-0 d-flex justify-content-lg-start justify-content-center">
        
        					<h2 class="ml-lg-2">¡Bienvenido a una nueva era en la educación a distancia! </h2>
        		
        					</div>
        		
      						</div>
      			
      						<p>
        					<td>Aquí inicia un nuevo reto en tu Institucion Educativa. Te presentamos la plataforma educativa Dashboard Learn, que hoy se une a la familia UNITALENT para darte la bienvenida a una nueva era de educación digital. 



La herramienta Dashboard Learn, brindará un mejor flujo de aprendizaje, mayor funcionalidad y sobretodo permitirá una mejor interacción entre estudiantes y docentes; y así puedan compartir actividades de una manera sencilla, efectiva y 100% amigable.</td>
        					</p>
    
    						</div>
				
						</div>
				
					</div>
			  
			  
			  	</div>
		   
		   
		   
		   
		   
		   
		   </div>
		   
		   
		   
		   
		    
		    
		    
			  
			    
				
				
    
    
     <!----footer-design------------->
		 
		  <footer class="footer">
		    <div class="container-fluid">
			   <div class="footer-in">
			      <p class="mb-0"><span class="material-icons">copyright</span> 2023 UNITALENT. Todos los derechos Reservados.</p>
			   </div>
			</div>
		 </footer>
     
        
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		
		
</div>
</div>








  
     <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
   <script src="js/jquery-3.3.1.slim.min.js"></script>
   <script src="js/popper.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script src="js/jquery-3.3.1.min.js"></script>
  
  
  <script type="text/javascript">
        
		$(document).ready(function(){
		  $(".xp-menubar").on('click',function(){
		    $('#sidebar').toggleClass('active');
			$('#content').toggleClass('active');
		  });
		  
		   $(".xp-menubar,.body-overlay").on('click',function(){
		     $('#sidebar,.body-overlay').toggleClass('show-nav');
		   });
		  
		});
		
</script>
  
  



  </body>
  
  </html>
