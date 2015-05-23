package com.toy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.service.DeleteEmployeeService;

public class DeleteEmployeeAction extends ActionSupport{
	private String id;
	
	// getter && setter
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}
	
	@Override
	public String execute()throws Exception{
		DeleteEmployeeService deleteEmp = new DeleteEmployeeService(id);
		if( deleteEmp.deleteEmployee() ){
			return "success";
		}
		return "error";
	}
}
