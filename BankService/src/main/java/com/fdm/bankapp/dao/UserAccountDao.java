package com.fdm.bankapp.dao;

import java.util.List;

import com.fdm.bankapp.dao.entities.BankAccountEntity;
import com.fdm.bankapp.dao.entities.UserAccountEntity;

public interface UserAccountDao {
	
	UserAccountEntity save(UserAccountEntity uae);
	
	UserAccountEntity findById(int id);
	
	UserAccountEntity update(UserAccountEntity uae);
	
	List<BankAccountEntity> findAllBankAccounts (int id);
}
