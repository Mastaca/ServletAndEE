package com.account;

import java.util.HashMap;
import java.util.Map;

public class UserAccount {
	
	private String userName;
	private String userPassword;
	private String userEmail;
	
	public static Map<String, UserAccount> userList = new HashMap<String, UserAccount>();
	
	static {
		userList.put("Edi", new UserAccount("Edi", "1234", "edi@"));
		userList.put("Diana", new UserAccount("Diana", "1234", "diana@"));
		userList.put("Andrei", new UserAccount("Andrei", "1234", "andrei@"));
	}
	
	public UserAccount(String userName, String userPassword, String userEmail) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
