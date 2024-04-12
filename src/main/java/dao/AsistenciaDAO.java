package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import entidad.Alumnos;
import entidad.Asistencias;
import entidad.Clases;
import entidad.Materiales;

import java.sql.*;


import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


import java.time.LocalDate;
import java.sql.Time;
import java.util.Calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Ramesh Fadatare
 *
 */
public class AsistenciaDAO {
	
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bd_sistema?useUnicode=yes&characterEncoding=UTF-8";
	private String jdbcUsername = "root";
	private String jdbcPassword = "9$8753JK5";

	
	private static final String SELECT_USER_BY_ID = "select id, nombre, apellido, materia, clase,seccion,tipoasistencia,fechade,hora from asistencia where id =?";

	private static final String SELECT_ALL_AlUMNOS = "select * from alumnos order by name";
	
	private static final String SELECT_ALL_USERS = "select * from asistencia";
	
	private static final String SELECT_ALL_CLASES = "select * from clases";
	
	
	private static final String UPDATE_USERS_SQL = "update asistencia set tipoasistencia = ?, fechade = ?, hora = ? where id = ?;";
	
	private static final String DELETE_USERS_SQL = "delete from asistencia where id = ?;";
	
	

	public AsistenciaDAO() {
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
	
	
	
	
	public LocalDate obtenerFechaActual() {
        return LocalDate.now();
    }
	
	
	
	

	public void insertUser(int dni, String tipoasistencia, String clase, String materia) throws SQLException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = dateFormat.format(new Date());
		
		
		
		Calendar cal = Calendar.getInstance();
		Time horaActual = new Time(cal.getTimeInMillis());
		
	
		
		
		String INSERT_USERS_SQL = "INSERT INTO asistencia (nombre, apellido, materia, clase,seccion,tipoasistencia,fechade,hora)"
				+ "SELECT a.name, a.apellido, c.materia,c.clase,c.seccion ,'"+tipoasistencia
				+ "', "
				+ "'"+fechaActual+"'"
				+ ", "
				+ "'"+horaActual+"'"
				+ " "
				
				
				+ "FROM clases c, alumnos a, tarea t " 
				+ "WHERE a.dni = " + dni
				+ " AND c.clase = '"+clase+"'"
				
				+ " AND c.materia = '"+materia+"'"+ 
				
				";";
				
				
				
				
		
		
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			
			
			
			
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			
			
			preparedStatement.close();
			
			connection.close();
			
			
			
		} catch (SQLException e) {
			printSQLException(e);
		}
			
		
	}

	
	
	public boolean updateUser(Asistencias asistencia) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, asistencia.getTipoasistencia());
			statement.setString(2, asistencia.getFechade());
			statement.setString(3, asistencia.getHora());
			statement.setInt(4, asistencia.getId());

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
				alumno.add(new Alumnos(id, name, apellido, dni,email, direccion,password,sexo,fechadn,telefono));
				
				
				
				
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return alumno;
	}
	
	
	
	public List<Asistencias> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Asistencias> asistencias = new ArrayList<>();
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
				String apellido = rs.getString("apellido");
				String clase = rs.getString("clase");
				String materia = rs.getString("materia");
				String seccion = rs.getString("seccion");
				String tipoasistencia = rs.getString("tipoasistencia");
				String fechade = rs.getString("fechade");
				String hora = rs.getString("hora");
				
				asistencias.add(new Asistencias(id, nombre,apellido,clase,materia,seccion,tipoasistencia,fechade,hora));
				
				
				
				 
				
				
				
			}
			
			
			
			
			
			 
			
			
			
			
			
		} catch (SQLException e) {
			printSQLException(e);
		}
		return asistencias;
	}
	
	
	
	
	
	
	
	
	public List<Clases> selectAllUsersClases() {

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
	
	
	
	
	
	public Asistencias selectUser(int id) {
		Asistencias asistencias = null;
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
				String apellido = rs.getString("apellido");
				String clase = rs.getString("clase");
				String materia = rs.getString("materia");
				String seccion = rs.getString("seccion");
				String tipoasistencia = rs.getString("tipoasistencia");
				String fechade = rs.getString("fechade");
				String hora = rs.getString("hora");
				
				asistencias= new Asistencias(id, nombre,apellido,clase,materia,seccion,tipoasistencia,fechade,hora);
				
				
				
				
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return asistencias;
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
	
	
	
	
	
	
	
	
	

}