package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT{

	private Film[] filmer;
	private int antall;
	
	public Filmarkiv(){
		filmer = new Film[0];
		antall = 0;
	}
	
	public Filmarkiv(int antall){
		filmer = new Film[antall];
		this.antall = 0;
	}
	
	private int finnIndexNr(int filmNr) {
		for(int i = 0; i < filmer.length; i++)
			if(filmer[i].getFilmNr() == filmNr)
				return i;
		return -1;
	}
	
	@Override
	public Film finnFilm(int filmNr) {
		int index = finnIndexNr(filmNr);
		if(index != -1)
			return filmer[index];
		else 
			return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if(antall == filmer.length)
			filmer = lagStorre(filmer, filmer.length+1);
		
		filmer[antall] = nyFilm;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmNr) {
		int index = finnIndexNr(filmNr);
		if(index == -1)
			return false;
		
		for(int i = index; i < antall-1; i++)
			filmer[i] = filmer[i+1];
		
		return true;
	}
	
	private Film[] finnFilmerMed(String delstreng, boolean soekTittel) {

		Film[] filmerMed = new Film[0];
		for(int i = 0; i < filmer.length; i++) 
		{
			String str = soekTittel ? filmer[i].getTittel() : filmer[i].getProdusent();
			if(str.contains(delstreng))
			{
				filmerMed = lagStorre(filmerMed, filmerMed.length+1);
				filmerMed[filmerMed.length-1] = filmer[i];
			}
		}
		return filmerMed;
	}
	
	@Override
	public Film[] soekTittel(String delstreng) {
		return finnFilmerMed(delstreng, true);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		return finnFilmerMed(delstreng, false);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int count = 0;
		for(int i = 0; i < filmer.length; i++)
			if(filmer[i].getSjanger() == sjanger)
				count++;
		return count;
	}

	@Override
	public int antall() {
		return this.antall;
	}
	
	private Film[] lagStorre(Film[] filmer, int nyLengde) {
		Film[] nyArr = new Film[nyLengde];
		for(int i = 0; i < Math.min(filmer.length, nyLengde); i++)
			nyArr[i] = filmer[i];
		return nyArr;
	}
}
















