package no.hvl.data102.filmarkiv.klient;

import javax.swing.JOptionPane;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
	
	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film lesFilm(){		
		
		int filmNr = Integer.valueOf(JOptionPane.showInputDialog("filmNr: "));
		String produsent = JOptionPane.showInputDialog("produsent: ");
		String tittel = JOptionPane.showInputDialog("tittel: ");
		int lansert = Integer.valueOf(JOptionPane.showInputDialog("lansert: "));
		
		Sjanger sjanger;
		while(true) {
			String sjangere = Sjanger.sjangere();
			String sjangerStr = JOptionPane.showInputDialog("sjanger: (" + sjangere + ")");
			sjanger = Sjanger.finnSjanger(sjangerStr);
			
			if(sjanger != null)
				break;
		}
		
		String filmselskap = JOptionPane.showInputDialog("filmselskap: ");
		
		return new Film(filmNr,produsent,tittel,lansert,sjanger,filmselskap);
	}
	
	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		System.out.println("Film nr: " + String.valueOf(film.getFilmNr()));
		System.out.println(film.getProdusent());
		System.out.println(film.getTittel());
		System.out.println(String.valueOf(film.getLansert()));
		System.out.println(film.getSjanger().toString());
		System.out.println(film.getFilmselskap() + "\n");
	}
	
	// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
		Film[] filmer = arkiv.soekTittel(delstreng);
		for(int i=0; i<filmer.length; i++) {
			skrivUtFilm(filmer[i]);
		}
	}
	
	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		Film[] filmer = arkiv.soekProdusent(delstreng);
		for(int i=0; i<filmer.length; i++) {
			skrivUtFilm(filmer[i]);
		}
	}
	
	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		System.out.println("Statestikk");
		System.out.println("Filmer: " + arkiv.antall());
		
		for (Sjanger s : Sjanger.values()) {
			System.out.println("  " + s.toString() + ": " + arkiv.antall(s));
		}
	}
	// osv ... andre metoder
}






