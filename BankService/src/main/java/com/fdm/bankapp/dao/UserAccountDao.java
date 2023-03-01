package com.fdm.bankapp.dao;

import java.util.List;

import org.hibernate.Session;

import com.fdm.bankapp.dao.entities.BankAccountEntity;
import com.fdm.bankapp.dao.entities.UserAccountEntity;

public interface UserAccountDao {
	
	UserAccountEntity save(UserAccountEntity uae, Session session);
	
	UserAccountEntity findById(int id, Session session);
	
	UserAccountEntity update(UserAccountEntity userAccountEntity, Session session);
	
	List<BankAccountEntity> findAllBankAccounts (int id, Session session);

	UserAccountEntity findByEmail(String email, Session session);
}
