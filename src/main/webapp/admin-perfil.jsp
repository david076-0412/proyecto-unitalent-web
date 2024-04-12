<jsp:include page="validaradmin.jsp" />



<%@ page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException" %>

<%@page import="conexion.Conexion" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.SQLException" %>

<%@ page import="java.sql.Connection" %>

<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
        <title>Perfil</title>
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
		  <li class="dropdown">
		  <a href="<%=request.getContextPath()%>/listalumnosadmin" class="dashboard"><i class="material-icons">dashboard</i>
		  Alumnos</a>
		  </li>
		  
		  <li class="active">
		  <a href="admin-perfil.jsp" class="dashboard"><i class="material-icons">aspect_ratio</i>
		  Perfil</a>
		  
		  
		  
		  
		  <li class="dropdown">
		  <a href="<%=request.getContextPath()%>/listdocentesadmin" class="dashboard"><i class="material-icons">apps</i>
		  Docentes</a>
		  </li>
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		   
		 <li class="dropdown">
		  <a href="admin?tipo=cerrarSesion" class=""><i class="material-icons">date_range</i>Logout </a>
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
                                <a class="nav-link" href="#" data-toggle="dropdown">
								<img src="img/user.png" style="width:40px; border-radius:50%;"/>
								<span class="xp-user-live"></span>
								</a>
                                
                                
                                
                                
                                
								
								
								<ul class="dropdown-menu small-menu">
                                    <li>
                                        <a href="admin-perfil.jsp">
										  <span class="material-icons">
											person_outline
											</span>Perfil

										</a>
                                    </li>
                                    
                                    <li>
                                        <a href="admin?tipo=cerrarSesion"><span class="material-icons">
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
                    <li class="breadcrumb-item"><a href="admin-perfil.jsp">Perfil</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
                  </ol>                
            </div>
			 
		   </div>
		   
		   
		   
		   
		   <center>
		   <p>
		   
		   
		   
		   
		   <img src="img/user.png" style="width:180px; border-radius:50%;" class="img-fluid"/>
		   
		   
		   <tr>
		   
          
		  
			
			
		   
		   <h4>${sessionScope.admin.nombre} ${sessionScope.admin.apellido}</h4>
		   
		   
		   </p>
		   
		   </center>
		   
		   
		   
		   
		   
		   
		   
		   <div class="main-content">
		   
		   
		   <div class="row g-0">
			  
			  <div class="col-md-12">
				
				<div class="table-wrapper">
				
					<div class="table-title">
    
     					<div class="row">
     
      						<div class="col-sm-6 p-0 d-flex justify-content-lg-start justify-content-center">
        
        					<h2 class="ml-lg-2">Informacion Basica</h2>
        		
        					</div>
        		
      						</div>
      						
      						
      						
      						<div class="main-content">
      						<div class="row">
			  					
			  					<div class="col-md-12">
								
								
								<div class="table-wrapper">
									
									
									
									
									
									
									
									
									
									<div class="table-title">
    								
    								
    								<div class="row">
      								
      								<div class="col-sm-6 p-0 d-flex justify-content-lg-start justify-content-center">
       							
       								
       								<table class="table table-striped table-hover">
       								
       								
       								
       								 <tbody>
       								 <tr>
       								 
       								 <td>Nombre Completo: ${sessionScope.admin.nombre} ${sessionScope.admin.apellido}</td>
       								 
       								 <td>
            						 <a href="#editEmployeeModal" class="edit" data-toggle="modal">
									 <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
            
          							</td>
          							
       								 
       								 </tr>
       								 
       								 <tr>
       								 
       								 <td>Correo Electronico: ${sessionScope.admin.correo}</td>
       								 
       								 <td>
            						 <a href="#editEmployeeModal" class="edit" data-toggle="modal">
									 <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
            
          							</td>
       								 
       								 
       								 
       								 </tr>
       								 
       								  <tr>
       								 
       								 <td>Usuario: ${sessionScope.admin.usuario}</td>
       								 
       								 <td>
            						 <a href="#editEmployeeModal" class="edit" data-toggle="modal">
									 <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
            
          							</td>
       								 
       								 
       								 
       								 </tr>
       								 
       								 
       								 </tbody>
       								
       								</table>
      
       								
       							
       								</div>
      								
      								
      								</div>
    								
    								
    								</div>
									
									
									
									</div>
								
								</div>
			  					
			  					</div>
      						
      						</div>
			  					
			    
    
    						</div>
    						
    						
    						
    						
    						
    						
    						
    						
    						
    					
      						
      						
    						
    						
    						
    						
    						<div class="table-title">
    
     					<div class="row g-0">
     
      						<div class="col-sm-6 p-0 d-flex justify-content-lg-start justify-content-center">
        
        					<h2 class="ml-lg-2">Informacion de Contacto</h2>
        		
        					</div>
        		
      						</div>
      						
      						
      						<div class="main-content">
      						<div class="row">
			  					
			  					<div class="col-md-12">
								
								
								<div class="table-wrapper">
									
									<div class="table-title">
    								
    								
    								<div class="row">
      								
      								<div class="col-sm-6 p-0 d-flex justify-content-lg-start justify-content-center">
       							
       								
       								<table class="table table-striped table-hover">
       								
       								
       								
       								 <tbody>
       								 
       								 <tr>
       								 
       								 
       								 
       								 </tr>
       								 
       								 <tr>
       								 
       								 <td>Numero de Telefono: ${sessionScope.admin.telefono}</td>
       								 <td>
            						 <a href="#editEmployeeModal" class="edit" data-toggle="modal">
									 <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
            
          							</td>
       								 
       								 </tr>
       								 
       								 
       								 
       								 
       								 </tbody>
       								
       								</table>
      
       							
       								</div>
      								
      								
      								</div>
    								
    								
    								</div>
									
									
									
									</div>
								
								
								
								
								</div>
			  					
			  					
			  					
			  					</div>
      						
      						</div>
			  					
			    
    
    						</div>
    					
    						
    						
    						
    						
    						
    						
    						
    						
    						
    						
    						
    						
				
						</div>
				
				
				
					</div>
			  
			  
			  
			  	</div>
		   
		   
		   
		   </div>
		   
		   
		 
		</div>
