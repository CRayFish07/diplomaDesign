package com.toy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.model.Employee;

public class AddUserLogAction extends ActionSupport{
	private int id;     //这个是员工的id
	
	private Employee employee;

	//	getter && setter	//注入员工id的数据
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Override
	public String execute()throws Exception{
		if(id > 0){
			return "success";
		}
		return "error";
	}
}
