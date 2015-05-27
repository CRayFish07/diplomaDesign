package com.toy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.model.Employee;
import com.toy.service.GetApplicationInfoService;
import com.toy.service.GetEmployeeInfoService;

public class SelectEmployeeByIdAction  extends ActionSupport{
	private int id;
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String execute()throws Exception{
		GetEmployeeInfoService getEmployee = new GetEmployeeInfoService();
		Employee emp = getEmployee.getEmployeeById(id);
		
		if( emp != null){
			this.setEmployee(emp);
			return "success";
		}
		return "error";
	}
	
}
