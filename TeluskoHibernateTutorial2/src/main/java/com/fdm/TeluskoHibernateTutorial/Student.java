package com.fdm.TeluskoHibernateTutorial;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	private int rollno;
	private String name;
	private int mrks;
//	@OneToOne
//	private Laptop laptop;
//	@OneToMany(mappedBy="student")
//	private List<Laptop> laptop = new ArrayList<Laptop>();
	@ManyToMany(mappedBy="student")
	private List<Laptop> laptop = new ArrayList<Laptop>();
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMrks() {
		return mrks;
	}
	public void setMrks(int mrks) {
		this.mrks = mrks;
	}
	
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", mrks=" + mrks + "]";
	}
	
	
	
	
}
