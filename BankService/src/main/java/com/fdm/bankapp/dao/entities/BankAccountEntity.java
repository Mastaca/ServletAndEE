package com.fdm.bankapp.dao.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bankaccount")
public class BankAccountEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String iban;
	
	@Enumerated (EnumType.STRING)
	private Moneda moneda;
	private int suma;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserAccountEntity uae;

	
	
	public BankAccountEntity() {
		super();
	}
	public BankAccountEntity(String iban, Moneda moneda, UserAccountEntity uae) {
		super();
		this.iban = iban;
		this.moneda = moneda;
		this.uae = uae;
	}
	public BankAccountEntity(String iban, Moneda moneda, int suma, UserAccountEntity uae) {
		super();
		this.iban = iban;
		this.moneda = moneda;
		this.suma = suma;
		this.uae = uae;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public Moneda getMoneda() {
		return moneda;
	}
	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}
	public int getSuma() {
		return suma;
	}
	public void setSuma(int suma) {
		this.suma = suma;
	}
	public UserAccountEntity getUae() {
		return uae;
	}
	public void setUae(UserAccountEntity uae) {
		this.uae = uae;
	}

	@Override
	public int hashCode() {
		return Objects.hash(iban, id, moneda, suma, uae);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccountEntity other = (BankAccountEntity) obj;
		return Objects.equals(iban, other.iban) && id == other.id && moneda == other.moneda && suma == other.suma
				&& Objects.equals(uae, other.uae);
	}
	@Override
	public String toString() {
		return "BankAccountEntity [id=" + id + ", iban=" + iban + ", moneda=" + moneda + ", suma=" + suma + ", uae=" + uae + "]";
	}	

}
