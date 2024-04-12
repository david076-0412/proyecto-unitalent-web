

<jsp:include page="validar.jsp" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>





<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.*"%>


<%@page import="java.util.Date"%>





<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
        <title>Cursos</title>
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
		  <li class="dropdown">
		  <a href="list" class="dashboard"><i class="material-icons">dashboard</i>
		  Alumnos</a>
		  </li>
		  
		  <li class="dropdown">
		  <a href="docente-perfil.jsp" class="dashboard"><i class="material-icons">aspect_ratio</i>
		  Perfil</a>
		  
		  
		  
		  
		  <li class="dropdown">
		  <a href="<%=request.getContextPath()%>/listarclase" class="dashboard"><i class="material-icons">apps</i>
		  Clases</a>
		  </li>
		  
		  <li class="dropdown">
		  <a href="#addTemaCurso" class="dashboard" data-toggle="modal"><i class="material-icons">person_outline</i>
		  Tema</a>
		  </li>
		  
		  
		  
		 <li class="dropdown">
		  <a href="<%=request.getContextPath()%>/listarasistencia" class="dashboard"><i class="material-icons">equalizer</i>
		  Asistencia</a>
		  </li>
		  
		  
		  
		 <li class="active">
		  <a href="<%=request.getContextPath()%>/listartarea" class="dashboard"><i class="material-icons">extension</i>
		  Tarea</a>
		  </li>
		  
		  
		  
		  
		   
		  <li class="dropdown">
		  <a href="docentes?tipo=cerrarSesion" class=""><i class="material-icons">date_range</i>Logout </a>
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
							   
							   
							   
							    <c:if test="${sessionScope.docentes.perfil != null}">
                                
                                <a class="nav-link" href="#" data-toggle="dropdown">
								<img src="perfildoimagen/<c:out value='${sessionScope.docentes.perfil}' />" style="width:40px; border-radius:50%;"/>
								<span class="xp-user-live"></span>
								</a>
                                
                                
                                </c:if>
                                
                                <c:if test="${sessionScope.docentes.perfil == null}">
                                
                                <a class="nav-link" href="#" data-toggle="dropdown">
								<img src="img/user.png" style="width:40px; border-radius:50%;"/>
								<span class="xp-user-live"></span>
								</a>
                                
                                </c:if>
                                
								 
								 
								 
								 
								 
								  <ul class="dropdown-menu small-menu">
								     <li><a href="docente-perfil.jsp">
									 <span class="material-icons">person_outline</span>
									 Perfil
									 </a></li>
									 
									 <li><a href="docentes?tipo=cerrarSesion">
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
                    <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/listarclase">Calificacion</a></li>
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
							    <h2 class="ml-lg-2">Calificacion</h2>
							 </div>
							 <div class="col-sm-6 p-0 flex justify-content-lg-end justify-content-center">
							 
							 
							   
							   
							 </div>
							 
							 
							 
					     </div>
					   </div>
					   
