package com.toy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import com.toy.model.Application;
import com.toy.service.AddApplicationService;

public class AddApplicationAction extends ActionSupport{
	private String start;
	private String hourS;
	private String miniteS;
	private String end;
	private String hourE;
	private String miniteE;
	private String remarks;
	private String capacity;

	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public String getHourS() {
		return hourS;
	}
	public void setHourS(String hourS) {
		this.hourS = hourS;
	}
	public String getMiniteS() {
		return miniteS;
	}
	public void setMiniteS(String miniteS) {
		this.miniteS = miniteS;
	}
	public String getHourE() {
		return hourE;
	}
	public void setHourE(String hourE) {
		this.hourE = hourE;
	}
	public String getMiniteE() {
		return miniteE;
	}
	public void setMiniteE(String miniteE) {
		this.miniteE = miniteE;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
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
		
		String st = this.fomatTime(this.start, this.hourS, this.miniteS);
		String en = this.fomatTime(this.end, this.hourE, this.miniteE);
		
		// to do something here
		Application application = new Application();
		application.setApplication_start(st);
		application.setApplication_end(en);
		application.setApplication_remarks(remarks);
		application.setLog_name(userName);
		
		AddApplicationService addApplication = new AddApplicationService();
		if( addApplication.addApplication(application) ){
			return "success";
		}
		return "error";
	}
	
	public String fomatTime(String date, String hour, String minite){
		String time = date + " " + hour + ":" + minite + ":" + "00";		
		return time;
	}
}
