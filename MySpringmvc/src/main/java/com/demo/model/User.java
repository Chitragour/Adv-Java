package com.demo.model;

public class User {

	String uname;
	String password;
	
	public User() {
		super();
	}

	public User(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [uname=" + uname + ", password=" + password + "]";
	}
	
	
	
}
