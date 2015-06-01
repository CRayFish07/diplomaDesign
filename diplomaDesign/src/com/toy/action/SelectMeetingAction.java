package com.toy.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.data.SelectMeetingInfoMapper;
import com.toy.model.Meeting;
import com.toy.service.GetApplicationInfoService;

public class SelectMeetingAction extends ActionSupport{
	//获取需要查询的状态
	private String status;
	
	//返回到前台的会议信息集合
	private ArrayList<Meeting> meetingList;

//	@getter && setter	
	
	public String getStatus() {
		return status;
	}
	public ArrayList<Meeting> getMeetingList() {
		return meetingList;
	}
	public void setMeetingList(ArrayList<Meeting> meetingList) {
		this.meetingList = meetingList;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String execute() throws Exception{
		
//		System.out.println(status + "%%%%%%%%%%%%%%%%"); //测试数据
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");   //得到session中存储的用户名
		
		Map<String, String> info = new HashMap<String, String>();
		info.put("logName", name);
		info.put("status", status);
		
//		System.out.println(name + "   " + status); //测试数据
		
		GetApplicationInfoService service = new GetApplicationInfoService();
		ArrayList<Meeting> temp = service.getMeetingInfoList(info);
		
//		System.out.println( temp.get(0).getMeeting_name()); // 测试数据
		
		if( temp != null ){
			this.setMeetingList( temp );
			if( "0".equals(status) ){ //当用户选择未举行的会议时
				return "UnTake";
			}else{					  //当用户选择已经举行的会议和取消的会议时
				return "Taken";
			}
		}
		return "error";
	}
	
}
