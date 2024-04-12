package entidad;

public class Temas {
	private int id;
	private String tema;
	
	
	

	public Temas() {
	}
	
	public Temas(String tema) {
		super();
		this.tema = tema;
		
	}

	
	public Temas(int id, String tema) {
		super();
		this.id = id;
		this.tema = tema;
	}
	
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
	
	

}