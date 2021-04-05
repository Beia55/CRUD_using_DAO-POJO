package ro.emanuel.pojo;

public class Client {
	private int id;
	private String nume;
	private String prenume;
	private int varsta;
	private String cont;
	private double sold;
	
	public Client() {
		super();
	}
	
	public Client(int id, String nume, String prenume, int varsta, String cont, double sold) {
		super();
		this.id = id;
		this.nume = nume;
		this.prenume = prenume;
		this.varsta = varsta;
		this.cont = cont;
		this.sold = sold;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNume() {
		return nume;
	}
	
	public void setNume(String nume) {
		this.nume = nume;
	}
	
	public String getPrenume() {
		return prenume;
	}
	
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	
	public int getVarsta() {
		return varsta;
	}
	
	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}
	
	public String getCont() {
		return cont;
	}
	
	public void setCont(String cont) {
		this.cont = cont;
	}
	
	public double getSold() {
		return sold;
	}

	public void setSold(double sold) {
		this.sold = sold;
	}
}
