package com.fdm.bankapp.service;

import java.util.List;

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
		return userAccountDao.save(uae);
	}
	
	public String generateOTP(int userId) {
		String OTP = otpService.generateOTP();
		UserAccountEntity uae = userAccountDao.findById(userId);
		uae.setOtp(OTP);
		userAccountDao.update(uae);		
		return OTP;
	}
	
	public List<BankAccountEntity> getBankAccounts(int userAccountId) {		
		return userAccountDao.findAllBankAccounts(userAccountId);
	}
	
}
