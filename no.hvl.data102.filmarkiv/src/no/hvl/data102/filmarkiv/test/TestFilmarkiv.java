package no.hvl.data102.filmarkiv.test;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;

public class TestFilmarkiv extends TestFilmarkivADT {
	
	@Override
	protected FilmarkivADT createInstance() {
        return new Filmarkiv();
    }
    
}
