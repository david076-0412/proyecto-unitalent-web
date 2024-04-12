package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidad.Materiales;
import conexion.Conexion;
import entidad.Temas;
import entidad.Alumnos;
import entidad.ArchivosMateriales;
import entidad.ArchivosTareas;
import entidad.Clases;


import entidad.Tarea;


import entidad.Calificaciones;


import entidad.ArchivoCalifica;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class TareaDAO {
	
	
	public static PreparedStatement press=null;
	public static Connection conec=null;
	public static Statement st = null;
	public static ResultSet rt = null;
	
	
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bd_sistema?useUnicode=yes&characterEncoding=UTF-8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "9$8753JK5";

	private static final String INSERT_USERS_SQL = "INSERT INTO tarea" + "  (titulo,descripcion,archivo,nivel,materia,name,tema,nota,fechade,hora) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	
	
	
	private static final String SELECT_USER_BY_ID = "select id,titulo,descripcion,archivo,nivel,materia,name,tema,nota,fechade,hora from tarea where id = ?";
	
	private static final String SELECT_ALL_USERS = "select * from tarea order by tema";
	private static final String DELETE_USERS_SQL = "delete from tarea where id = ?;";
	private static final String UPDATE_USERS_SQL = "update tarea set titulo = ?,descripcion = ?, archivo = ?, nivel= ?, materia =?, name =? , tema=?, nota=?, fechade=?, hora=? where id = ?;";
	
	private static final String SELECT_ALL = "select t.id, m.titulo, m.descripcion, m.nivel, m.materia, a.name, t.tema, t.nota, t.fechade,t.hora from tarea m, temas t, alumnos a";
	
	
	
	private static final String SELECT_ALL_ARCHIVOSTAREAS = "select distinct * from archivotarea";
	
	
	private static final String SELECT_ALL_ARCHIVOSCALIFICA = "select distinct * from archivocalifica";
	
	
	
	
	private static final String SELECT_ALL_TEMAS = "SELECT DISTINCT tema FROM `temas` order by tema";
	
	
	private static final String SELECT_ALL_AlUMNOS = "select distinct * from alumnos order by name";
	
	
	private static final String SELECT_ALL_CLASES = "select distinct * from clases";
	
	
	
	private static final String INSERT_USERS_CALIFICACION = "INSERT INTO calificacion" + "  (titulo,descripcion,archivo,nivel,materia,name,tema,nota,fechade,hora) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	
	
	
	private static final String SELECT_ALL_CALIFICACIONES = "select distinct * from calificacion";
	
	private static final String UPDATE_USERS_CALIFICACION = "update calificacion set nota = ?, fechade = ?, hora = ? where id = ?;";
	
	private static final String SELECT_USER_BY_ID_CALIFICACION = "select id,titulo,descripcion,archivo,nivel,materia,name,tema,nota,fechade,hora from calificacion where id = ?";
	
	private static final String DELETE_USERS_CALIFICACION = "delete from calificacion where id = ?;";
	

	public TareaDAO() {
	}

	protected Connection getConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conec = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conec;
	}

	public void insertUser(Tarea tarea) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, tarea.getTitulo());
			preparedStatement.setString(2, tarea.getDescripcion());
			preparedStatement.setString(3, tarea.getArchivo());
			preparedStatement.setString(4, tarea.getNivel());
			preparedStatement.setString(5, tarea.getMateria());
			preparedStatement.setString(6, tarea.getName());
			preparedStatement.setString(7, tarea.getTema());
			preparedStatement.setInt(8, tarea.getNota());
			preparedStatement.setString(9, tarea.getFechade());
			preparedStatement.setString(10, tarea.getHora());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		
	}
	
	
	
	
	
	public void insertUserCalificacion(Calificaciones calificacion) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_CALIFICACION)) {
			preparedStatement.setString(1, calificacion.getTitulo());
			preparedStatement.setString(2, calificacion.getDescripcion());
			preparedStatement.setString(3, calificacion.getArchivo());
			preparedStatement.setString(4, calificacion.getNivel());
			preparedStatement.setString(5, calificacion.getMateria());
			preparedStatement.setString(6, calificacion.getName());
			preparedStatement.setString(7, calificacion.getTema());
			preparedStatement.setInt(8, 0);
			preparedStatement.setString(9, calificacion.getFechade());
			preparedStatement.setString(10, calificacion.getHora());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		
	}
	
	
	
	
	
	
	

	

	
	public Tarea selectUsers(int id) {
		Tarea tareas = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");
				String archivo = rs.getString("archivo");
				String nivel = rs.getString("nivel");
				String materia = rs.getString("materia");
				String name = rs.getString("name");
				String tema = rs.getString("tema");
				int nota = rs.getInt("nota");
				String fechade = rs.getString("fechade");
				String hora = rs.getString("hora");
				tareas = new Tarea(id, titulo, descripcion,archivo,nivel, materia, name,tema, nota, fechade,hora);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return tareas;
	}
	
	
	public Calificaciones selectUsersCalificacion(int id) {
		Calificaciones calificacion = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID_CALIFICACION);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");
				String archivo = rs.getString("archivo");
				String nivel = rs.getString("nivel");
				String materia = rs.getString("materia");
				String name = rs.getString("name");
				String tema = rs.getString("tema");
				int nota = rs.getInt("nota");
				String fechade = rs.getString("fechade");
				String hora = rs.getString("hora");
				calificacion = new Calificaciones(id, titulo, descripcion,archivo,nivel, materia, name,tema, nota, fechade,hora);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return calificacion;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Tarea> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Tarea> tareas = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");
				String archivo = rs.getString("archivo");
				String nivel = rs.getString("nivel");
				String materia = rs.getString("materia");
				String name = rs.getString("name");
				String tema = rs.getString("tema");
				int nota = rs.getInt("nota");
				String fechade = rs.getString("fechade");
				String hora = rs.getString("hora");
				tareas.add(new Tarea(id, titulo, descripcion, archivo, nivel, materia, name,tema, nota,fechade,hora));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return tareas;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Tarea> selectAllUsersta(String name) {

		String SELECT_ALL_USERS_TA = "select * from tarea where name = "
				+ "'"
				+name
				+ "'";
		
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Tarea> tareas = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS_TA);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");
				String archivo = rs.getString("archivo");
				String nivel = rs.getString("nivel");
				String materia = rs.getString("materia");
				
				String tema = rs.getString("tema");
				int nota = rs.getInt("nota");
				String fechade = rs.getString("fechade");
				String hora = rs.getString("hora");
				tareas.add(new Tarea(id, titulo, descripcion, archivo, nivel, materia, name,tema, nota,fechade,hora));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return tareas;
	}
	
	
	
	
	
	
	
	
	
	
	
	public List<Calificaciones> selectAllUsersCalificacion() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Calificaciones> calificacion = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CALIFICACIONES);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");
				String archivo = rs.getString("archivo");
				String nivel = rs.getString("nivel");
				String materia = rs.getString("materia");
				String name = rs.getString("name");
				String tema = rs.getString("tema");
				int nota = rs.getInt("nota");
				String fechade = rs.getString("fechade");
				String hora = rs.getString("hora");
				calificacion.add(new Calificaciones(id, titulo, descripcion, archivo, nivel, materia, name,tema, nota,fechade,hora));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return calificacion;
	}
	
	
	
	
	

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public boolean deleteUserCalificacion(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_CALIFICACION);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	
	
	
	
	
	

	public boolean updateUser(Tarea tareas) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, tareas.getTitulo());
			statement.setString(2, tareas.getDescripcion());
			statement.setString(3, tareas.getArchivo());
			statement.setString(4, tareas.getNivel());
			statement.setString(5, tareas.getMateria());
			statement.setString(6, tareas.getName());
			statement.setString(7, tareas.getTema());
			statement.setInt(8, tareas.getNota());
			statement.setString(9, tareas.getFechade());
			statement.setString(10, tareas.getHora());
			statement.setInt(11, tareas.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	
	
	
	
	
	public boolean updateUserCalificacion(Calificaciones calificacion) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_CALIFICACION);) {
			
			statement.setInt(1, calificacion.getNota());
			statement.setString(2, calificacion.getFechade());
			statement.setString(3, calificacion.getHora());
			statement.setInt(4, calificacion.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
	
	public boolean updateUserCalificacionta(Calificaciones calificacion) throws SQLException {
		boolean rowUpdated;
		String UPDATE_USERS_CALIFICACION_TA = "update calificacion set archivo = ? where id = ?;";
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_CALIFICACION_TA);) {
			
			
			statement.setString(1, calificacion.getArchivo());
			statement.setInt(2, calificacion.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
	
	
	
	
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
	
	
	
	
	
	
	public List<Tarea> selectAllMaterial() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Tarea> tareas = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");
				String descripcion = rs.getString("descripcion");
				String archivo = rs.getString("archivo");
				String nivel = rs.getString("nivel");
				String materia = rs.getString("materia");
				String name = rs.getString("name");
				String tema = rs.getString("tema");
				int nota = rs.getInt("nota");
				String fechade = rs.getString("fechade");
				String hora = rs.getString("hora");
				tareas.add(new Tarea(id, titulo, descripcion, archivo, nivel, materia, name,tema, nota, fechade,hora));
				
				
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return tareas;
	}
	
	
	public List<Temas> selectAllTemas() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Temas> tema = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TEMAS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				
				String temai = rs.getString("tema");
				tema.add(new Temas(temai));
				
				
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return tema;
	}
	
	
	public List<Alumnos> selectAllAlumnos() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Alumnos> alumno = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AlUMNOS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String apellido = rs.getString("apellido");
				int dni = rs.getInt("dni");
				String email = rs.getString("email");
				String direccion = rs.getString("direccion");
				String password = rs.getString("password");
				String sexo = rs.getString("sexo");
				String fechadn = rs.getString("fechadn");
				int telefono = rs.getInt("telefono");
				alumno.add(new Alumnos(id, name, apellido, dni, email, direccion,password,sexo,fechadn,telefono));
				
				
				
				
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return alumno;
	}
	
	
	
	
	public List<Clases> selectAllClasesC() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Clases> clases = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLASES);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String clase = rs.getString("clase");
				String seccion = rs.getString("seccion");
				String materia = rs.getString("materia");
				String aula = rs.getString("aula");
				clases.add(new Clases(id, clase, seccion, materia, aula));
				
				
				
				
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return clases;
	}
	
	
	
	
	
	public List<ArchivosTareas> selectAllArchivosTareas() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<ArchivosTareas> archivostarea = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ARCHIVOSTAREAS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String ruta = rs.getString("ruta");
				archivostarea.add(new ArchivosTareas(id, nombre,ruta));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return archivostarea;
	}
	
	
	
	
	public List<ArchivoCalifica> selectAllArchivoCalifica() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<ArchivoCalifica> archivocalifica = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ARCHIVOSCALIFICA);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String ruta = rs.getString("ruta");
				archivocalifica.add(new ArchivoCalifica(id, nombre,ruta));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return archivocalifica;
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	

}