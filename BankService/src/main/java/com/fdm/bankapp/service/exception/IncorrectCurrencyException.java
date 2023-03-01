package com.fdm.bankapp.service.exception;

public class IncorrectCurrencyException extends Exception {
	
	private String senderCurrency;
	private String recipientCurrency;	
	
	public IncorrectCurrencyException(String senderCurrency, String recipientCurrency) {
		super();
		this.senderCurrency = senderCurrency;
		this.recipientCurrency = recipientCurrency;
	}

	@Override
	public String getMessage() {
		
		return "Accounts currency is different, sender currency: " + senderCurrency + ", recipient currency: " + recipientCurrency;
		
	}	

}
