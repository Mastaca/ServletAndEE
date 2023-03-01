package com.fdm.bankapp.dao;

import org.hibernate.Session;

import com.fdm.bankapp.dao.entities.BankAccountEntity;

public interface BankAccountDao {
	
	BankAccountEntity save(BankAccountEntity bae, Session session);
	
	BankAccountEntity findById(int id, Session session);
	
	BankAccountEntity findByIban(String iban, Session session);
	
	void update (BankAccountEntity bankAccountEntity, Session session);

}
