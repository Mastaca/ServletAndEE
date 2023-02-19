package com.fdm.highschool.entities;

public enum Materie {
	
	MATE("matematica"), 
	ROM("romana"), 
	IST("istorie"), 
	GEO("geografie");
	
	private final String denumire;

	private Materie(String denumire) {
		this.denumire = denumire;
	}

	public String getDenumire() {
		return denumire;
	}
}
