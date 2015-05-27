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
	
	//������ʱ���Զ����øú���
	public String execute()throws Exception{
		
		GetEmployeeInfoService getEmployeeList = new GetEmployeeInfoService();
		ArrayList<Employee> tempList = null;
		if(this.name == "" ){ //nameΪ�յ���getEmployeeListNULL
			
			tempList = getEmployeeList.getEmployeeListNULL();
			
			if( (tempList != null)
					&& (tempList.size() != 0) ){ //˵��ȡ��������
				
				this.setEmployeeList( tempList ); //������װ�뵽list�У���ǰ̨ʹ��
				return "success";
			}
		}else{					//name��Ϊ�յ���getEmployeeList
			tempList = getEmployeeList.getEmployeeList("%"+name+"%");
			System.out.println(tempList.size());
			if( (tempList !=null)
					&& (tempList.size() != 0)){
				this.setEmployeeList( tempList );
				return "success";
			}
		}
		return "error"; // 1.����û��ȡ��. 2.ȡ�������ݣ���������Ϊ0
	}
}
