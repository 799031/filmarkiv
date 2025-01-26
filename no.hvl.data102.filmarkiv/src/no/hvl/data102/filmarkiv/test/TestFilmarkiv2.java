package no.hvl.data102.filmarkiv.test;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;

public class TestFilmarkiv2 extends TestFilmarkivADT{
	
		@Override
		protected FilmarkivADT createInstance() {
	        return new Filmarkiv2();
	    }
}
