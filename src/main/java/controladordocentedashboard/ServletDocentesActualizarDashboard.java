package controladordocentedashboard;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DocenteDAO;
import entidad.Docentes;

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

@WebServlet("/updatedocentedashboard")
public class ServletDocentesActualizarDashboard extends HttpServlet {
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
			throws SQLException, IOException, ServletException {
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
		String perfil = request.getParameter("perfil");
		
		
		
		
		Docentes docentes = new Docentes();
		
		
		docentes = new Docentes(id, usuario, correo, clave, dni, direccion, nombre,apellido,sexo,fechadn,telefono,perfil);

		docenteDAO.updateUserPerfil(docentes);
		
		
		
		docentes = docenteDAO.selectUsers(id);
		
		
		HttpSession session = request.getSession();
        session.setAttribute("docentes", docentes);
		
        request.getRequestDispatcher("docente-perfil.jsp").forward(request, response);
		
		
		
		
		
		
		
	}
	
	
	
	
	

}