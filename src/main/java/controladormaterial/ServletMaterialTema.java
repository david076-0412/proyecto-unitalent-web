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

import dao.TemaDAO;
import entidad.Temas;


import dao.ArchivoMaterialDAO;
import entidad.ArchivosMateriales;



/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/vermaterialtema")
public class ServletMaterialTema extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MaterialDAO materialDAO;
	private TemaDAO temaDAO;
	private ArchivoMaterialDAO archivomaterialDAO;
	
	
	public void init() {
		materialDAO = new MaterialDAO();
		temaDAO = new TemaDAO();
		archivomaterialDAO = new ArchivoMaterialDAO();

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
		
		Materiales existingUser = materialDAO.selectUsers(id);
		
		
		request.setAttribute("material", existingUser);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ver-material.jsp");
		
		dispatcher.forward(request, response);

	}
	
	
	
	
	

}
