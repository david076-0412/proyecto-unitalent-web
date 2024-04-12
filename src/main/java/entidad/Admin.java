package entidad;

public class Admin {
	private int id;
	private String usuario;
	private String correo;
	private String clave;
	private String nombre;
	private String apellido;
	private String telefono;
	
	
	
	
	public Admin() {
		
	}
	
	
	public Admin(String correo, String clave) {
		this.correo=correo;
		this.clave=clave;
	}
	
	
	public Admin(String usuario, String correo, String clave, String nombre, String apellido, String telefono) {
		this.usuario=usuario;
		this.correo=correo;
		this.clave=clave;
		this.nombre=nombre;
		this.apellido=apellido;
		this.telefono=telefono;
	}
	
	
	public Admin(int id, String usuario, String correo, String clave, String nombre, String apellido, String telefono) {
		this.id=id;
		this.usuario=usuario;
		this.correo=correo;
		this.clave=clave;
		this.nombre=nombre;
		this.apellido=apellido;
		this.telefono=telefono;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
