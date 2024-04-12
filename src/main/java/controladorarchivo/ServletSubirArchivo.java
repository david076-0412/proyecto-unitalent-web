package controladorarchivo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArchivoMaterialDAO;
import entidad.ArchivosMateriales;
import entidad.Materiales;
import entidad.Temas;

import java.util.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.*;
import java.io.*;






/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/subirarchivomaterial")
public class ServletSubirArchivo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArchivoMaterialDAO archivomaterialDAO;
	
	public void init() {
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
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		
		
		
		
		
		FileItemFactory file_factory = new DiskFileItemFactory();
		 
        /*ServletFileUpload esta clase convierte los input file a FileItem*/
        ServletFileUpload servlet_up = new ServletFileUpload(file_factory);
        /*sacando los FileItem del ServletFileUpload en una lista */
        List items = servlet_up.parseRequest(request);
 
        for(int i=0;i<items.size();i++){
            /*FileItem representa un archivo en memoria que puede ser pasado al disco duro*/
            FileItem item = (FileItem) items.get(i);
            /*item.isFormField() false=input file; true=text field*/
            if (! item.isFormField()){
                /*cual sera la ruta al archivo en el servidor*/
                File archivo_server = new File("C:\\xampp\\htdocs\\WebEscolarUni\\src\\main\\webapp\\maimagen\\"+item.getName());
                /*y lo escribimos en el servido*/
                item.write(archivo_server);
                System.out.println("<p> fieldName --> " + item.getName());
                
                String nombre = item.getName();
                String ruta = item.getName();
        		ArchivosMateriales newUser = new ArchivosMateriales(nombre,ruta);
        		archivomaterialDAO.insertUser(newUser);
        		response.sendRedirect("listarmaterial");
                
            }
        }
		
		

	}
	
	
	
	
	

}
