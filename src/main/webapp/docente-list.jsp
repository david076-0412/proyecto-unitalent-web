

<jsp:include page="validaradmin.jsp" />



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
        <title>Admin Docentes</title>
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
      
      
       <link href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css"rel="stylesheet">
       
    
       <link href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css"rel="stylesheet">
    
      
      

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
		  <li class="dropdown">
		  <a href="<%=request.getContextPath()%>/listalumnosadmin" class="dashboard"><i class="material-icons">dashboard</i>
		  Alumnos</a>
		  </li>
		  
		  
		  
		  <li class="dropdown">
		  <a href="admin-perfil.jsp" class="dashboard"><i class="material-icons">aspect_ratio</i>
		  Perfil</a>
		  
		  
		  
		  
		  <li class="active">
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
					     <div class="xp-searchbar">
						     <form action="buscardocenteadmin">
							    <div class="input-group">
								  <input type="search" name="txtBuscar" class="form-control"
								  placeholder="Search">
								  <div class="input-group-append">
								     <button class="btn" type="submit" name="accion" id="button-addon2">Go
									 </button>
								  </div>
								</div>
							 </form>
						 </div>
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
                    <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/listdocentesadmin">Docentes</a></li>
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
							    <h2 class="ml-lg-2">Lista de Docentes</h2>
							 </div>
							 <div class="col-sm-6 p-0 flex justify-content-lg-end justify-content-center">
							 
							  <a href="<%=request.getContextPath()%>/newdocenteadmin" class="btn btn-success">
							   <i class="material-icons">&#xE147;</i>
							   <span>Añadir Nuevo Docente</span>
							   </a>
							   
							   
							   
							 </div>
							 
							 
							 
					     </div>
					   </div>
					   
					   <table id="example" class="table table-striped" style="width:100%">
       <thead>
					<tr>
						
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Correo</th>
						<th>Direccion</th>
						<th>Telefono</th>
						<th>Editar</th>
						<th>Eliminar</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="docente" items="${listDocente}">

						<tr>
							
							<td><c:out value="${docente.nombre}" /></td>
							<td><c:out value="${docente.apellido}" /></td>
							
							<td><c:out value="${docente.correo}" /></td>
							<td><c:out value="${docente.direccion}" /></td>
							<td><c:out value="${docente.telefono}" /></td>
							
							
							<td><a href="editdocenteadmin?id=${docente.id}" class="edit"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
								
							
							
							<td>
							
							<a href="deletedocenteadmin?id=${docente.id}" class="delete"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
							
							</td>
							
							
							</tr>
							
							
							
					</c:forEach>
            
            
            
            
            
            
            
        		</tbody>
        
      
    		</table>
					   
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
  
  
  
  <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
  
  <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
  
  <script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>
  
  
  


	<script>

 	
	$(document).ready(function(){
 		
 		
 		$('#example').DataTable({
 			"searching": false
 			
 		}
 				
 		
 		);	
 	});
	
	
	
	
	
	
	</script>
 
 	
 
  
  
  
  
  
  
  
  
  
  
  
  
  
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
