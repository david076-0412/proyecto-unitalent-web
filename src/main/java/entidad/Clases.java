package entidad;

public class Clases {
	protected int id;
	protected String clase;
	protected String seccion;
	protected String materia;
	protected String aula;
	
	public Clases() {
	}
	
	
	public Clases(String clase) {
		super();
		this.clase = clase;
		
	}
	
	public Clases(String clase, String seccion, String materia, String aula) {
		super();
		this.clase = clase;
		this.seccion = seccion;
		this.materia = materia;
		this.aula = aula;
	}
	
	

	public Clases(int id, String clase, String seccion, String materia, String aula) {
		super();
		this.id = id;
		this.clase = clase;
		this.seccion = seccion;
		this.materia = materia;
		this.aula = aula;
	}
	
	
	
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	
}
