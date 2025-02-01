package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.test.TestFilm;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
		for(int i = 1; i<12; i++) {
			this.filmarkiv.leggTilFilm(TestFilm.makeObject(i));
		}
	}
	
	public void test() {
		tekstgr.skrivUtFilm(filmarkiv.finnFilm(1));
		tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, "1");
		tekstgr.skrivUtFilmProdusent(filmarkiv, "3");
		tekstgr.skrivUtStatistikk(filmarkiv);
	}
}
