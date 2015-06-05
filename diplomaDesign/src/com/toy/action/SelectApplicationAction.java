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
	//用于查询使用的时间
	private String time;
	
	//用于返回查询的申请未通过的状态信息集
	private ArrayList<Application> applicationList;
	
	//	getter && setter
	public String getTime(){
		return this.time;
	}
	public void setTime(String time){
		this.time = time;
	}
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
		ArrayList<Application> temp = service.getApplicationInfoList(0, logName);
		
//		System.out.println("返回的数据" + temp.get(0).getApplication_remarks() + "userName:" + logName + " " + status );
//		System.out.println( temp );
		if( temp != null ){
			this.setApplicationList(temp);
			return "success";
		}
		return "error";
	}
	
	/**
	 * 通过传入时间来进行查询该时间段之后的申请，当数据空的时候，则代表查询全部未处理的数据
	 * @param time
	 * @return
	 */
	public String checkApplicationByTime(){
		
		GetApplicationInfoService getApplication = new GetApplicationInfoService();
		ArrayList<Application> infoList = null;
		if( "".equals(this.time) ){

//			System.out.println("test1");  //测试数据
			infoList = getApplication.getApplicationAll();
			if( infoList != null ){
				this.setApplicationList(infoList);
				return "ManagerApp";
			}
		}else{
			//填充时间，放在这里处理数据
			
		}
		return "ManagerError";
	}
}
