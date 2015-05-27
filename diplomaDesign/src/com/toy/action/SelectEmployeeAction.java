package com.toy.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.model.Employee;
import com.toy.service.GetEmployeeInfoService;

public class SelectEmployeeAction extends ActionSupport{
	private String name;
	private ArrayList<Employee> employeeList;
	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//启动的时候自动调用该函数
	public String execute()throws Exception{
		
		GetEmployeeInfoService getEmployeeList = new GetEmployeeInfoService();
		ArrayList<Employee> tempList = null;
		if(this.name == "" ){ //name为空调用getEmployeeListNULL
			
			tempList = getEmployeeList.getEmployeeListNULL();
			
			if( (tempList != null)
					&& (tempList.size() != 0) ){ //说明取到了数据
				
				this.setEmployeeList( tempList ); //将数据装入到list中，供前台使用
				return "success";
			}
		}else{					//name不为空调用getEmployeeList
			tempList = getEmployeeList.getEmployeeList("%"+name+"%");
			System.out.println(tempList.size());
			if( (tempList !=null)
					&& (tempList.size() != 0)){
				this.setEmployeeList( tempList );
				return "success";
			}
		}
		return "error"; // 1.数据没有取到. 2.取到了数据，但是数据为0
	}
}
