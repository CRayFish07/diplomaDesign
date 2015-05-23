package com.toy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.service.DeleteRoomService;

public class DeleteRoomAction extends ActionSupport{
	private int id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String execute()throws Exception{
		// to do something here
		DeleteRoomService deleteRoom = new DeleteRoomService();
		if( deleteRoom.deleteRoom(id) ){
			return "success";
		}
		return "error";
	}
}
