package com.jcg.java.model;

public class User {
	public int users_id;
	 public String users_nameFirst;
	 public String users_nameLast;
	 public String users_email;
	 public String users_type;
	 public String users_password;
	public int getUsers_id() {
		return users_id;
	}
	public User(int users_id, String users_nameFirst, String users_nameLast, String users_email, String users_type,
			String users_password) {
		super();
		this.users_id = users_id;
		this.users_nameFirst = users_nameFirst;
		this.users_nameLast = users_nameLast;
		this.users_email = users_email;
		this.users_type = users_type;
		this.users_password = users_password;
	}
	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}
	public String getUsers_nameFirst() {
		return users_nameFirst;
	}
	public void setUsers_nameFirst(String users_nameFirst) {
		this.users_nameFirst = users_nameFirst;
	}
	public String getUsers_nameLast() {
		return users_nameLast;
	}
	public void setUsers_nameLast(String users_nameLast) {
		this.users_nameLast = users_nameLast;
	}
	public String getUsers_email() {
		return users_email;
	}
	public void setUsers_email(String users_email) {
		this.users_email = users_email;
	}
	public String getUsers_type() {
		return users_type;
	}
	public void setUsers_type(String users_type) {
		this.users_type = users_type;
	}
	public String getUsers_password() {
		return users_password;
	}
	public void setUsers_password(String users_password) {
		this.users_password = users_password;
	}
}