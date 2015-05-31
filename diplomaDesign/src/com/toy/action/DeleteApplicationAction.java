package com.toy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.service.DeleteApplicationService;

public class DeleteApplicationAction extends ActionSupport{
	//É¾³ýApplicationÊ¹ÓÃµÄid
	private int id;

//	@setter && getter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String execute() throws Exception{
		
		DeleteApplicationService deleteApplication = new DeleteApplicationService();
		boolean temp = deleteApplication.deleteApplicationById(id);
		
		if( temp ){
			return "success";
		}
		return "error";
	}
}
