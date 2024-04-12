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

import entidad.Clases;
import entidad.Materiales;
import entidad.Temas;
import dao.ArchivoMaterialDAO;
import entidad.Alumnos;
import entidad.ArchivosMateriales;
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/editmaterial")
public class ServletMaterialEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MaterialDAO materialDAO;
	private ArchivoMaterialDAO archivomaterialDAO;
	
	public void init() {
		materialDAO = new MaterialDAO();
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
		
		
		List<Temas> listTemas =  materialDAO.selectAllTemas();
		List<Alumnos> listAlumnos =  materialDAO.selectAllAlumnos();
		List<Clases> listClasesC =  materialDAO.selectAllClasesC();
		
		
		request.setAttribute("listTemas", listTemas);
		request.setAttribute("listAlumnos", listAlumnos);
		request.setAttribute("listClasesC", listClasesC);
		
		
		List<ArchivosMateriales> sumaterial =  materialDAO.selectAllArchivosMaterial();
		
		request.setAttribute("listARMaterial", sumaterial);
		
		
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Materiales existing = (Materiales) materialDAO.selectUsers(id);
		request.setAttribute("material", existing);
		
		
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("material-edit-form.jsp");
		
		dispatcher.forward(request, response);

	}
	
	
	
	
	

}

