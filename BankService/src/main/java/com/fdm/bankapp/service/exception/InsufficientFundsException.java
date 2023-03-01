package com.fdm.bankapp.service.exception;

public class InsufficientFundsException extends Exception {

	@Override
	public String getMessage() {
		
		return "Insufficient funds";
	}
	
	

}
