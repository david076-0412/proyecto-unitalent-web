package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Admin;
import entidad.Clases;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class AdminDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/bd_sistema?useUnicode=yes&characterEncoding=UTF-8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "9$8753JK5";

	private static final String INSERT_USERS_SQL = "INSERT INTO admin" + "  (correo,clave) VALUES "
			+ " (?, ?);";

	private static final String SELECT_USER_BY_ID = "select id, usuario, correo, clave, nombre, apellido, telefono from admin where id = ?";
	private static final String SELECT_USER_BY_NAME = "select id, usuario, correo, clave, nombre, apellido, telefono from admin where nombre = ? and apellido = ?";
	private static final String SELECT_ALL_USERS = "select * from admin";
	private static final String DELETE_USERS_SQL = "delete from admin where id = ?;";
	private static final String UPDATE_USERS_SQL = "update admin set usuario = ?, correo= ?, clave = ?, nombre = ?, apellido = ?, telefono = ?  where id = ?;";
	
	
	

	public AdminDAO() {
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

	public void insertUser(Admin admin) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, admin.getCorreo());
			preparedStatement.setString(2, admin.getClave());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		
		
		
		
		
		
	}

	public List<Admin> selectUser(String nombre, String apellido) {
		List<Admin> admin = new ArrayList<>();
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_NAME);) {
			preparedStatement.setString(1, nombre);
			preparedStatement.setString(2, apellido);
			
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String usuario = rs.getString("usuario");
				
				
				String correo = rs.getString("correo");
				
				String clave = rs.getString("clave");
				
				
				String telefono = rs.getString("telefono");
				admin.add(new Admin(id, usuario, correo, clave,nombre, apellido, telefono));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return admin;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	public Admin selectUsers(int id) {
		Admin docentes = null;
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
				String usuario = rs.getString("usuario");
				String correo = rs.getString("correo");
				String clave = rs.getString("clave");
				String nombre=rs.getString("nombre");
				String apellido=rs.getString("apellido");
				String telefono = rs.getString("telefono");
				docentes = new Admin(id, usuario, correo, clave,nombre, apellido, telefono);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return docentes;
	}
	
	public List<Admin> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Admin> docentes = new ArrayList<>();
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
				String usuario = rs.getString("usuario");
				String correo = rs.getString("correo");
				String clave = rs.getString("clave");
				String nombre=rs.getString("nombre");
				String apellido=rs.getString("apellido");
				String telefono = rs.getString("telefono");
				
				docentes.add(new Admin(id, usuario, correo, clave,nombre, apellido, telefono));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return docentes;
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

	public boolean updateUser(Admin docente) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, docente.getUsuario());
			statement.setString(2, docente.getCorreo());
			statement.setString(3, docente.getClave());
			statement.setString(4, docente.getNombre());
			statement.setString(5, docente.getApellido());
			statement.setString(6, docente.getTelefono());
			statement.setInt(7, docente.getId());
			
			
			
			

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
	public boolean updateUserPerfil(Admin docente) throws SQLException {
		boolean rowUpdated;
		
		String UPDATE_USERS_SQL_PERFIL = "update admin set usuario = ?, correo= ?, clave = ?, nombre = ?, apellido = ?, telefono = ?  where id = ?;";
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL_PERFIL);) {
			statement.setString(1, docente.getUsuario());
			statement.setString(2, docente.getCorreo());
			statement.setString(3, docente.getClave());
			statement.setString(4, docente.getNombre());
			statement.setString(5, docente.getApellido());
			statement.setString(6, docente.getTelefono());
			statement.setInt(7, docente.getId());

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
	
	
	
	
	
	
	

}
