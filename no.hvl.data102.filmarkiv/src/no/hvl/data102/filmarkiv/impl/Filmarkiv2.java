package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;


public class Filmarkiv2 implements FilmarkivADT{

	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2(){
		antall = 0;
		start = new LinearNode<Film>();
	}
		
	@Override
	public Film finnFilm(int nr) {
		
		LinearNode<Film> temp = start.neste;
		for(int i = 0; i < antall; i++) {
			if(temp.data.getFilmNr() == nr)
				return temp.data;
			temp = temp.neste;
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		start.addData(nyFilm);
		antall++;
	}

	@Override
	public boolean slettFilm(int filmNr) {
		LinearNode<Film> temp = start;
		
		for(int i = 0; i < antall-1; i++) {
			if(temp.neste.data.getFilmNr() == filmNr) {
				if(temp.fjernNeste());
					antall--;
				return true;
			}
			temp = temp.neste;
		}
		return false;
	}
	
	private Film[] finnFilmerMed(String delstreng, boolean soekTittel) {

		Film[] filmerMed = new Film[0];
		
		LinearNode<Film> temp = start.neste;
		for(int i = 0; i < antall; i++) 
		{
			String str = soekTittel ? temp.data.getTittel() : temp.data.getProdusent();
			if(str.contains(delstreng))
			{
				filmerMed = lagStorre(filmerMed,filmerMed.length+1);
				filmerMed[filmerMed.length-1] = temp.data;
			}
			temp = temp.neste;
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
		LinearNode<Film> temp = start.neste;

		int count = 0;
		for(int i = 0; i < antall; i++) {
			if(temp.data.getSjanger() == sjanger)
				count++;
			temp = temp.neste;
		}

		return count;
	}

	@Override
	public int antall() {
		return antall;
	}
	
	private Film[] lagStorre(Film[] filmer, int nyLengde) {
		Film[] nyArr = new Film[nyLengde];
		for(int i = 0; i < Math.min(filmer.length, nyLengde); i++)
			nyArr[i] = filmer[i];
		return nyArr;
	}

}
