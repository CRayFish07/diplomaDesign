package com.toy.action;

import com.opensymphony.xwork2.ActionSupport;

import com.toy.model.Application;
import com.toy.service.AddApplicationService;

public class AddApplicationAction extends ActionSupport{
	private String start;
	private String end;
	private String remarks;
	private String username;
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String execute() throws Exception{
		// to do something here
		Application application = new Application();
		application.setApplication_start(start);
		application.setApplication_end(end);
		application.setApplication_remarks(remarks);
		application.setLog_name(username);
		
		AddApplicationService addApplication = new AddApplicationService();
		if( addApplication.addApplication(application) ){
			return "success";
		}
		return "error";
	}
}
