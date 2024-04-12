package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entidad.Tarea;
import entidad.ArchivosTareas;


/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class ArchivoTareaDAO {
	
	
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bd_sistema?useUnicode=yes&characterEncoding=UTF-8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "9$8753JK5";

	
	
	
	private static final String INSERT_USERS_SQL = "INSERT INTO archivotarea" + "  (nombre,ruta) VALUES "
			+ " (?,?);";
	

	private static final String SELECT_ALL_USERS = "select distinct * from archivotarea";
	
	
	
	private static final String SELECT_USER_BY_ID = "select distinct * from archivotarea where id = ?";
	
	
	
	
	private static final String DELETE_USERS_SQL = "delete from archivotarea where  nombre= ?;";
	
	
	
	
	
	
	

	public ArchivoTareaDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	
	
	
	
	
	
	public void insertUser(ArchivosTareas archivotarea){
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, archivotarea.getNombre());
			preparedStatement.setString(2, archivotarea.getRuta());
		
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		
	}
	
	
	
	
	

	
	public ArchivosTareas selectUsers(int id) {
		ArchivosTareas archivostarea = null;
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
				String nombre = rs.getString("nombre");
				String ruta = rs.getString("ruta");
				
				
				archivostarea = new ArchivosTareas(id, nombre,ruta);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return archivostarea;
	}
	
	
	
	
	public List<ArchivosTareas> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<ArchivosTareas> archivostarea = new ArrayList<>();
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
				String nombre = rs.getString("nombre");
				String ruta = rs.getString("ruta");
				archivostarea.add(new ArchivosTareas(id, nombre,ruta));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return archivostarea;
	}
	
	
	
	
	
	
	public void deleteUser(String id) throws SQLException {
		System.out.println(DELETE_USERS_SQL);
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setString(1, id);
			statement.executeUpdate();
		}
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}