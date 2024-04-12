package controladortema;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TemaDAO;
import entidad.Temas;









/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/inserttema")
public class ServletTemasGuardar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TemaDAO temaDAO;
	public void init() {
		temaDAO = new TemaDAO();
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
		
		
		String temas = request.getParameter("tema");
		
		
		Temas newUser = new Temas(temas);
		
		
		temaDAO.insertUser(newUser);
		

		
		
		response.sendRedirect("listarclase");
		
		
	}
	
	
	
	
	

}