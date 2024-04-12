package entidad;

public class ArchivoCalifica {
	private int id;
	private String nombre;
	private String ruta;
	
	
	

	public ArchivoCalifica() {
	}
	
	public ArchivoCalifica(String nombre) {
		super();
		this.nombre = nombre;
		
	}
	
	
	
	public ArchivoCalifica(String nombre,String ruta) {
		super();
		this.nombre = nombre;
		this.ruta = ruta;
		
	}

	
	public ArchivoCalifica(int id, String nombre, String ruta) {
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
		return "http://localhost/WebEscuela/src/main/webapp/caimagen/"+ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	

}
