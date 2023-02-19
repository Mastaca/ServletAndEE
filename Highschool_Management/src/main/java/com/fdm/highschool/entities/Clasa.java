package com.fdm.highschool.entities;

import java.util.List;
import java.util.Objects;

public class Clasa {
	
	private int id;
	private String nume;
	private int numarElevi;
	
	private List<Elev> elevi;
	private List<Profesor> profesori;
	
	public Clasa(int id) {
		super();
		this.id = id;
	}
	
	public Clasa(String nume, int numarElevi) {
		super();
		this.nume = nume;
		this.numarElevi = numarElevi;
	}
	
	public Clasa(int id, String nume, int numarElevi) {
		super();
		this.id = id;
		this.nume = nume;
		this.numarElevi = numarElevi;
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

	public int getNumarElevi() {
		return numarElevi;
	}

	public void setNumarElevi(int numarElevi) {
		this.numarElevi = numarElevi;
	}

	@Override
	public int hashCode() {
		return Objects.hash(elevi, id, numarElevi, nume, profesori);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clasa other = (Clasa) obj;
		return Objects.equals(elevi, other.elevi) && id == other.id && numarElevi == other.numarElevi
				&& Objects.equals(nume, other.nume) && Objects.equals(profesori, other.profesori);
	}

}