<div class="modal-dialog">
    <div class="modal-content">
      
        <div class="modal-header">
        
        
        
        <%
				//Obteniendo la fecha actual
				Date fechaActual=new Date();
				
				
				//Formateando la fecha
				DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
				DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
				
				
				
 				%>
        
        
        
        			<h4 class="modal-title">
					
					Calificacion Subida
						
					</h4>
        
        
          
          
          
          
           <a href="<%=request.getContextPath()%>/listarclase" class="btn btn-default" >
          <span class="close" data-dismiss="modal" aria-hidden="true">&times;
		  </span>
          
          </a>
          
        </div>
        
        
        
        
        
        
        
        <form action="updatecalificacion" method="post">
				
				
				
				
        <c:if test="${calificacion != null}">
					<input type="hidden" name="id" value="<c:out value='${calificacion.id}' />" />
				</c:if>
        
        
        
        <div class="modal-body">
          <div class="form-group">
            <label>Nombre de la Tarea</label> <input type="text"
						value="<c:out value='${calificacion.titulo}' />" class="form-control"
						name="titulo" disabled="disabled">
          </div>
          
          <div class="form-group">
          <label>Descripcion</label> <input type="text"
						value="<c:out value='${calificacion.descripcion}' />" class="form-control"
						name="descripcion" disabled="disabled">
          </div>
          
          
          <div class="form-group">
         <a href="#addArchivo" class="btn btn-sucess" data-toggle="modal">
				<span class="material-icons">person_outline</span>
				Archivo Guardado</a>
				
		</div>	
          
          
          
          <div class="form-group">
           <label>Archivo</label> <input type="text"
						value="<c:out value='${calificacion.archivo}' />" class="form-control"
						name="archivo" disabled="disabled">
          </div>
          
          
          
          
          
          <div class="form-group">
            <label>Clase</label> <input type="text"
						value="<c:out value='${calificacion.nivel}' />" class="form-control"
						name="nivel" disabled="disabled">
						
          </div>
          
          
           <div class="form-group">
            <label>Materia</label> <input type="text"
						value="<c:out value='${calificacion.materia}' />" class="form-control"
						name="mat" disabled="disabled">
						
          </div>
          
          
          
          
          
          
          <div class="form-group">
            <label>Alumnos</label> <input type="text"
						value="<c:out value='${calificacion.name}' />" class="form-control"
						name="alu" disabled="disabled">
						
          </div>
          
          
          
          
          <div class="form-group">
            <label>Temas</label> <input type="text"
						value="<c:out value='${calificacion.tema}' />" class="form-control"
						name="alu" disabled="disabled">
						
          </div>
          
          
          
          
          
          
          <div class="form-group">
            <label>Puntos</label> 
					
					<input type="number"
						value="<c:out value='${calificacion.nota}' />" class="form-control"
						name="nota" min="1" max="20" value="20" step="any" required="required">
						
          </div>
          
          
          
          
          <div class="form-group">
            <label>Fecha de Entrega</label> 
					
					<input type="date"
						class="form-control"
						id="fechade" name="fechade" 
						value="<c:out value='${calificacion.fechade}' />" 
						min="2000-01-01" max="2070-12-31" 
						aria-label="Utiliza el formato DD/MM/AAAA"
						pattern="^(0?[1-9]|[12]\d|3[01])[\/](0?[1-9]|1[0-2])[\/](19|20)\d{2}$"
						
						required="required">
						
          </div>
          
          
          
          
          <div class="form-group">
            <label>Hora</label> 
					
					<input type="time"
						class="form-control"
						id="hora" name="hora" value="<c:out value='${calificacion.hora}' />">
						
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
		  
		 

		 
		 
		 
		 
	<div class="modal fade" tabindex="-1" id="addTemaCurso" role="dialog">
  <div class="modal-dialog" role="document">
  
  
    <div class="modal-content">
    <form action="inserttema" method="post">
    
      <div class="modal-header">
      
     
      
      
        <h5 class="modal-title">Añadir un tema</h5>
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      
      
      <div class="modal-body">
        
        
        <div class="form-group">
		    <label>Tema</label>
			<input type="text" class="form-control" name="tema" required>
		</div>
		
		
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
        <button type="submit" class="btn btn-success">Añadir</button>
        
      </div>
      
      
      
      
      </form>
      
    </div>
  </div>
</div>
			 
		 
		 
		 
		 
		 <div class="modal fade" tabindex="-1" id="addArchivo" role="dialog">
  <div class="modal-dialog" role="document">
  
  
    <div class="modal-content">
    <form action="eliminararchivotarea" enctype="MULTIPART/FORM-DATA" method="post">
    
      <div class="modal-header">
      
     
      
      
        <h5 class="modal-title">Material</h5>
        
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      
      
      <div class="modal-body">
        
        
        
        <fieldset class="form-group">
					<label>Archivo</label> <input type="text"
						value="<c:out value='${calificacion.archivo}' />" class="form-control"
						name="archivo" disabled="disabled">
				</fieldset>

        
        <img src="caimagen/<c:out value='${calificacion.archivo}' />" width="320" height="320"/>
        
		 
		<p> 
		<a download="<c:out value='${calificacion.archivo}' />" href="taimagen/<c:out value='${calificacion.archivo}' />" class="btn btn-sucess">
		<span class="material-icons">person_outline</span>descargar</a></p>
		
		
		
		
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        
        
      </div>
      
      
      
      
      </form>
      
    </div>
  </div>
</div>
	
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
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