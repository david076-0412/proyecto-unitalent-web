package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Alumnos;
import entidad.Clases;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class UserDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/bd_sistema?useUnicode=yes&characterEncoding=UTF-8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "9$8753JK5";

	private static final String INSERT_USERS_SQL = "INSERT INTO alumnos" + "  (name, apellido, dni, email, direccion,password,sexo,fechadn,telefono) VALUES "
			+ " (?, ?, ?, ?, ?, ?,?,?,?);";

	private static final String SELECT_USER_BY_ID = "select id,name,apellido,dni, email,direccion,password,sexo,fechadn,telefono,perfil from alumnos where id = ?";
	private static final String SELECT_USER_BY_NAME = "select id,name,apellido,dni,email,direccion,password,sexo,fechadn,telefono,perfil from alumnos where name = ?";
	private static final String SELECT_ALL_USERS = "select * from alumnos";
	private static final String DELETE_USERS_SQL = "delete from alumnos where id = ?;";
	private static final String UPDATE_USERS_SQL = "update alumnos set name = ?, apellido = ?, dni=?, email= ?, direccion =? , password=?, sexo = ?, fechadn = ?, telefono = ?  where id = ?;";
	
	
	

	public UserDAO() {
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

	public void insertUser(Alumnos alumno) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, alumno.getName());
			preparedStatement.setString(2, alumno.getApellido());
			preparedStatement.setInt(3, alumno.getDni());
			preparedStatement.setString(4, alumno.getEmail());
			preparedStatement.setString(5, alumno.getDireccion());
			preparedStatement.setString(6, alumno.getPassword());
			preparedStatement.setString(7, alumno.getSexo());
			preparedStatement.setString(8, alumno.getFechadn());
			preparedStatement.setInt(9, alumno.getTelefono());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		
		
		
		
		
		
	}

	public List<Alumnos> selectUser(String idt) {
		List<Alumnos> alumnos = new ArrayList<>();
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_NAME);) {
			preparedStatement.setString(1, idt);
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
				alumnos.add(new Alumnos(id, name, apellido, dni, email, direccion,password,sexo,fechadn,telefono));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return alumnos;
	}
	
	
	
	
	public List<Alumnos> selectUserBuscar(String idt, String ap) {
		
		String SELECT_USER_BY_NAME_APELLIDO = "select id,name,apellido,dni,email,direccion,password,sexo,fechadn,telefono from alumnos where name = ? or apellido = ?";
		
		List<Alumnos> alumnos = new ArrayList<>();
		
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
				String name = rs.getString("name");
				String apellido = rs.getString("apellido");
				int dni = rs.getInt("dni");
				String email = rs.getString("email");
				String direccion = rs.getString("direccion");
				String password = rs.getString("password");
				String sexo = rs.getString("sexo");
				String fechadn = rs.getString("fechadn");
				int telefono = rs.getInt("telefono");
				alumnos.add(new Alumnos(id, name, apellido, dni, email, direccion,password,sexo,fechadn,telefono));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return alumnos;
	}
	
	
	
	public Alumnos selectUseral(int id) {
		String SELECT_USER_BY_ID_AL = "select id,name,apellido,dni, email,direccion,password,sexo, fechadn, telefono from alumnos where id = ?";
		
		Alumnos alumnos = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID_AL);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String apellido = rs.getString("apellido");
				int dni = rs.getInt("dni");
				String email = rs.getString("email");
				String direccion = rs.getString("direccion");
				String password = rs.getString("password");
				String sexo =rs.getString("sexo");
				String fechadn = rs.getString("fechadn");
				int telefono = rs.getInt("telefono");
				alumnos = new Alumnos(id, name, apellido, dni, email, direccion,password,sexo,fechadn,telefono);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return alumnos;
	}
	
	
	
	
	
	
	

	
	public Alumnos selectUsers(int id) {
		Alumnos alumnos = null;
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
				String name = rs.getString("name");
				String apellido = rs.getString("apellido");
				int dni = rs.getInt("dni");
				String email = rs.getString("email");
				String direccion = rs.getString("direccion");
				String password = rs.getString("password");
				String sexo =rs.getString("sexo");
				String fechadn = rs.getString("fechadn");
				int telefono = rs.getInt("telefono");
				String perfil = rs.getString("perfil");
				alumnos = new Alumnos(id, name, apellido, dni, email, direccion,password,sexo,fechadn,telefono,perfil);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return alumnos;
	}
	
	public List<Alumnos> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Alumnos> alumnos = new ArrayList<>();
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
				String name = rs.getString("name");
				String apellido = rs.getString("apellido");
				int dni = rs.getInt("dni");
				String email = rs.getString("email");
				String direccion = rs.getString("direccion");
				String password = rs.getString("password");
				String sexo = rs.getString("sexo");
				String fechadn = rs.getString("fechadn");
				int telefono = rs.getInt("telefono");
				alumnos.add(new Alumnos(id, name, apellido, dni, email, direccion,password,sexo,fechadn,telefono));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return alumnos;
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

	public boolean updateUser(Alumnos alumno) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, alumno.getName());
			statement.setString(2, alumno.getApellido());
			statement.setInt(3, alumno.getDni());
			statement.setString(4, alumno.getEmail());
			statement.setString(5, alumno.getDireccion());
			statement.setString(6, alumno.getPassword());
			statement.setString(7, alumno.getSexo());
			statement.setString(8, alumno.getFechadn());
			statement.setInt(9, alumno.getTelefono());
			statement.setInt(10, alumno.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	
	public boolean updateUserPerfil(Alumnos alumno) throws SQLException {
		boolean rowUpdated;
		
		String UPDATE_USERS_SQL_PERFIL = "update alumnos set name = ?, apellido = ?, dni=?, email= ?, direccion =? , password=?, sexo = ?, fechadn = ?, telefono = ?, perfil=?  where id = ?;";
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL_PERFIL);) {
			statement.setString(1, alumno.getName());
			statement.setString(2, alumno.getApellido());
			statement.setInt(3, alumno.getDni());
			statement.setString(4, alumno.getEmail());
			statement.setString(5, alumno.getDireccion());
			statement.setString(6, alumno.getPassword());
			statement.setString(7, alumno.getSexo());
			statement.setString(8, alumno.getFechadn());
			statement.setInt(9, alumno.getTelefono());
			statement.setString(10, alumno.getPerfil());
			statement.setInt(11, alumno.getId());

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

