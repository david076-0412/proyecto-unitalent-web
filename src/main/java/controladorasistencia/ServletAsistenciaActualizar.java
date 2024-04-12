package controladorasistencia;

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

import dao.AsistenciaDAO;
import entidad.Asistencias;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/updateasistencia")
public class ServletAsistenciaActualizar extends HttpServlet {
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
			
			updateUser(request, response);
			
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String clase = request.getParameter("clase");
		String materia = request.getParameter("materia");
		String seccion = request.getParameter("seccion");
		String tipoasistencia = request.getParameter("tipoasistencia");
		
		
		String fechade = request.getParameter("fechade");
		
		
		
		
		
		
		
		
		
		
		String hora = request.getParameter("hora");
		
		
		Asistencias asistencia = new Asistencias(id, nombre,apellido,clase,materia,seccion,tipoasistencia,fechade,hora);
		asistenciaDAO.updateUser(asistencia);
		response.sendRedirect("listarasistencia");
		
		
	}
	
	
	
	
	

}
