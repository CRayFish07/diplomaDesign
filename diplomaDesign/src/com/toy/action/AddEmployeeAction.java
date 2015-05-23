package com.toy.action;

import sun.security.x509.AuthorityInfoAccessExtension;
import com.opensymphony.xwork2.ActionSupport;

import com.toy.model.Employee;
import com.toy.service.AddEmployeeService;

public class AddEmployeeAction extends ActionSupport{
	private String name;
	private String sex;
	private String phone;
	private int QQ;
	private String company;
	private String email;
	private String address;
	private String department;
	private String position;
	
	//创建一个新的员工类
	Employee employee = new Employee();
	
	// getter && getter
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

	public int getQQ() {
		return QQ;
	}

	public void setQQ(int QQ) {
		this.QQ = QQ;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	@Override
	public String execute() throws Exception{
		
		//初始化数据
		employee.setEmp_name(name);
		employee.setEmp_sex(sex);
		employee.setEmp_QQ(QQ);
		employee.setEmp_phone_number(phone);
		employee.setEmp_email(email);
		employee.setEmp_dept_id( Integer.parseInt(department));
		employee.setEmp_company(company);
		employee.setEmp_authority( Integer.parseInt(position));
		employee.setEmp_address(address);
		
		System.out.println(employee.getEmp_address()); //测试数据
		AddEmployeeService addEmployee = new AddEmployeeService(employee);
		if( addEmployee.addEmployee()){
			return "success";
		}
		return "error";
	}
	
}
