package com.fdm.bankapp.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fdm.bankapp.dao.UserAccountDao;
import com.fdm.bankapp.dao.UserAccountDaoImpl;
import com.fdm.bankapp.dao.entities.BankAccountEntity;
import com.fdm.bankapp.dao.entities.UserAccountEntity;

public class UserAccountService {
	
	private static UserAccountService instance;
	private UserAccountDao userAccountDao;
	private OTPService otpService;	
	
	private UserAccountService() {		
		this.userAccountDao = new UserAccountDaoImpl();
		this.otpService = OTPService.getInstance();
	}
	
	public static UserAccountService getInstance() {
		
		if (instance == null) {			
			instance = new UserAccountService();			
		}		
		return instance;		
	}

	public UserAccountEntity save(UserAccountEntity uae) {		
		Session session = SessionUtils.createSession();
		Transaction transaction = session.beginTransaction();
		UserAccountEntity userAccountEntity;
		try {
			userAccountEntity = userAccountDao.save(uae, session);
			transaction.commit();
		} finally {
			session.close();
		}		
		return userAccountEntity;
	}
	
	public String generateOTP(int userId) {
		Session session = SessionUtils.createSession();
		Transaction transaction = session.beginTransaction();
		String OTP;
		try {
			OTP = otpService.generateOTP();
			UserAccountEntity uae = userAccountDao.findById(userId, session);
			uae.setOtp(OTP);
			userAccountDao.update(uae, session);
			transaction.commit();
		} finally {
			session.close();
		}
		return OTP;
	}
	
	public List<BankAccountEntity> getBankAccounts(int userAccountId) {		
		Session session = SessionUtils.createSession();
		List<BankAccountEntity> findAllBankAccounts;
		try {
			findAllBankAccounts = userAccountDao.findAllBankAccounts(userAccountId, session);
		} finally {
			session.close();
		}
		return findAllBankAccounts;
	}
	
	public UserAccountEntity getUserAccount (String email) {
		Session session = SessionUtils.createSession();
		UserAccountEntity userAccountEntity;
		try {
			userAccountEntity = userAccountDao.findByEmail(email, session);
		} finally {
			session.close();
		}
		return userAccountEntity;
		
	}
	
	public boolean verifyCredentials(String email, String password) {
		UserAccountEntity userAccountEntity = UserAccountService.getInstance().getUserAccount(email);
		boolean isCorrect = false;
		if (userAccountEntity != null) {			
			if (email.equals(userAccountEntity.getEmail()) && 
				password.equals(userAccountEntity.getParola())) {
				isCorrect = true;
			}
		} 
		return isCorrect;
	}
	
}
