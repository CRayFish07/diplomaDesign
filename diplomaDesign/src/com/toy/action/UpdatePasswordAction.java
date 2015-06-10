package com.toy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.service.UpdatePassWordService;

public class UpdatePasswordAction extends ActionSupport{
	private String newPassword;		//������
	private String newPasswordCon;	//������ȷ��
	private String oldPassword;		//������
	
	
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
		String logName = (String)session.getAttribute("name");  //��ȡ��ǰ�û��ĵ�¼����
		
		UpdatePassWordService changePassword = new UpdatePassWordService();
		
		newPassword = (newPassword != null) ? newPassword : "";
		
		if( !newPassword.equals(newPasswordCon)){  //����У�飬�����д�������µ����벻һ�£�ֱ�ӷ��ش���
			return "error";
		}
		if( changePassword.changePassWord(logName, newPassword, oldPassword) ){  //˵�����ĳɹ�
			return "success";
		}
		return "error";
	}

}
