package controladortarea;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TareaDAO;
import entidad.Alumnos;
import entidad.ArchivosTareas;
import entidad.Clases;
import entidad.Tarea;
import entidad.Temas;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/newtarea")
public class ServletTareaNuevo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TareaDAO tareaDAO;
	
	public void init() {
		tareaDAO = new TareaDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		showNewForm(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		List<Temas> listTemas =  tareaDAO.selectAllTemas();
		List<Alumnos> listAlumnos =  tareaDAO.selectAllAlumnos();
		List<Clases> listClasesC =  tareaDAO.selectAllClasesC();
		
		List<ArchivosTareas> sumaterial =  tareaDAO.selectAllArchivosTareas();
		
		
		
		request.setAttribute("listARMaterial", sumaterial);
		
		request.setAttribute("listTemas", listTemas);
		request.setAttribute("listAlumnos", listAlumnos);
		request.setAttribute("listClasesC", listClasesC);
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("tarea-form.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	
	

}

