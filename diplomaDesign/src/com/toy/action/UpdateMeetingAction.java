package com.toy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.service.UpdateMeetingService;

public class UpdateMeetingAction extends ActionSupport{
	private int id;

//	@getter && setter
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	@Override
	public String execute() throws Exception{
		UpdateMeetingService meetingService = new UpdateMeetingService();
		boolean temp = meetingService.updateMeetingCancel(id);
		
		if( temp == true){
			return "success";
		}
		return "error";
	}
	
}
