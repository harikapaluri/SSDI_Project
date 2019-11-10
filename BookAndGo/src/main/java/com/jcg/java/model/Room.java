package com.jcg.java.model;

public class Room {
	public int Room_id;
	public int hotel_id;
	public int room_type;
	public String room_floor;
	public String roomAvailableFlag;
	public int no_of_beds;
	public Room() {

	}
	public Room(int room_id, int hotel_id, int room_type, String room_floor, String roomAvailableFlag, int no_of_beds) {
		super();
		Room_id = room_id;
		this.hotel_id = hotel_id;
		this.room_type = room_type;
		this.room_floor = room_floor;
		this.roomAvailableFlag = roomAvailableFlag;
		this.no_of_beds = no_of_beds;
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
	public int getRoom_type() {
		return room_type;
	}
	public void setRoom_type(int room_type) {
		this.room_type = room_type;
	}
	public String getRoom_floor() {
		return room_floor;
	}
	public void setRoom_floor(String room_floor) {
		this.room_floor = room_floor;
	}
	public String getRoomAvailableFlag() {
		return roomAvailableFlag;
	}
	public void setRoomAvailableFlag(String roomAvailableFlag) {
		this.roomAvailableFlag = roomAvailableFlag;
	}
	public int getNo_of_beds() {
		return no_of_beds;
	}
	public void setNo_of_beds(int no_of_beds) {
		this.no_of_beds = no_of_beds;
	}
	
	
}

