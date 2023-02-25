package com.fdm.TeluskoHibernateTutorial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

// @Entity(name="alien_table")
@Entity
@Table(name="alien_table")
public class Alien {
	
	@Id
	private int aId;
	private AlienName aName;
	private String color;
	
//	@Column(name="alien_color")
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public AlienName getaName() {
		return aName;
	}
	public void setaName(AlienName aName) {
		this.aName = aName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Alien [aId=" + aId + ", aName=" + aName + ", color=" + color + "]";
	}
	
}
