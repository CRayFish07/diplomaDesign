package com.toy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.service.AddUserLogService;

public class AddUserLogTrueAction extends ActionSupport{
	private String logName;			//�û���
	private String passWord;		//������
	private String conPassword;		//ȷ������
	private String empId;			//Ա��id
	
//	@getter && setter
	public String getLogName() {
		return logName;
	}
	public void setLogName(String logName) {
		this.logName = logName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getConPassword() {
		return conPassword;
	}
	public void setConPassword(String conPassword) {
		this.conPassword = conPassword;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}


	@Override
	public String execute() throws Exception{
		
		System.out.println("========" + empId );
		
		AddUserLogService addUserLog = new AddUserLogService();
		if(addUserLog.addUserLog(this.logName, this.conPassword, this.empId)){
			return "success";
		}	
		return "error";
	}
	
}
