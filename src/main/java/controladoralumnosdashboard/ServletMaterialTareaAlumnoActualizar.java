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
import entidad.ArchivoCalifica;
import entidad.Calificaciones;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/updatematerialtareaalumno")
public class ServletMaterialTareaAlumnoActualizar extends HttpServlet {
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
			
			updateUser(request, response);
			
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String archivo = request.getParameter("archivo");
		Calificaciones book = new Calificaciones(id, archivo);
		tareaDAO.updateUserCalificacionta(book);
		
		
		
		List<ArchivoCalifica> sumaterial =  tareaDAO.selectAllArchivoCalifica();
		
		request.setAttribute("listCalifica", sumaterial);
		
		
		
        Calificaciones existing = (Calificaciones) tareaDAO.selectUsersCalificacion(id);
        request.setAttribute("calificacion", existing);


        RequestDispatcher dispatcher = request.getRequestDispatcher("alumno-calificacion-material-dashboard.jsp");

        dispatcher.forward(request, response);
	}
	
	
	
	
	

}
