package com.fdm.bankapp.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fdm.bankapp.dao.BankAccountDao;
import com.fdm.bankapp.dao.BankAccountDaoImpl;
import com.fdm.bankapp.dao.entities.BankAccountEntity;
import com.fdm.bankapp.service.exception.IncorrectCurrencyException;
import com.fdm.bankapp.service.exception.InsufficientFundsException;

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
		Session session = SessionUtils.createSession();
		Transaction transaction = session.beginTransaction();
		BankAccountEntity bankAccountEntity;
		try {
			bankAccountEntity = bankAccountDao.save(bae, session);
			transaction.commit();
		} finally {
			session.close();
		}
		return bankAccountEntity;
	}
	
	public BankAccountEntity getBankAccount(int id) {
		BankAccountEntity bankAccountEntity;
		Session session = SessionUtils.createSession();
		try {
	        bankAccountEntity = bankAccountDao.findById(id, session);
		} finally {
			session.close();;
		}
		return bankAccountEntity;		
	}
	
	public BankAccountEntity deposit (String iban, int suma) {	
		BankAccountEntity bankAccountEntity;
		Session session = SessionUtils.createSession();
		Transaction transaction = session.beginTransaction();
		try {
			bankAccountEntity = bankAccountDao.findByIban(iban, session);
			bankAccountEntity.setSuma(bankAccountEntity.getSuma() + suma);
			bankAccountDao.update(bankAccountEntity, session);
			transaction.commit();
		} finally {
			session.close();
		}
		return bankAccountEntity;
	}
	
	public BankAccountEntity withdrawal (String iban, int suma) throws InsufficientFundsException {
		BankAccountEntity bankAccountEntity;
		Session session = SessionUtils.createSession();
		Transaction transaction = session.beginTransaction();
		try {
			bankAccountEntity = bankAccountDao.findByIban(iban, session);
			if (bankAccountEntity.getSuma() - suma >= 0) {
				bankAccountEntity.setSuma(bankAccountEntity.getSuma() - suma);
			} else {
				throw new InsufficientFundsException();
			}
			bankAccountDao.update(bankAccountEntity, session);
			transaction.commit();
		} finally {
			session.close();
		}
		return bankAccountEntity;
		
	}
	
	public BankAccountEntity transfer (String senderIban, String recipientIban, int suma) throws InsufficientFundsException, IncorrectCurrencyException {	
		BankAccountEntity sender;
		BankAccountEntity recipient;
		Session session = SessionUtils.createSession();
		Transaction transaction = session.beginTransaction();
		try {			
			sender = bankAccountDao.findByIban(senderIban, session);
			recipient = bankAccountDao.findByIban(recipientIban, session);
			if (!sender.getMoneda().equals(recipient.getMoneda())) {
				throw new IncorrectCurrencyException(sender.getMoneda().name(), recipient.getMoneda().name());
			}				
			if (sender.getSuma() - suma >= 0) {
				sender.setSuma(sender.getSuma() - suma);
			} else {
				throw new InsufficientFundsException();
			}
			recipient.setSuma(recipient.getSuma() + suma);
			bankAccountDao.update(recipient, session);
			bankAccountDao.update(sender, session);
			transaction.commit();
		} finally {
			session.close();
		}
		return sender;
	}

}
