package com.jsikora;

import java.io.Serializable;

public class Login implements Serializable {


	private static final long serialVersionUID = 1L;

	String username;
	String password;
	
	public Login(String username, String password){
		this.username = username;
		this.password = password;
	}

	public Login() {
	}

	public String getUsername() {
			return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean equals(Object compare){
		Login login = (Login) compare;
		if(this.password.equals(login.password) && this.username.equals(login.username))
			return true;
		else
			return false;
	}
}