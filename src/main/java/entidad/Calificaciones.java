package entidad;

public class Calificaciones {
	protected int id;
	protected String titulo;
	protected String descripcion;
	protected String archivo;
	protected String nivel;
	protected String materia;
	protected String name;
	protected String tema;
	protected int nota;
	protected String fechade;
	protected String hora;
	
	public Calificaciones() {
	}
	
	public Calificaciones(String tema) {
		super();
		
		this.tema = tema;
	}
	
	public Calificaciones(int id, String archivo) {
		super();
		
		this.id=id;
		this.archivo=archivo;
	}
	
	
	public Calificaciones(int id, int nota, String fechade, String hora) {
		super();
		this.id=id;		
		this.nota = nota;
		this.fechade= fechade;
		this.hora = hora;
	}
	
	public Calificaciones(String titulo, String descripcion, String archivo, String nivel, String materia, String name, String tema, int nota, String fechade, String hora) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.archivo = archivo;
		this.nivel = nivel;
		this.materia = materia;
		this.name = name;
		this.tema = tema;
		this.nota = nota;
		this.fechade= fechade;
		this.hora = hora;
	}

	public Calificaciones(int id, String titulo, String descripcion, String archivo, String nivel, String materia, String name, String tema, int nota, String fechade, String hora) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.archivo=archivo;
		this.nivel = nivel;
		this.materia = materia;
		this.name = name;
		this.tema = tema;
		this.nota = nota;
		this.fechade = fechade;
		this.hora = hora;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
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
	
}
