package com.jcg.java.model;

public class Event {
     public int Event_id;	
     public String event_name;
     public String event_time;
     public int Room_id;
	public Event() {
		
		
	}
		
	public Event(int event_id, String event_name, String event_time, int room_id) {
		super();
		Event_id = event_id;
		this.event_name = event_name;
		this.event_time = event_time;
		Room_id = room_id;
	}

	public int getEvent_id() {
		return Event_id;
	}
	public void setEvent_id(int event_id) {
		Event_id = event_id;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getEvent_time() {
		return event_time;
	}
	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}
	public int getRoom_id() {
		return Room_id;
	}
	public void setRoom_id(int room_id) {
		Room_id = room_id;
	}    
     
}

