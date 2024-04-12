package entidad;

public class Asistencias {
	private int id;
	private String nombre;
	private String apellido;
	private String clase;
	private String materia;
	private String seccion;
	private String tipoasistencia;
	private String fechade;
	private String hora;
	
	private int dni;
	
	
	

	public Asistencias() {
	}
	
	
	public Asistencias(int dni, String clase, String tipoasistencia) {
		super();
		
		this.dni = dni;
		
		this.clase = clase;
		
		this.tipoasistencia = tipoasistencia;
		
	}
	
	
	
	public Asistencias(String nombre, String apellido, String clase, String materia, String seccion, String tipoasistencia, String fechade, String hora) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.clase = clase;
		this.materia = materia;
		this.seccion = seccion;
		this.tipoasistencia = tipoasistencia;
		this.fechade = fechade;
		this.hora = hora;
		
	}

	
	public Asistencias(int id, String nombre, String apellido, String clase, String materia, String seccion, String tipoasistencia, String fechade, String hora) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.clase = clase;
		this.materia = materia;
		this.seccion = seccion;
		this.tipoasistencia = tipoasistencia;
		this.fechade = fechade;
		this.hora = hora;
		
	}
	
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}
	
	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	
	
	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	
	
	public String getTipoasistencia() {
		return tipoasistencia;
	}

	public void setTipoasistencia(String tipoasistencia) {
		this.tipoasistencia = tipoasistencia;
	}
	
	public String getFechade() {
		return fechade;
	}

	public void setFechade(String fechade) {
		this.fechade = fechade;
	}
	
	
	
	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	
	
	

}
