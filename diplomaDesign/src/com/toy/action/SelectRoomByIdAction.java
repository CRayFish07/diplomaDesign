package com.toy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.model.Room;
import com.toy.service.GetRoomInfoService;

public class SelectRoomByIdAction extends ActionSupport{
	private int id;
	private Room room;
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String execute()throws Exception{
		GetRoomInfoService getRoom = new GetRoomInfoService();
		Room temp = getRoom.getSingleRoom(id);
		
		System.out.println(temp.getRoom_address()); //≤‚ ‘ ˝æ›
		
		if( temp != null){
			this.setRoom( temp );
			return "success";
		}	
		return "error";
	}
}
