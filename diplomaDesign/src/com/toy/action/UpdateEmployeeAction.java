package com.toy.action;

import com.opensymphony.xwork2.ActionSupport;

import com.toy.model.Employee;
import com.toy.service.UpdateEmployeeService;

public class UpdateEmployeeAction extends ActionSupport{
	private String name;
	private String sex;
	private String phone;
	private String company;
	private String QQ;
	private String email;
	private String address;
	private String department;
	private String position;
	private String id;
	
	private Employee employee = new Employee();
	
	// getter && setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompany(){
		return company;
	}
	public void setCompany(String company){
		this.company = company;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String execute() throws Exception{
		//给employee 注入数据
		employee.setEmp_address(address);
		employee.setEmp_authority(Integer.parseInt(position));
		employee.setEmp_company(company);
		employee.setEmp_dept_id(Integer.parseInt(department));
		employee.setEmp_email(email);
		employee.setEmp_id(Integer.parseInt(id));
		employee.setEmp_name(name);
		employee.setEmp_phone_number(phone);
		employee.setEmp_QQ(Integer.parseInt(QQ));
		employee.setEmp_sex(sex);
		
		UpdateEmployeeService updateEmployee = new UpdateEmployeeService(employee);
		if( updateEmployee.updateEmployee()){
			return "success";
		}
		return "error";
	}
}
