package entidad;

public class Docentes {
	private int id;
	private String usuario;
	private String correo;
	private String clave;
	private int dni;
	private String direccion;
	private String nombre;
	private String apellido;
	private String sexo;
	private String fechadn;
	private int telefono;
	private String perfil;
	
	
	
	public Docentes() {}
	
	
	
	public Docentes(int id, String correo, String clave) {
		this.id=id;
		this.correo = correo;
		this.clave=clave;
		
		
	}
	
	public Docentes(String correo, String clave) {
		
		this.correo = correo;
		this.clave=clave;
		
		
	}
	
	
	
	public Docentes(String usuario,String correo, String clave, int dni, String direccion, String nombre, String apellido, String sexo, String fechadn, int telefono) {
		this.usuario=usuario;
		this.correo = correo;
		this.clave=clave;
		this.dni=dni;
		this.direccion=direccion;
		this.nombre=nombre;
		this.apellido=apellido;
		this.sexo=sexo;
		this.fechadn=fechadn;
		this.telefono=telefono;
		
	}
	
	public Docentes(int id,String usuario,String correo, String clave, int dni, String direccion, String nombre, String apellido, String sexo, String fechadn, int telefono) {
		this.id=id;
		this.usuario=usuario;
		this.correo = correo;
		this.clave=clave;
		this.dni=dni;
		this.direccion=direccion;
		this.nombre=nombre;
		this.apellido=apellido;
		this.sexo=sexo;
		this.fechadn=fechadn;
		this.telefono=telefono;
		
	}
	
	
	public Docentes(int id,String usuario,String correo, String clave, int dni, String direccion, String nombre, String apellido, String sexo, String fechadn, int telefono, String perfil) {
		this.id=id;
		this.usuario=usuario;
		this.correo = correo;
		this.clave=clave;
		this.dni=dni;
		this.direccion=direccion;
		this.nombre=nombre;
		this.apellido=apellido;
		this.sexo=sexo;
		this.fechadn=fechadn;
		this.telefono=telefono;
		this.perfil=perfil;
		
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
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	
	
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	public String getFechadn() {
		return fechadn;
	}

	public void setFechadn(String fechadn) {
		this.fechadn = fechadn;
	}
	
	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	

}
