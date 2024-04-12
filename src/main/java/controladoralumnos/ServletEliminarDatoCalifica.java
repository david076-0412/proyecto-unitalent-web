package controladoralumnos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArchivoCalificaDAO;
import entidad.ArchivoCalifica;
import entidad.ArchivosTareas;
import entidad.Calificaciones;
import entidad.Tarea;


import dao.TareaDAO;








/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/eliminardatocalifica")
public class ServletEliminarDatoCalifica extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArchivoCalificaDAO archivocalificaDAO;
	private TareaDAO tareaDAO;
	
	public void init() {
		archivocalificaDAO = new ArchivoCalificaDAO();
		tareaDAO = new TareaDAO();
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
		archivocalificaDAO.deleteUser(id);
		
		int idt = Integer.parseInt(request.getParameter("id"));
		
		Calificaciones existing = (Calificaciones) tareaDAO.selectUsersCalificacion(idt);
		request.setAttribute("calificacion", existing);
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("alumno-calificacion-material-dashboard.jsp");
		
		dispatcher.forward(request, response);
		
		
                
		
		
		
                
		System.out.println(id);		
                
        
		

	}
	
	
	
	
	

}