package controladoralumnos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Alumnos;
import modelo.ModeloAlumnoUsuario;

@WebServlet("/alumnos")
public class ServletAlumnoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		
		if ("iniciarSesion".equals(tipo)) {
			this.iniciarSesion(request, response);
		} else if ("cerrarSesion".equals(tipo)) {
			this.cerrarSesion(request, response);
		} else if ("forgotPassword".equals(tipo)) {
			this.RecuperarPassword(request, response);
		}
	}
	
	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String correo = request.getParameter("email");
		String clave = request.getParameter("password");
		

		ModeloAlumnoUsuario modelo = new ModeloAlumnoUsuario();
		Alumnos alumnos = modelo.iniciarSesion(correo, clave);
		
		
		

		if (alumnos == null) {
			request.setAttribute("mensaje", "Error nombre de usuario y/o clave");
			request.getRequestDispatcher("loginalumnos.jsp").forward(request, response);
		} else {
			HttpSession sesion = request.getSession();
			sesion.setAttribute("alumnos", alumnos);
			response.sendRedirect("alumno-institucion-dashboard.jsp");
		}
	}
	
	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.setAttribute("mensaje", "Inicia sesión");
		request.getRequestDispatcher("loginalumnos.jsp").forward(request, response);
	}
	
	
	private void RecuperarPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.setAttribute("mensaje", "Recuperacion exitosa");
		request.getRequestDispatcher("loginalumnos.jsp").forward(request, response);
	}
	
	
	
}