package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexion.Conexion;
import entidad.Admin;

public class ModeloAdminUsuario {	
	public Admin iniciarSesion(String correo, String clave) {
		Admin admin = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = Conexion.getConexion();
			String sql = "SELECT C.id, C.usuario, C.correo, C.clave, C.nombre, C.apellido, C.telefono FROM admin C WHERE C.correo = ? AND C.clave = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, correo);
			pstm.setString(2, clave);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setUsuario(rs.getString("usuario"));
				admin.setCorreo(rs.getString("correo"));
				admin.setClave(rs.getString("clave"));
				admin.setNombre(rs.getString("nombre"));
				admin.setApellido(rs.getString("apellido"));
				admin.setTelefono(rs.getString("telefono"));
				
				
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
		
		return admin;
	}
}