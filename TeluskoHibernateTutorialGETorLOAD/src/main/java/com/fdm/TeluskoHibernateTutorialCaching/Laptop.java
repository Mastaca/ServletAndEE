package com.fdm.TeluskoHibernateTutorialCaching;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {
	
	@Id
	private int Id;
	private String Name;
	private int price;
	
	public int getlId() {
		return Id;
	}
	public void setId(int lId) {
		this.Id = lId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String lName) {
		this.Name = lName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
