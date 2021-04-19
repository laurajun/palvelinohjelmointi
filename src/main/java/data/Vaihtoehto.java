package data;

public class Vaihtoehto {
	private int id;
	private String vaihtoehto;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVaihtoehto() {
		return vaihtoehto;
	}
	public void setVaihtoehto(String vaihtoehto) {
		this.vaihtoehto = vaihtoehto;
	}
	
	public String toString() {
		return id+" "+vaihtoehto;
	}
}
