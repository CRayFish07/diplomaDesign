package com.toy.model;

public class Room {
	private int room_id;
	private String room_name;
	private String room_address;
	private int room_capacity;
	
	// getter && setter
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int roomId) {
		room_id = roomId;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String roomName) {
		room_name = roomName;
	}
	public String getRoom_address() {
		return room_address;
	}
	public void setRoom_address(String roomAddress) {
		room_address = roomAddress;
	}
	public int getRoom_capacity() {
		return room_capacity;
	}
	public void setRoom_capacity(int roomCapacity) {
		room_capacity = roomCapacity;
	}
}
