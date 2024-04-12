

<jsp:include page="validaradmin.jsp" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<%@page import="java.sql.ResultSet"%>
<%@page import="entidad.Materiales"%>
<%@page import="dao.MaterialDAO"%>
<%@page import="entidad.ArchivosMateriales"%>

<%@page import="java.util.List"%>





<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
        <title>Admin Alumnos</title>
	    <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.minsl.css">
	    <!----css3---->
        <link rel="stylesheet" href="css/custom.css">
		
		
		<!--google fonts -->
	    <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
	
		<link href="imagen/logotipoem.ico" type="image/x-icon" rel="shortcut icon" />
	   <!--google material icon-->
       <link href="https://fonts.googleapis.com/css2?family=Material+Icons"rel="stylesheet">
      
      
     <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
       
    
      
      

  </head>
  <body>
  


<div class="wrapper">
     
	  <div class="body-overlay"></div>
	 
	 <!-------sidebar--design------------>
	 
	 <div id="sidebar">
	    <div class="sidebar-header">
		   <h3><img src="imagen/logotipoempresa.png" class="img-fluid"/><span>UNITALENT</span></h3>
		</div>
		<ul class="list-unstyled component m-0">
		  <li class="active">
		  <a href="<%=request.getContextPath()%>/listalumnosadmin" class="dashboard"><i class="material-icons">dashboard</i>
		  Alumnos</a>
		  </li>
		  
		  
		  
		  <li class="dropdown">
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
	 </div>
	 
   <!-------sidebar--design- close----------->
   
   
   
      <!-------page-content start----------->
   
      <div id="content">
	     
		  <!------top-navbar-start-----------> 
		     
		  <div class="top-navbar">
		     <div class="xd-topbar">
			     <div class="row">
				     <div class="col-2 col-md-1 col-lg-1 order-2 order-md-1 align-self-center">
					    <div class="xp-menubar">
						    <span class="material-icons text-white">signal_cellular_alt</span>
						</div>
					 </div>
					 
					 <div class="col-md-5 col-lg-3 order-3 order-md-2">
					     
					 </div>
					 
					 
					 <div class="col-10 col-md-6 col-lg-8 order-1 order-md-3">
					     <div class="xp-profilebar text-right">
						    <nav class="navbar p-0">
							   <ul class="nav navbar-nav flex-row ml-auto">
							   
							   
							  
							   
							   <li class="dropdown nav-item">
							   
							   <a class="nav-link" href="#" data-toggle="dropdown">
								<img src="img/user.png" style="width:40px; border-radius:50%;"/>
								<span class="xp-user-live"></span>
								</a>
							   
							    
                                
								 
								 
								 
								 
								 
								  <ul class="dropdown-menu small-menu">
								     <li><a href="admin-perfil.jsp">
									 <span class="material-icons">person_outline</span>
									 Perfil
									 </a></li>
									 
									 <li><a href="admin?tipo=cerrarSesion">
									 <span class="material-icons">logout</span>
									 Cerrar Sesion
									 </a></li>
									 
								  </ul>
							   </li>
							   
							   
							   </ul>
							</nav>
						 </div>
					 </div>
					 
				 </div>
				 
				 <div class="xp-breadcrumbbar text-center">
				    <h4 class="page-title">Dashboard</h4>
					<ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/listalumnosadmin">Alumnos</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
                  </ol>   
				 </div>
				 
				 
			 </div>
		  </div>
		  <!------top-navbar-end-----------> 
		  
		  
		   <!------main-content-start-----------> 
		     
		      <div class="main-content">
			     <div class="row">
				    <div class="col-md-12">
					   <div class="table-wrapper">
					     
					   <div class="table-title">
					     <div class="row">
						     <div class="col-sm-6 p-0 flex justify-content-lg-start justify-content-center">
							    <h2 class="ml-lg-2">Alumnos</h2>
							 </div>
							 <div class="col-sm-6 p-0 flex justify-content-lg-end justify-content-center">
							 
							 
							   
							   
							 </div>
							 
							 
							 
					     </div>
					   </div>
					   
