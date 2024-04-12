package controladorasistencia;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClaseDAO;
import entidad.Clases;
/**
 * Servlet implementation class ServletAsistenciaGrabar
 */
@WebServlet("/asistenciagrabar")
public class ServletAsistenciaGrabar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClaseDAO claseDAO;
	
	public void init() {
		claseDAO = new ClaseDAO();
	}
    public ServletAsistenciaGrabar() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			
			
			listUser(request, response);
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Clases> listClases = claseDAO.selectAllUsers();
		request.setAttribute("listClasesC", listClases);
		RequestDispatcher dispatcher = request.getRequestDispatcher("asistencia-alumnos.jsp");
		dispatcher.forward(request, response);
	}

}
