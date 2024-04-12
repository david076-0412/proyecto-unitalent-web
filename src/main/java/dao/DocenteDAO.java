package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Docentes;
import entidad.Clases;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class DocenteDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/bd_sistema?useUnicode=yes&characterEncoding=UTF-8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "9$8753JK5";

	private static final String INSERT_USERS_SQL = "INSERT INTO docentes" + "  (correo,clave) VALUES "
			+ " (?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,usuario, nombre,apellido,dni, correo,direccion,clave,sexo,fechadn,telefono,perfil from docentes where id = ?";
	private static final String SELECT_USER_BY_NAME = "select id,usuario, nombre,apellido,dni,correo,direccion,clave,sexo,fechadn,telefono,perfil from docentes where nombre = ? and apellido = ?";
	private static final String SELECT_ALL_USERS = "select * from docentes";
	private static final String DELETE_USERS_SQL = "delete from docentes where id = ?;";
	private static final String UPDATE_USERS_SQL = "update docentes set usuario = ?, nombre = ?, apellido = ?, dni=?, correo= ?, direccion =? , clave=?, sexo = ?, fechadn = ?, telefono = ?  where id = ?;";
	
	
	

	public DocenteDAO() {
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

	public void insertUser(Docentes docente) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, docente.getCorreo());
			preparedStatement.setString(2, docente.getClave());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		
		
		
		
		
		
	}

	public List<Docentes> selectUser(String nombre, String apellido) {
		List<Docentes> docentes = new ArrayList<>();
		
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
				
				int dni = rs.getInt("dni");
				String email = rs.getString("email");
				String direccion = rs.getString("direccion");
				String password = rs.getString("password");
				String sexo = rs.getString("sexo");
				String fechadn = rs.getString("fechadn");
				int telefono = rs.getInt("telefono");
				docentes.add(new Docentes(id, usuario, nombre, apellido, dni, email, direccion,password,sexo,fechadn,telefono));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return docentes;
	}
	
	
	
	
	public List<Docentes> selectUserBuscar(String idt, String ap) {
		
		String SELECT_USER_BY_NAME_APELLIDO = "select id,usuario, nombre,apellido,dni,correo,direccion,clave,sexo,fechadn,telefono from docentes where nombre = ? or apellido = ?";
		
		List<Docentes> docentes = new ArrayList<>();
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_NAME_APELLIDO);) {
			preparedStatement.setString(1, idt);
			preparedStatement.setString(2, ap);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String usuario = rs.getString("usuario");
				String correo = rs.getString("correo");
				String clave = rs.getString("clave");
				int dni = rs.getInt("dni");
				String direccion = rs.getString("direccion");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String sexo = rs.getString("sexo");
				String fechadn = rs.getString("fechadn");
				int telefono = rs.getInt("telefono");
				docentes.add(new Docentes(id, usuario, correo, clave, dni, direccion, nombre,apellido,sexo,fechadn,telefono));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return docentes;
	}
	
	
	
	public Docentes selectUsersdo(int id) {
		
		String SELECT_USER_BY_ID_DO = "select id,usuario, nombre,apellido,dni, correo,direccion,clave,sexo,fechadn,telefono from docentes where id = ?";
		Docentes docentes = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID_DO);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String usuario = rs.getString("usuario");
				String correo = rs.getString("correo");
				String clave = rs.getString("clave");
				int dni = rs.getInt("dni");
				String direccion = rs.getString("direccion");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String sexo = rs.getString("sexo");
				String fechadn = rs.getString("fechadn");
				int telefono = rs.getInt("telefono");
				docentes = new Docentes(id, usuario, correo, clave, dni, direccion, nombre,apellido,sexo,fechadn,telefono);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return docentes;
	}
	
	
	
	
	
	
	

	
	public Docentes selectUsers(int id) {
		Docentes docentes = null;
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
				int dni = rs.getInt("dni");
				String direccion = rs.getString("direccion");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String sexo = rs.getString("sexo");
				String fechadn = rs.getString("fechadn");
				int telefono = rs.getInt("telefono");
				String perfil = rs.getString("perfil");
				docentes = new Docentes(id, usuario, correo, clave, dni, direccion, nombre,apellido,sexo,fechadn,telefono,perfil);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return docentes;
	}
	
	public List<Docentes> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Docentes> docentes = new ArrayList<>();
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
				int dni = rs.getInt("dni");
				String direccion = rs.getString("direccion");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String sexo = rs.getString("sexo");
				String fechadn = rs.getString("fechadn");
				int telefono = rs.getInt("telefono");
				
				docentes.add(new Docentes(id, usuario, correo, clave, dni, direccion, nombre,apellido,sexo,fechadn,telefono));
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

	public boolean updateUser(Docentes docente) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, docente.getUsuario());
			statement.setString(2, docente.getCorreo());
			statement.setString(3, docente.getClave());
			statement.setInt(4, docente.getDni());
			statement.setString(5, docente.getDireccion());
			statement.setString(6, docente.getNombre());
			statement.setString(7, docente.getApellido());
			statement.setString(8, docente.getSexo());
			statement.setString(9, docente.getFechadn());
			statement.setInt(10, docente.getTelefono());
			statement.setInt(11, docente.getId());
			
			
			
			

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
	public boolean updateUserPerfil(Docentes docente) throws SQLException {
		boolean rowUpdated;
		
		String UPDATE_USERS_SQL_PERFIL = "update docentes set usuario = ?, correo = ?, clave = ?, dni = ?, direccion = ?, nombre = ?, apellido = ?, sexo = ?, fechadn = ?, telefono = ?, perfil = ? where id = ?;";
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL_PERFIL);) {
			statement.setString(1, docente.getUsuario());
			statement.setString(2, docente.getCorreo());
			statement.setString(3, docente.getClave());
			statement.setInt(4, docente.getDni());
			statement.setString(5, docente.getDireccion());
			statement.setString(6, docente.getNombre());
			statement.setString(7, docente.getApellido());
			statement.setString(8, docente.getSexo());
			statement.setString(9, docente.getFechadn());
			statement.setInt(10, docente.getTelefono());
			statement.setString(11, docente.getPerfil());
			statement.setInt(12, docente.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
	
	
	
	
	public boolean updateUserDo(Docentes docente) throws SQLException {
		boolean rowUpdated;
		
		String UPDATE_USERS_SQL_PERFIL = "update docentes set usuario = ?, correo = ?, clave = ?, dni = ?, direccion = ?, nombre = ?, apellido = ?, sexo = ?, fechadn = ?, telefono = ? where id = ?;";
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL_PERFIL);) {
			statement.setString(1, docente.getUsuario());
			statement.setString(2, docente.getCorreo());
			statement.setString(3, docente.getClave());
			statement.setInt(4, docente.getDni());
			statement.setString(5, docente.getDireccion());
			statement.setString(6, docente.getNombre());
			statement.setString(7, docente.getApellido());
			statement.setString(8, docente.getSexo());
			statement.setString(9, docente.getFechadn());
			statement.setInt(10, docente.getTelefono());
			statement.setInt(11, docente.getId());

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

