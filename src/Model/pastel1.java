package Model;

public class pastel1 {
	
	private String type = "pastel1";

	private int posx;
	private int posy;
	private int tam;
	
	public pastel1() {}
	
	public pastel1(int posx, int posy, int tam) {
		super();
		this.posx = posx;
		this.posy = posy;
		this.tam = tam;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPosx() {
		return posx;
	}

	public void setPosx(int posx) {
		this.posx = posx;
	}

	public int getPosy() {
		return posy;
	}

	public void setPosy(int posy) {
		this.posy = posy;
	}

	public int getTam() {
		return tam;
	}

	public void setTam(int tam) {
		this.tam = tam;
	}
	
	
}
