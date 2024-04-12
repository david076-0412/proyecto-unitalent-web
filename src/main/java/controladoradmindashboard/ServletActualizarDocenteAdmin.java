package controladoradmindashboard;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@WebServlet("/updatedocenteadmin")
public class ServletActualizarDocenteAdmin extends HttpServlet {
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
			
			updateUser(request, response);
			
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String usuario = request.getParameter("usuario");
		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		int dni = Integer.parseInt(request.getParameter("dni"));
		String direccion = request.getParameter("direccion");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String sexo = request.getParameter("sexo");
		String fechadn = request.getParameter("fechadn");
		
		
		
		
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		
		

		
		
		Docentes book = new Docentes(id,usuario, correo, clave, dni, direccion, nombre,apellido, sexo, fechadn, telefono);
		docenteDAO.updateUserDo(book);
		
		
		response.sendRedirect("listdocentesadmin");
	}
	
	
	
	
	

}


