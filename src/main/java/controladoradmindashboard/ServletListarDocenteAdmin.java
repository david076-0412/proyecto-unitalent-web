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

@WebServlet("/listdocentesadmin")
public class ServletListarDocenteAdmin extends HttpServlet {
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
			
			
			listUser(request, response);
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Docentes> listUser = docenteDAO.selectAllUsers();
		request.setAttribute("listDocente", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("docente-list.jsp");
		dispatcher.forward(request, response);
	}
	


}
