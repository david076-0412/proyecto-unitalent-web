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

import dao.MaterialDAO;
import entidad.Materiales;


import dao.TemaDAO;
import entidad.Temas;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/listartema")
public class ServletTemasListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MaterialDAO materialDAO;
	
	private TemaDAO temaDAO;
	
	public void init() {
		materialDAO = new MaterialDAO();
		
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
			
			
			listUser(request, response);
			
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		
		
		
		List<Materiales> listCursos = materialDAO.selectAllUsers();
		
		
		List<Temas> listCur = temaDAO.selectAllUsers();
		
		request.setAttribute("listCursos", listCursos);
		request.setAttribute("listCu", listCur);
		
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("clases-material.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	
	
	
	
	

}

