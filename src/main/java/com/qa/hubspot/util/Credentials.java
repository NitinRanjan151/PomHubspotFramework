package com.qa.hubspot.util;

public class Credentials {

	
	String Username;
	String Password;
	public Credentials(String username, String password) {
		
		this.Username = username;
		this.Password = password;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
}
