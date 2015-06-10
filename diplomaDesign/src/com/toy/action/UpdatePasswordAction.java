package com.toy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.service.UpdatePassWordService;

public class UpdatePasswordAction extends ActionSupport{
	private String newPassword;		//新密码
	private String newPasswordCon;	//新密码确认
	private String oldPassword;		//旧密码
	
	
	// getter && setter
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNewPasswordCon() {
		return newPasswordCon;
	}
	public void setNewPasswordCon(String newPasswordCon) {
		this.newPasswordCon = newPasswordCon;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	
	@Override
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String logName = (String)session.getAttribute("name");  //获取当前用户的登录名称
		
		UpdatePassWordService changePassword = new UpdatePassWordService();
		
		newPassword = (newPassword != null) ? newPassword : "";
		
		if( !newPassword.equals(newPasswordCon)){  //密码校验，如果填写的两个新的密码不一致，直接返回错误
			return "error";
		}
		if( changePassword.changePassWord(logName, newPassword, oldPassword) ){  //说明更改成功
			return "success";
		}
		return "error";
	}

}
