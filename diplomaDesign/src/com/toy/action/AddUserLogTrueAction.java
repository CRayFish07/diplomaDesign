package com.toy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.service.AddUserLogService;

public class AddUserLogTrueAction extends ActionSupport{
	private String logName;			//用户名
	private String passWord;		//新密码
	private String conPassword;		//确认密码
	private String empId;			//员工id
	
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
