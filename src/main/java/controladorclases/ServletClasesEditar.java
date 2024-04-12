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

@WebServlet("/editclase")
public class ServletClasesEditar extends HttpServlet {
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
			
			showEditForm(request, response);
			
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Clases existingUser = claseDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("clases-form.jsp");
		request.setAttribute("clases", existingUser);
		dispatcher.forward(request, response);

	}
	
	
	
	
	

}

