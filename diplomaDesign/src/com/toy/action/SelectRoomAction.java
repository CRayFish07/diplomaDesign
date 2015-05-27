package com.toy.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.model.Room;
import com.toy.service.GetRoomInfoService;

public class SelectRoomAction extends ActionSupport{
	private String name;
	private ArrayList<Room> roomList;
	
	public ArrayList<Room> getRoomList() {
		return roomList;
	}
	public void setRoomList(ArrayList<Room> roomList) {
		this.roomList = roomList;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String execute() throws Exception{
		GetRoomInfoService getRoomInfo = new GetRoomInfoService();
		ArrayList<Room> temp = null;
		if( this.name == "" ){
			temp = getRoomInfo.getRoomList();
			if(temp != null){
				this.setRoomList( temp );
				return "success";
			}
		}else{
			temp = getRoomInfo.getRoomList(name);
			if( temp != null){
				this.setRoomList(temp);
				return "success";
			}
		}
		return "error";
	}
}
