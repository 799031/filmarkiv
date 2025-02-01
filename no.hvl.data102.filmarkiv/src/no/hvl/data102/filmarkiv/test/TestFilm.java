package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class TestFilm {
	
	public static final int filmNr = 0;
	public static final String produsent = "produsent";
	public static final String tittel = "tittel";
	public static final int lansert = 2000;
	public static final Sjanger sjanger = Sjanger.HISTORY;
	public static final String filmselskap = "filmselskap";

	public static Film makeObject(int num) {
		String str = String.valueOf(num);
		if(num == 0)
			str = "";
		return new Film(filmNr+num,produsent+str,tittel+str, lansert+num ,sjanger,filmselskap+str);
	}
	
	@Test
	void testConstructor() {
		Film test = makeObject(0);
		
		assertEquals(test.getFilmNr(), filmNr);
		assertEquals(test.getProdusent(), produsent);
		assertEquals(test.getTittel(), tittel);
		assertEquals(test.getLansert(), lansert);
		assertEquals(test.getSjanger(), sjanger);
		assertEquals(test.getFilmselskap(), filmselskap);
	}

}
