package com.fdm.bankapp.dao.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "useraccount")
public class UserAccountEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "parola")
	private String parola;
	
	@Column(name = "cnp")
	private String cnp;
	
	@Column(name = "nume")
	private String nume;
	
	@Column(name = "otp")
	private String otp;
	
	@OneToMany(mappedBy = "uae")
	private List<BankAccountEntity> accounts;	
	
	public UserAccountEntity() {
		super();
	}	
	public UserAccountEntity(int id) {
		super();
		this.id = id;
	}
	
	public UserAccountEntity(String email, String parola, String cnp, String nume) {
		super();
		this.email = email;
		this.parola = parola;
		this.cnp = cnp;
		this.nume = nume;
	}
	public UserAccountEntity(String email, String parola, String cnp, String nume, String otp) {
		super();
		this.email = email;
		this.parola = parola;
		this.cnp = cnp;
		this.nume = nume;
		this.otp = otp;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public List<BankAccountEntity> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<BankAccountEntity> accounts) {
		this.accounts = accounts;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(cnp, email, id, nume, otp, parola);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccountEntity other = (UserAccountEntity) obj;
		return Objects.equals(cnp, other.cnp) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(nume, other.nume) && Objects.equals(otp, other.otp)
				&& Objects.equals(parola, other.parola);
	}
	@Override
	public String toString() {
		return "UserAccountEntity [id=" + id + ", email=" + email + ", parola=" + parola + ", cnp=" + cnp + ", nume="
				+ nume + ", otp=" + otp + "]";
	}	

}
