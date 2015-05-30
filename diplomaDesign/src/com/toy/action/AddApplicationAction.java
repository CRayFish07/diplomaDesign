package com.toy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.toy.model.Application;
import com.toy.service.AddApplicationService;

public class AddApplicationAction extends ActionSupport{
	private String start;
	private String end;
	private String remarks;

	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Override
	public String execute() throws Exception{
		//在session中得到用户名
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("name");
//		System.out.println( userName );  //测试数据
		
		// to do something here
		Application application = new Application();
		application.setApplication_start(start);
		application.setApplication_end(end);
		application.setApplication_remarks(remarks);
		application.setLog_name(userName);
		
		AddApplicationService addApplication = new AddApplicationService();
		if( addApplication.addApplication(application) ){
			return "success";
		}
		return "error";
	}
}
