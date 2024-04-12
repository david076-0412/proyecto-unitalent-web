package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Clases;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class ClaseDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/bd_sistema?useUnicode=yes&characterEncoding=UTF-8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "9$8753JK5";

	
	private static final String INSERT_USERS_SQL = "INSERT INTO clases" + "  (clase, seccion, materia, aula) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,clase, seccion, materia, aula from clases where id =?";
	private static final String SELECT_ALL_USERS = "select * from clases";
	private static final String DELETE_USERS_SQL = "delete from clases where id = ?;";
	private static final String UPDATE_USERS_SQL = "update clases set clase = ?, seccion = ?, materia= ?, aula =? where id = ?;";
	
	

	public ClaseDAO() {
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

	public void insertUser(Clases clases) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, clases.getClase());
			preparedStatement.setString(2, clases.getSeccion());
			preparedStatement.setString(3, clases.getMateria());
			preparedStatement.setString(4, clases.getAula());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
			
		
	}

	

	public List<Clases> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Clases> clases = new ArrayList<>();
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
	
	
	
	
	public Clases selectUser(int id) {
		Clases clases = null;
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
				String clase = rs.getString("clase");
				String seccion = rs.getString("seccion");
				String materia = rs.getString("materia");
				String aula = rs.getString("aula");
				clases = new Clases(id, clase, seccion, materia, aula);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return clases;
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
	
	
	
	

	public boolean updateUser(Clases clases) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, clases.getClase());
			statement.setString(2, clases.getSeccion());
			statement.setString(3, clases.getMateria());
			statement.setString(4, clases.getAula());
			statement.setInt(5, clases.getId());

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
