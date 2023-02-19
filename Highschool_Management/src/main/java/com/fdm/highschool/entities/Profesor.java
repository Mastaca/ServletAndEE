package com.fdm.highschool.entities;

import java.util.Objects;

public class Profesor {
	
	private int id;
	private String nume;
	private Materie materie;
	
	private Clasa clasa;
	
	public Profesor(String nume, Materie materie) {
		super();
		this.nume = nume;
		this.materie = materie;
	}

	public Profesor(int id, String nume, Materie materie) {
		super();
		this.id = id;
		this.nume = nume;
		this.materie = materie;
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

	public Materie getMaterie() {
		return materie;
	}

	public void setMaterie(Materie materie) {
		this.materie = materie;
	}

	public Clasa getClasa() {
		return clasa;
	}

	public void setClasa(Clasa clasa) {
		this.clasa = clasa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clasa, id, materie, nume);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(clasa, other.clasa) && id == other.id && materie == other.materie
				&& Objects.equals(nume, other.nume);
	}
	
	

}
