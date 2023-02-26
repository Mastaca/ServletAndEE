package com.fdm.bankapp.dao;

import com.fdm.bankapp.dao.entities.BankAccountEntity;

public interface BankAccountDao {
	
	BankAccountEntity save(BankAccountEntity bae);
	
	BankAccountEntity findById(int id);
	
	BankAccountEntity bankDeposit(int id, int suma);
	
	BankAccountEntity bankTransfer(int id, int recipientId, int suma);
	
	BankAccountEntity bankWithdrawal(int id, int suma);

}
