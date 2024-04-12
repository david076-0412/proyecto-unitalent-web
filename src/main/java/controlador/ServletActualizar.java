package controlador;

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

import dao.UserDAO;
import entidad.Alumnos;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/update")
public class ServletActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	public void init() {
		userDAO = new UserDAO();
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
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String apellido = request.getParameter("apellido");
		int dni = Integer.parseInt(request.getParameter("dni"));
		String email = request.getParameter("email");
		String direccion = request.getParameter("direccion");
		String password = request.getParameter("password");
		String sexo = request.getParameter("sexo");
		
		
		
		String fechadn = request.getParameter("fechadn");
		
		
		
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		String perfil = request.getParameter("perfil");
		

		
		
		Alumnos book = new Alumnos(id, name, apellido, dni, email, direccion,password,sexo,fechadn,telefono,perfil);
		userDAO.updateUserPerfil(book);
		
		
		response.sendRedirect("list");
	}
	
	
	
	
	

}