<div class="modal-dialog">
    <div class="modal-content">
      
        <div class="modal-header">
          
          <caption>
          
          <h4 class="modal-title">
          
          <c:if test="${alumnos != null}">
          
          
           Editar Alumno
          
          
           </c:if>
           
           
          <c:if test="${alumnos == null}">
          
          Añadir Nuevo Alumno
            			
            			
          </c:if>
            		
          </h4>
          
          
         
						
          
          </caption>
          
          
           <a href="<%=request.getContextPath()%>/listalumnosadmin" class="btn btn-default" >
          <span class="close" data-dismiss="modal" aria-hidden="true">&times;
		  </span>
          
          </a>
          
        </div>
        
        <c:if test="${alumnos != null}">
		<form action="updatealumnoadmin" method="post">
		</c:if>
		
		<c:if test="${alumnos == null}">
		
		<form action="insertalumnoadmin" method="post">
		
		</c:if>
		
		
        <input type="hidden" name="id" value="${alumnos.id}" />
        

        
        
        
        <div class="modal-body">
          <div class="form-group">
            <label>Nombre del Alumno</label> <input type="text"
			value="<c:out value='${alumnos.name}' />" class="form-control" name="name" required="required">
          </div>
          
          <div class="form-group">
           <label>Apellido del Alumno</label> <input type="text"
						value="<c:out value='${alumnos.apellido}' />" class="form-control"
						name="apellido" required="required">
          </div>
          
          
          
          <div class="form-group">
            <label>Dni del Alumno</label> <input type="text"
						value="<c:out value='${alumnos.dni}' />" class="form-control" 
						name="dni" minlength="7" maxlength="8"required="required">
          </div>
          
          
          
          <div class="form-group">
            <label>Correo del Alumno</label> <input type="text"
						value="<c:out value='${alumnos.email}' />" class="form-control" 
						name="email" required="required">
          </div>
          
          
          <div class="form-group">
            <label>Direccion del Alumno</label> <input type="text"
						value="<c:out value='${alumnos.direccion}' />" class="form-control" 
						name="direccion" required="required">
          </div>
          
          
          <div class="form-group">
            <label>Password</label> <input type="text"
						value="<c:out value='${alumnos.password}' />" class="form-control" 
						name="password" required="required">
          </div>
          
           <c:if test="${alumnos == null}">
        
        <div class="form-group">
          
          <p><label>Seleccionar Sexo</label>
				
				<select id="sexo" name="sexo" class="form-control" required>
					
					<option selected="selected" disabled="disabled" value="">sin archivo</option>
					
					<option>Masculino</option>
					<option>Femenino</option>
					
					</select>
				</p>
          
          </div>
        
        
        </c:if>
          
          
          <c:if test="${alumnos != null}">
        
        <div class="form-group">
            <label>Sexo</label> <input type="text"
						value="<c:out value='${alumnos.sexo}' />" class="form-control" disabled>
          </div>
          
          <div class="form-group">
          
          <p><label>Seleccionar Sexo</label>
				
				<select id="sexo" name="sexo" class="form-control" required>
					
					<option selected="selected" disabled="disabled" value="">sin archivo</option>
					
					<option>Masculino</option>
					<option>Femenino</option>
					
					</select>
				</p>
          
          </div>
          
        
        
        
        </c:if>
          
          
          
          
          
          
          
          
          
          
          
          
          
          
        <c:if test="${alumnos == null}">
        
        <div class="form-group">
            <label>Fecha de Nacimiento</label> <input type="date"
						value="<c:out value='${alumnos.fechadn}' />" class="form-control" 
						name="fechadn" name="fechadn" minlength="8" maxlength="10" required="required">
          </div>
        
        
        </c:if>
          
          
          <c:if test="${alumnos != null}">
        
        <div class="form-group">
            <label>Fecha de Nacimiento</label> <input type="text"
						value="<c:out value='${alumnos.fechadn}' />" class="form-control" 
						name="fechadn" placeholder="DD/MM/YYYY" name="fechadn" minlength="8" maxlength="10" required="required">
          </div>
        
        
        </c:if>
          
          
          
          <div class="form-group">
            <label>Telefono</label> <input type="text"
						value="<c:out value='${alumnos.telefono}' />" class="form-control" 
						name="telefono" minlength="9" maxlength="11" required="required">
          </div>
          
          
          
          
          
          
        </div>
        <div class="modal-footer">
        
         <button type="submit" class="btn btn-success">Guardar</button>
         
          
          
        </div>
      </form>
    </div>
  </div>
					   
					   
					   
					   
	</div>
	</div>
					
			    
					
					
				 
	</div>
</div>
		  
		    <!------main-content-end-----------> 
		  
		 
		 
		 

		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 <!----footer-design------------->
		 
		  <footer class="footer">
		    <div class="container-fluid">
			   <div class="footer-in">
			      <p class="mb-0"><span class="material-icons">copyright</span> 2023 UNITALENT. All Rights Reserved.</p>
			   </div>
			</div>
		 </footer>
		 
		 
		 
		 
	  </div>
   
</div>



<!-------complete html----------->





  
     <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
   <script src="js/jquery-3.3.1.slim.min.js"></script>
   <script src="js/popper.min.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script src="js/jquery-3.3.1.min.js"></script>
  
  
  
	
 
 	
 
  
  
  
  
  
  
  
  
  
  
  
  
  
  <script type="text/javascript">
       $(document).ready(function(){
	      $(".xp-menubar").on('click',function(){
		    $("#sidebar").toggleClass('active');
			$("#content").toggleClass('active');
		  });
		  
		  $('.xp-menubar,.body-overlay').on('click',function(){
		     $("#sidebar,.body-overlay").toggleClass('show-nav');
		  });
		  
	   });
  </script>
  
  



  </body>
  
  </html>



