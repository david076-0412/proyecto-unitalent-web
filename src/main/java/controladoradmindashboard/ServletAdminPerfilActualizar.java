package controladoradmindashboard;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import entidad.Admin;

import javax.servlet.http.HttpSession;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/updateadmindashboard")
public class ServletAdminPerfilActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDAO adminDAO;
	
	public void init() {
		adminDAO = new AdminDAO();
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
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String usuario = request.getParameter("usuario");
		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		
		String telefono = request.getParameter("telefono");
		
		
		
		
		Admin admin = new Admin();
		
		
		admin = new Admin(id, usuario, correo, clave, nombre,apellido,telefono);

		adminDAO.updateUserPerfil(admin);
		
		
		
		admin = adminDAO.selectUsers(id);
		
		
		HttpSession session = request.getSession();
        session.setAttribute("admin", admin);
		
        request.getRequestDispatcher("admin-perfil.jsp").forward(request, response);
		
		
		
		
		
		
		
	}
	
	
	
	
	

}