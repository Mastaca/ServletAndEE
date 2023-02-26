package com.fdm.bankapp.service;

import com.fdm.bankapp.dao.BankAccountDao;
import com.fdm.bankapp.dao.BankAccountDaoImpl;
import com.fdm.bankapp.dao.entities.BankAccountEntity;

public class BankAccountService {
	
	private static BankAccountService instance;
	private BankAccountDao bankAccountDao;	
	
	private BankAccountService() {		
		this.bankAccountDao = new BankAccountDaoImpl();		
	}
	
	public static BankAccountService getInstance() {		
		if (instance == null) {			
			instance = new BankAccountService();			
		}		
		return instance;		
	}

	public BankAccountEntity save(BankAccountEntity bae) {		
		return bankAccountDao.save(bae);
	}
	
	public BankAccountEntity getBankAccount(int id) {
		return bankAccountDao.findById(id);		
	}
	
	public BankAccountEntity deposit (int id, int suma) {
		return bankAccountDao.bankDeposit(id, suma);
	}
	
	public BankAccountEntity withdrawal (int id, int suma) {
		return bankAccountDao.bankWithdrawal(id, suma);
	}
	
	public BankAccountEntity transfer (int id, int recipientId, int suma) {
		return bankAccountDao.bankTransfer(id, recipientId, suma);
	}

}
