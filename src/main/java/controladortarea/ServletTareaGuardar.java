package controladortarea;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.Mysqlx.Error;

import dao.TareaDAO;
import entidad.Tarea;

import entidad.Calificaciones;



/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/inserttarea")
public class ServletTareaGuardar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TareaDAO tareaDAO;
	public void init() {
		tareaDAO = new TareaDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			
			insertUser(request, response);
			
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		
		Tarea tareas = new Tarea();
		Calificaciones calificacion = new Calificaciones();
		
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		String archivo = request.getParameter("archivo");
		String nivel = request.getParameter("nivel");
		String materia = request.getParameter("materia");
		String name = request.getParameter("name");
		String tema = request.getParameter("tema");
		int nota = Integer.parseInt(request.getParameter("nota"));
		
		
		String fechade = request.getParameter("fechade");
		
		
		
		
		String formato = "yyyy-mm-dd";
		
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		
		Date date = null;
		try {
			date = sdf.parse(fechade);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String fechade_na = sdf.format(date);
		
		
		 SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");

		 String fechaFormateada = formatoSalida.format(date);
		
		
		
		
		
		
		
		String hora = request.getParameter("hora");
		
		
		
		
		tareas = new Tarea(titulo,descripcion,archivo,nivel,materia, name,tema,nota,fechaFormateada ,hora);
		
		tareaDAO.insertUser(tareas);
		
	    calificacion = new Calificaciones(titulo,descripcion,archivo,nivel,materia, name,tema,nota,fechaFormateada ,hora);
		
		tareaDAO.insertUserCalificacion(calificacion);
		
		
		
		response.sendRedirect("listarclase");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
