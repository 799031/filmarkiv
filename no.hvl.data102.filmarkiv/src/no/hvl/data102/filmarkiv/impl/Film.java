package no.hvl.data102.filmarkiv.impl;

public class Film {

	
	private int filmNr;
	private String produsent;
	private String tittel;
	private int lansert;
	private Sjanger sjanger;
	private String filmselskap;
	
	public Film() {
	}
	
	public Film(int filmNr, String produsent, String tittel, int lansert, Sjanger sjanger, String filmselskap) {
		this.filmNr = filmNr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lansert = lansert;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}

	public int getFilmNr() {
		return filmNr;
	}
	public void setFilmNr(int filmNr) {
		this.filmNr = filmNr;
	}
	
	public String getProdusent() {
		return produsent;
	}
	
	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}
	
	public String getTittel() {
		return tittel;
	}
	
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	
	public int getLansert() {
		return lansert;
	}
	
	public void setLansert(int lansert) {
		this.lansert = lansert;
	}
	
	public Sjanger getSjanger() {
		return sjanger;
	}
	
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	
	public String getFilmselskap() {
		return filmselskap;
	}
	
	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
		
}



