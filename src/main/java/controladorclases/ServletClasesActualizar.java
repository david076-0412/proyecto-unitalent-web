
package controladorclases;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClaseDAO;
import entidad.Clases;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/updateclase")
public class ServletClasesActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClaseDAO claseDAO;
	
	public void init() {
		claseDAO = new ClaseDAO();
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
		String clase = request.getParameter("clase");
		String seccion = request.getParameter("seccion");
		String materia = request.getParameter("materia");
		String aula = request.getParameter("aula");

		Clases book = new Clases(id, clase, seccion, materia, aula);
		claseDAO.updateUser(book);
		response.sendRedirect("listarclase");
	}
	
	
	
	
	

}
