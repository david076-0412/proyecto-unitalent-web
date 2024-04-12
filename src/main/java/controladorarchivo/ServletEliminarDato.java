package controladorarchivo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArchivoMaterialDAO;
import entidad.ArchivosMateriales;
import entidad.Materiales;


import dao.MaterialDAO;








/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/eliminardatomaterial")
public class ServletEliminarDato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArchivoMaterialDAO archivomaterialDAO;
	private MaterialDAO materialDAO;
	
	public void init() {
		archivomaterialDAO = new ArchivoMaterialDAO();
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
			
			showEditForm(request, response);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		String id = request.getParameter("archivo");
		archivomaterialDAO.deleteUser(id);
		response.sendRedirect("listartema");
                
                
		System.out.println(id);		
                
        
		

	}
	
	
	
	
	

}
