package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexion.Conexion;
import entidad.Docentes;

public class ModeloUsuario {	
	public Docentes iniciarSesion(String correo, String clave) {
		Docentes docentes = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = Conexion.getConexion();
			String sql = "SELECT C.id, C.usuario, C.correo, C.clave, C.dni, C.direccion, C.nombre, C.apellido, C.sexo, C.fechadn, C.telefono, C.perfil FROM docentes C WHERE C.correo = ? AND C.clave = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, correo);
			pstm.setString(2, clave);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				docentes = new Docentes();
				docentes.setId(rs.getInt("id"));
				docentes.setUsuario(rs.getString("usuario"));
				docentes.setCorreo(rs.getString("correo"));
				docentes.setClave(rs.getString("clave"));
				docentes.setDni(rs.getInt("dni"));
				docentes.setDireccion(rs.getString("direccion"));
				docentes.setNombre(rs.getString("nombre"));
				docentes.setApellido(rs.getString("apellido"));
				docentes.setSexo(rs.getString("sexo"));
				docentes.setFechadn(rs.getString("fechadn"));
				docentes.setTelefono(rs.getInt("telefono"));
				docentes.setPerfil(rs.getString("perfil"));
				
				
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
		
		return docentes;
	}
}
