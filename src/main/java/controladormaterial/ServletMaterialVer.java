package controladormaterial;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MaterialDAO;
import entidad.Materiales;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/vermaterial")
public class ServletMaterialVer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MaterialDAO materialDAO;
	
	public void init() {
		materialDAO = new MaterialDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			
			showVerForm(request, response);
			
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void showVerForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		Materiales existingUser = (Materiales) materialDAO.selectUsers(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listarmaterial");
		
		request.setAttribute("material", existingUser);
		
		
		dispatcher.forward(request, response);

	}
	
	
	
	
	

}
