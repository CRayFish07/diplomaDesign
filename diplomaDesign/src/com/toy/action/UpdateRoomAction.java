package com.toy.action;

import com.toy.model.Room;
import com.toy.service.UpdateRoomService;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateRoomAction extends ActionSupport{
	private String id;
	private String name;
	private String address;
	private String capacity;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String execute()throws Exception{
		// to do something here
		Room room = new Room();
		room.setRoom_address(address);
		room.setRoom_capacity(Integer.parseInt(capacity));
		room.setRoom_id(Integer.parseInt(id));
		room.setRoom_name(name);
		
		UpdateRoomService updateRoom = new UpdateRoomService();
		if( updateRoom.updateRoom(room) ){
			return "success";
		}
		return "error";
	}
	
}
