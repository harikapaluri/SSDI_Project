package com.jcg.java.model;

public class Book {

	public int booking_id;
	public int Room_id;
	public String users_nameFirst;
	public String users_nameLast;
	public String users_email;
	
	
	public Book() {
	}

	public Book(int booking_id, int room_id, String users_nameFirst, String users_nameLast, String users_email) {
		super();
		this.booking_id = booking_id;
		Room_id = room_id;
		this.users_nameFirst = users_nameFirst;
		this.users_nameLast = users_nameLast;
		this.users_email = users_email;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public int getRoom_id() {
		return Room_id;
	}

	public void setRoom_id(int room_id) {
		Room_id = room_id;
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
		

}
