package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.impl.Filmarkiv;

public class FilmarkivMain {

	public static void main(String[] args) {
		Meny meny = new Meny(new Filmarkiv());
		meny.test();
    }
}
