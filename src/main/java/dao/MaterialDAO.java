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
import entidad.Clases;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class MaterialDAO {
	
	
	public static PreparedStatement press=null;
	public static Connection conec=null;
	public static Statement st = null;
	public static ResultSet rt = null;
	
	
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bd_sistema?useUnicode=yes&characterEncoding=UTF-8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "9$8753JK5";

	private static final String INSERT_USERS_SQL = "INSERT INTO material" + "  (titulo,descripcion,archivo,nivel,materia,name,tema) VALUES "
			+ " (?, ?, ?, ?, ?, ?,?);";

	
	
	
	private static final String SELECT_USER_BY_ID = "select id,titulo,descripcion,archivo,nivel,materia, name,tema from material where id = ?";
	
	private static final String SELECT_ALL_USERS = "select * from material";
	private static final String DELETE_USERS_SQL = "delete from material where id = ?;";
	private static final String UPDATE_USERS_SQL = "update material set titulo = ?,descripcion = ?, archivo = ?, nivel= ?, materia = ?, name =? , tema=? where id = ?;";
	
	private static final String SELECT_ALL = "select t.id, m.titulo, m.descripcion, m.nivel, m.materia, a.name, t.tema from material m, temas t, alumnos a";
	
	
	
	private static final String SELECT_ALL_ARCHIVOSMATERIAL = "select * from archivomaterial";
	
	
	private static final String SELECT_ALL_TEMAS = "SELECT DISTINCT tema FROM `temas` order by tema";
	
	
	private static final String SELECT_ALL_AlUMNOS = "select distinct * from alumnos order by name";
	
	
	private static final String SELECT_ALL_CLASES = "select distinct * from clases";
	
	
	
	
	private static final String SELECT_SUMATERIAL_BY_ID = "select ar.nombre from archivomaterial ar, material m WHERE m.archivo= Banner_Canal.png";
	
	
	
	
	
	
	
	

	public MaterialDAO() {
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

	public void insertUser(Materiales material) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		
		int j=0;
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, material.getTitulo());
			preparedStatement.setString(2, material.getDescripcion());
			preparedStatement.setString(3, material.getArchivo());
			preparedStatement.setString(4, material.getNivel());
			preparedStatement.setString(5, material.getMateria());
			preparedStatement.setString(6, material.getName());
			preparedStatement.setString(7, material.getTema());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			printSQLException(e);
		}finally {
			Conexion conexion = new Conexion();
			conexion.desconectar();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	
	public Materiales selectUsers(int id) {
		Materiales materiales = null;
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
				materiales = new Materiales(id, titulo, descripcion,archivo,nivel,materia, name,tema);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return materiales;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Materiales> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Materiales> materiales = new ArrayList<>();
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
				materiales.add(new Materiales(id, titulo, descripcion, archivo, nivel, materia, name,tema));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return materiales;
	}
	
	
	public List<Materiales> selectAllUserslm(String name) {
		
		String SELECT_ALL_CURSOS = "select * from material where name = '"
				
				+ name
				
				+ "'";

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Materiales> materiales = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CURSOS);) {
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
				materiales.add(new Materiales(id, titulo, descripcion, archivo, nivel, materia, name,tema));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return materiales;
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

	public boolean updateUser(Materiales materiales) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, materiales.getTitulo());
			statement.setString(2, materiales.getDescripcion());
			statement.setString(3, materiales.getArchivo());
			statement.setString(4, materiales.getNivel());
			statement.setString(5, materiales.getMateria());
			statement.setString(6, materiales.getName());
			statement.setString(7, materiales.getTema());
			statement.setInt(8, materiales.getId());

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
	
	
	
	
	
	
	
	public List<Materiales> selectAllMaterial() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Materiales> material = new ArrayList<>();
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
				material.add(new Materiales(id, titulo, descripcion, archivo, nivel, materia, name,tema));
				
				
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return material;
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
	
	
	
	
	
	
	public List<ArchivosMateriales> selectAllArchivosMaterial() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<ArchivosMateriales> archivosmateriales = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ARCHIVOSMATERIAL);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String ruta = rs.getString("ruta");
				archivosmateriales.add(new ArchivosMateriales(id, nombre,ruta));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return archivosmateriales;
	}
	
	
	
	
	
	public ArchivosMateriales selectArchivosMaterial(int id) {
		ArchivosMateriales archivosmateriales = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SUMATERIAL_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				String ruta = rs.getString("ruta");
				archivosmateriales = new ArchivosMateriales(id, nombre,ruta);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return archivosmateriales;
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	

}

