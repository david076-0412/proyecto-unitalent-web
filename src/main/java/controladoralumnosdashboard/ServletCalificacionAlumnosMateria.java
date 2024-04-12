package controladoralumnosdashboard;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TareaDAO;

import entidad.Clases;
import entidad.Tarea;
import entidad.Temas;
import dao.ArchivoTareaDAO;
import entidad.Alumnos;
import entidad.ArchivosTareas;

import entidad.Calificaciones;

import entidad.ArchivoCalifica;
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/calificacionalumnosvernota")
public class ServletCalificacionAlumnosMateria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TareaDAO tareaDAO;
	private ArchivoTareaDAO archivotareaDAO;
	
	public void init() {
		tareaDAO = new TareaDAO();
		archivotareaDAO = new ArchivoTareaDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			
			showEditForm(request, response);
			
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Calificaciones existing = (Calificaciones) tareaDAO.selectUsersCalificacion(id);
		request.setAttribute("calificacion", existing);
		
		
		
		List<ArchivoCalifica> sumaterial =  tareaDAO.selectAllArchivoCalifica();
		
		request.setAttribute("listCalifica", sumaterial);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("alumno-calificacion-material-dashboard.jsp");
		
		dispatcher.forward(request, response);

	}
	
	
	
	
	

}