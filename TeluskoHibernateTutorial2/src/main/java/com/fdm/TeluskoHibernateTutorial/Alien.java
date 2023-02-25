package com.fdm.TeluskoHibernateTutorial;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
public class Alien {
	
	@Id
	private int aId;
	private AlienName aName;
	
	@OneToMany(mappedBy="alien", fetch=FetchType.EAGER)
	private Collection<Laptop> laps = new ArrayList<Laptop>();
	
	public Collection<Laptop> getLaps() {
		return laps;
	}
	public void setLaps(Collection<Laptop> laps) {
		this.laps = laps;
	}
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
	
	@Override
	public String toString() {
		return "Alien [aId=" + aId + ", aName=" + aName + "]";
	}
	
}
