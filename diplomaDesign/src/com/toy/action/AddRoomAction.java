package com.toy.action;

import com.toy.model.Room;
import com.toy.service.AddRoomService;
import com.opensymphony.xwork2.ActionSupport;

public class AddRoomAction extends ActionSupport{
	private String name;
	private String address;
	private String capacity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String execute() throws Exception{
		Room room = new Room();
		room.setRoom_address(address);
		room.setRoom_name(name);
		room.setRoom_capacity(Integer.parseInt(capacity));
		
		AddRoomService addRoom = new AddRoomService(room);
		if( addRoom.addRoom() ){
			return "success";
		}
		return "error";
	}
	
}
