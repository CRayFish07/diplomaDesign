package com.toy.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.model.Application;
import com.toy.service.GetApplicationInfoService;

public class SelectApplicationAction extends ActionSupport{
	//需要查询的状态
	private int status;
	//用于返回查询的申请未通过的状态信息集
	private ArrayList<Application> applicationList;
	
	//	getter && setter
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}	
	public ArrayList<Application> getApplicationList() {
		return applicationList;
	}
	public void setApplicationList(ArrayList<Application> applicationList) {
		this.applicationList = applicationList;
	}

	@Override
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String logName = (String)session.getAttribute("name");
		
		GetApplicationInfoService service = new GetApplicationInfoService();
		ArrayList<Application> temp = service.getApplicationInfoList(status, logName); 
		
		System.out.println("返回的数据" + temp.get(0).getApplication_remarks() + "userName:" + logName + " " + status );
		
		if( temp != null ){
			this.setApplicationList(temp);
			return "success";
		}
		
		return "error";
	}

}
