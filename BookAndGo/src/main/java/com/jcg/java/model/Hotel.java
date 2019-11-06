package com.jcg.java.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hotel {
      public int hotel_id;
      public String getHotel_contact() {
		return hotel_contact;
	}
	public void setHotel_contact(String hotel_contact) {
		this.hotel_contact = hotel_contact;
	}
	public String hotel_name;
      public String hotel_address;
      public String hotel_contact;
      public int Event_id;
      public int Room_id;
	public Hotel() {
		
	}
	public int getEvent_id() {
		return Event_id;
	}
	public void setEvent_id(int event_id) {
		Event_id = event_id;
	}
	public Hotel(int hotel_id, String hotel_name, String hotel_address, int event_id, int room_id) {
		super();
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.hotel_address = hotel_address;
		Event_id = event_id;
		Room_id = room_id;
	}
	public int getRoom_id() {
		return Room_id;
	}
	public void setRoom_id(int room_id) {
		Room_id = room_id;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getHotel_address() {
		return hotel_address;
	}
	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}
	
	
	
      
}
