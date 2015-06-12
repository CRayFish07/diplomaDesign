package com.toy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.model.Employee;

public class AddUserLogAction extends ActionSupport{
	private int id;     //�����Ա����id
	
	private Employee employee;

	//	getter && setter	//ע��Ա��id������
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
