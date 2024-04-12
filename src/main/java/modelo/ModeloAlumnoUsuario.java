package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexion.Conexion;
import entidad.Alumnos;

public class ModeloAlumnoUsuario {	
	public Alumnos iniciarSesion(String correo, String clave) {
		Alumnos alumnos = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = Conexion.getConexion();
			String sql = "SELECT C.id, C.name, C.apellido, C.email, C.password, C.dni, C.sexo, C.fechadn, C.telefono, C.direccion, C.perfil FROM alumnos C WHERE C.email = ? AND C.password = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, correo);
			pstm.setString(2, clave);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				alumnos = new Alumnos();
				alumnos.setId(rs.getInt("id"));
				alumnos.setEmail(rs.getString("email"));
				alumnos.setPassword(rs.getString("password"));
				alumnos.setDni(rs.getInt("dni"));
				alumnos.setDireccion(rs.getString("direccion"));
				alumnos.setName(rs.getString("name"));
				alumnos.setApellido(rs.getString("apellido"));
				alumnos.setSexo(rs.getString("sexo"));
				alumnos.setFechadn(rs.getString("fechadn"));
				alumnos.setTelefono(rs.getInt("telefono"));
				alumnos.setPerfil(rs.getString("perfil"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				
				if (pstm != null) {
					pstm.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return alumnos;
	}
}