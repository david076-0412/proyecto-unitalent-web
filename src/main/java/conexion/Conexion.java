package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;


public class Conexion {

    private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bd_sistema?useUnicode=yes&characterEncoding=UTF-8";
    private static final String USUARIO = "root";
    private static final String CLAVE = "9$8753JK5";

    protected Connection conn = null;
    
    static {
        try {
            Class.forName(CONTROLADOR);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();
        }
    }
    
    
    public static Connection getConexion() {
        Connection conexion = null;
        
        try {
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("Conexión OK");

        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }
        
        return conexion;
    }
    
    
    
    public Conexion() {
    	try {
    		Class.forName(CONTROLADOR);
    		conn = DriverManager.getConnection(URL, USUARIO, CLAVE);
    		if (conn !=null) {
    			System.out.println("Conexion OK" + conn);
    		}
    	}catch (SQLException ex) {
    		
    		System.out.println("Error de SQL"+ex.getMessage());
    		
    	} catch (ClassNotFoundException e) {
    		System.out.println("Falta Driver"+e.getMessage());
		}
    }
    
    
    
    public Connection conectar() {
    	return conn;
    }
    
    
    public void desconectar() {
    	try {
    		System.out.println("Cerrando la BD"+conn);
    		conn.close();
    	} catch(SQLException ex) {
    		System.out.println("Error de SQL"+ ex.getMessage());
    	}
    }
    
    
    
    
    public static void close(Connection cnn) {
        try{
            if(cnn != null)
                cnn.close();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public static void close(Statement stm) {
        try{
            if(stm != null)
                stm.close();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
   
    
    
    
    public static void close(ResultSet rs) {
        try{
            if(rs != null)
                rs.close();
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    
    
    
    
    
    
}
