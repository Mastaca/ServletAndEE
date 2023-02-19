package com.fdm.highschool.entities;

import java.util.Objects;

public class Elev {
	
	private int id;
	private String nume;
	private String adresa;
	
	private Clasa clasa;
	
	public Elev(String nume, String adresa) {
		super();
		this.nume = nume;
		this.adresa = adresa;
	}

	public Elev(int id, String nume, String adresa) {
		super();
		this.id = id;
		this.nume = nume;
		this.adresa = adresa;
	}
	
	public Elev(int id, String nume, String adresa, Clasa clasa) {
		super();
		this.id = id;
		this.nume = nume;
		this.adresa = adresa;
		this.clasa = clasa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Clasa getClasa() {
		return clasa;
	}

	public void setClasa(Clasa clasa) {
		this.clasa = clasa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(adresa, clasa, id, nume);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elev other = (Elev) obj;
		return Objects.equals(adresa, other.adresa) && Objects.equals(clasa, other.clasa) && id == other.id
				&& Objects.equals(nume, other.nume);
	}
	
	

}
