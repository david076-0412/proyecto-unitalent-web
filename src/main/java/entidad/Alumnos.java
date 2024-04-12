package entidad;


public class Alumnos {
	protected int id;
	protected String name;
	protected String apellido;
	protected int dni;
	protected String email;
	protected String direccion;
	protected String password;
	protected String sexo;
	protected String fechadn;
	protected int telefono;
	protected String perfil;
	
	public Alumnos() {
	}
	
	public Alumnos(String name, String apellido) {
		super();
		this.name = name;
		this.apellido = apellido;
		
	}
	
	
	
	public Alumnos(String name, String apellido, int dni, String email, String direccion, String password, String sexo, String fechadn, int telefono, String perfil) {
		super();
		this.name = name;
		this.apellido = apellido;
		this.dni=dni;
		this.email=email;
		this.direccion=direccion;
		this.password=password;
		this.sexo=sexo;
		this.fechadn=fechadn;
		this.telefono = telefono;
		this.perfil = perfil;
		
	}
	
	
	
	
	public Alumnos(String name, String apellido, int dni, String email, String direccion, String password, String sexo, String fechadn, int telefono) {
		super();
		this.name = name;
		this.apellido = apellido;
		this.dni=dni;
		this.email=email;
		this.direccion=direccion;
		this.password=password;
		this.sexo=sexo;
		this.fechadn=fechadn;
		this.telefono = telefono;
		
	}
	
	
	
	
	
	
	public Alumnos(String name, String apellido, int dni, String email, String direccion, String password,  String fechadn, int telefono) {
		super();
		this.name = name;
		this.apellido = apellido;
		this.dni=dni;
		this.email=email;
		this.direccion=direccion;
		this.password=password;
		this.fechadn=fechadn;
		this.telefono = telefono;
		
	}
	
	
	
	
	public Alumnos(int id, String name, String apellido, int dni, String email, String direccion, String password,  String sexo, String fechadn, int telefono, String perfil) {
		super();
		this.id=id;
		this.name = name;
		this.apellido = apellido;
		this.dni=dni;
		this.email=email;
		this.direccion=direccion;
		this.password=password;
		this.sexo=sexo;
		this.fechadn=fechadn;
		this.telefono = telefono;
		this.perfil = perfil;
		
	}
	
	
	
	public Alumnos(int id, String name, String apellido, int dni, String email, String direccion, String password, String sexo, String fechadn, int telefono) {
		super();
		this.id = id;
		this.name = name;
		this.apellido = apellido;
		this.dni=dni;
		this.email=email;
		this.direccion=direccion;
		this.password=password;
		this.sexo=sexo;
		this.fechadn=fechadn;
		this.telefono = telefono;
		
	}
	
	
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
