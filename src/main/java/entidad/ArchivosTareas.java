package entidad;

public class ArchivosTareas {
	private int id;
	private String nombre;
	private String ruta;
	
	
	

	public ArchivosTareas() {
	}
	
	public ArchivosTareas(String nombre) {
		super();
		this.nombre = nombre;
		
	}
	
	
	
	public ArchivosTareas(String nombre,String ruta) {
		super();
		this.nombre = nombre;
		this.ruta = ruta;
		
	}

	
	public ArchivosTareas(int id, String nombre, String ruta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ruta = ruta;
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
	
	public String getRuta() {
		return "http://localhost/WebEscolarUni/src/main/webapp/taimagen/"+ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	

}
