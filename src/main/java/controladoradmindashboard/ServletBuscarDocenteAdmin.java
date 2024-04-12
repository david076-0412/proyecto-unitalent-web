package controladoradmindashboard;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DocenteDAO;
import entidad.Docentes;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/buscardocenteadmin")
public class ServletBuscarDocenteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DocenteDAO docenteDAO;
	
	public void init() {
		docenteDAO = new DocenteDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			
			
			buscarUser(request, response);
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void buscarUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String dato = request.getParameter("txtBuscar");
		String datoap = request.getParameter("txtBuscar");
		List<Docentes> lista=docenteDAO.selectUserBuscar(dato,datoap);
		request.setAttribute("listDocente", lista);
		RequestDispatcher dispatcher = request.getRequestDispatcher("docente-list.jsp");
		dispatcher.forward(request, response);
	}
	


}