package no.hvl.data102.filmarkiv.impl;

public enum Sjanger {

	ACTION("Action"),
    DRAMA("Drama"),
    HISTORY("History"),
    SCIFI("Sci-Fi");
	
	private final String navn;
	
	Sjanger(String navn) {
		this.navn = navn;
	}

	public static Sjanger finnSjanger(String navn) {
		for (Sjanger s : Sjanger.values()) {
			if (s.toString().equals(navn.toUpperCase())) {
				return s;
			}
		}
		return null;
	}
	
	public String toString() {
		return navn;
	}
	
	public static String sjangere() {
		String str = "";
		for (Sjanger s : Sjanger.values()) {
			str += s.toString();
		}
		return str;
	}
}
