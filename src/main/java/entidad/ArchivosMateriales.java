package entidad;

public class ArchivosMateriales {
	private int id;
	private String nombre;
	private String ruta;
	
	
	

	public ArchivosMateriales() {
	}
	
	public ArchivosMateriales(String nombre,String ruta) {
		super();
		this.nombre = nombre;
		this.ruta = ruta;
		
	}

	
	public ArchivosMateriales(int id, String nombre, String ruta) {
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
		return "http://localhost/WebEscolarUni/src/main/webapp/maimagen/"+ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	

}
