package controladorasistencia;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import dao.AsistenciaDAO;
import entidad.Alumnos;
import entidad.Asistencias;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/insertasistencia")
public class ServletAsistenciaGuardar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AsistenciaDAO asistenciaDAO;
	
	public void init() {
		asistenciaDAO = new AsistenciaDAO();
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
			
			
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		
		int dni = Integer.parseInt(request.getParameter("dni"));
		
		String clase = request.getParameter("clase");
		
		String materia = request.getParameter("materia");
		
		String tipoasistencia = request.getParameter("tipoasistencia");
		
		
		
		asistenciaDAO.insertUser(dni,tipoasistencia,clase,materia);
		
		
		response.sendRedirect("alumno-institucion-dashboard.jsp");
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
		
	

}
