package ro.emanuel.pojo;

public class Banca {
	private int id;
	private String nume;
	private String adresa;
	private String telefon;
	
	public Banca() {
		super();
	}

	public Banca(int id, String nume, String adresa, String telefon) {
		super();
		this.id = id;
		this.nume = nume;
		this.adresa = adresa;
		this.telefon = telefon;
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	
}
