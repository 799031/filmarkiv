package no.hvl.data102.filmarkiv.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public abstract class TestFilmarkivADT {

	protected abstract FilmarkivADT createInstance();

	static private FilmarkivADT data;
	static final int len = 10;
	
	// starter fra 1 fordi 0 har spesiell data
	@BeforeEach
	private void oppsettTester() {
		data = createInstance();
		for(int i = 1; i<len+1; i++) {
			data.leggTilFilm(TestFilm.makeObject(i));
		}
	}
	
	@Test
	public void testConstructor() {
		assertEquals(len, data.antall());
	}

	@Test
	public void testFinnFilm() {				
		assertTrue(data.finnFilm(2) != null);
		assertTrue(data.finnFilm(0) == null);
		
		int filmNum = 5;
		Film correct = TestFilm.makeObject(filmNum);
		assertTrue(correct.getFilmNr() == data.finnFilm(filmNum).getFilmNr());
	}

	@Test
	public void testSlettFilm() {
		int filmNr = 3;
		
		assertTrue(!data.slettFilm(0));
		assertTrue(data.slettFilm(filmNr));
		
		assertEquals(data.finnFilm(filmNr),null);
	}

	@Test
	public void testSoekTittel() {
		int finnFilmTittel = 3;

		Film filmObj = TestFilm.makeObject(finnFilmTittel);
		String tittel = filmObj.getTittel();
		assertEquals(1, data.soekTittel(tittel).length);
		assertEquals(data.antall(), data.soekTittel("").length);
				
		data.leggTilFilm(filmObj);
		assertEquals(2, data.soekTittel(tittel).length);
		
		Film filmObj2 = TestFilm.makeObject(0);
		assertEquals(data.antall(), data.soekTittel(filmObj2.getTittel()).length);
	}

	@Test
	public void testSoekProdusent() {
		int finnFilmProdusent = 3;
		
		Film filmObj = TestFilm.makeObject(finnFilmProdusent);
		String produsent = filmObj.getProdusent();
		assertEquals(1, data.soekProdusent(produsent).length);
		assertEquals(data.antall(), data.soekProdusent("").length);

		data.leggTilFilm(TestFilm.makeObject(finnFilmProdusent));
		assertEquals(2, data.soekProdusent(produsent).length);
		
		Film filmObj2 = TestFilm.makeObject(0);
		assertEquals(data.antall(), data.soekProdusent(filmObj2.getProdusent()).length);
	}

	@Test
	public void testAntallSjanger() {
		assertEquals(data.antall(), data.antall(TestFilm.sjanger));
		
		Sjanger isZero = Sjanger.ACTION;
		assertTrue(isZero != TestFilm.sjanger);
		assertEquals(0, data.antall(isZero));
	}
}








