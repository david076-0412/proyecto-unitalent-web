


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
    
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel de Inicio</title>
    <link rel="stylesheet" href="css/estilospi.css">
    
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

	<link href="imagen/logotipoem.ico" type="image/x-icon" rel="shortcut icon" />
    
</head>
<body>



    <div class="container__cards">
		
        <div class="card">
            <div class="cover">
                <img src="images/adminlogin.png" alt="">
                <div class="img__back"></div>
            </div>
            <div class="description">
                <h2>Administrador</h2>
                <p>Administracion, Monitoreo, supervision de los docentes y estudiantes</p>
                <form action="loginadmin.jsp" method="post">
                <input type="submit" value="Admin">
                </form>
                
                
                
            </div>
        </div>

        <div class="card">
            <div class="cover">
                <img src="images/docentelogin.png" alt="">
                <div class="img__back"></div>
            </div>
            <div class="description">
                <h2>Docentes</h2>
                <p>Cursos, materiales, tareas y calificaciones</p>
                <form action="login.jsp" method="post">
                <input type="submit" value="Docente">
                
                </form>
                
                
                
                
            </div>
        </div>

        <div class="card">
            <div class="cover">
                <img src="images/estudiantelogin.png" alt="">
                <div class="img__back"></div>
            </div>
            <div class="description">
                <h2>Estudiantes</h2>
                <p>Asistencias, cursos, tareas y notas</p>
                <form action="loginalumnos.jsp" method="post">
                <input type="submit" value="Estudia">
                </form>
                
                
                
            </div>
        </div>

    </div>
    
</body>
</html>