</div>















<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <form action="updateadmindashboard" method="post">
        <div class="modal-header">
          <h4 class="modal-title">Editar Administrador</h4>
          <button type="button" class="close" data-dismiss="modal" 
		  aria-hidden="true">&times;</button>
        </div>
        
        <c:if test="${admin != null}">
		<input type="hidden" name="id" value="${admin.id}" />
		</c:if>
        
        
          
        
        
        <div class="modal-body">
        
        <div class="form-group">
            <label>Usuario</label>
            <input type="text" class="form-control" value="${admin.usuario}" name="usuario" required="required">
          </div>
        
        
        <div class="form-group">
            <label>Correo Electronico</label>
            <input type="email" class="form-control" value="${admin.correo}" name="correo" required>
          </div>
          
          <div class="form-group">
            <label>Password</label>
            <input type="text" class="form-control" value="${admin.clave}" name="clave" required>
          </div>
        
        
        
          <div class="form-group">
            <label>Nombres</label>
            <input type="text" class="form-control" value="${admin.nombre}" name="nombre" required="required">
          </div>
          
          <div class="form-group">
            <label>Apellidos</label>
            <input type="text" class="form-control" value="${admin.apellido}" name="apellido" required="required">
          </div>
          
          
          
          <div class="form-group">
            <label>Telefono</label>
            <input type="text" value="${admin.telefono}" name="telefono" minlength="9" maxlength="11" class="form-control" required>
          </div>
          
          
          
          
          
          
          
          
        </div>
        <div class="modal-footer">
          <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancelar">
          <input type="submit" class="btn btn-info" value="Guardar">
        </div>
      </form>
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