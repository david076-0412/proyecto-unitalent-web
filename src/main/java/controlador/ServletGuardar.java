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

@WebServlet("/insert")
public class ServletGuardar extends HttpServlet {
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
			
			insertUser(request, response);
			
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String apellido = request.getParameter("apellido");
		int dni = Integer.parseInt(request.getParameter("dni"));
		String email =request.getParameter("email");
		String direccion = request.getParameter("direccion");
		String password = request.getParameter("password");
		String sexo = request.getParameter("sexo");
		
		
		String fechadn = request.getParameter("fechadn");
		
		
		
		String formato = "yyyy-mm-dd";
		
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		
		Date date = null;
		try {
			date = sdf.parse(fechadn);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		 SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");

		 String fechaFormateada = formatoSalida.format(date);
		
		
		
		
		
		
		
		
		
		int telefono = Integer.parseInt(request.getParameter("telefono"));
		Alumnos newUser = new Alumnos(name, apellido, dni, email, direccion,password,sexo,fechaFormateada,telefono);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}
	
	
	
	
	

}
