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
	//��ȡ��Ҫ��ѯ��״̬
	private String status;
	
	//���ص�ǰ̨�Ļ�����Ϣ����
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
		
//		System.out.println(status + "%%%%%%%%%%%%%%%%"); //��������
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");   //�õ�session�д洢���û���
		
		Map<String, String> info = new HashMap<String, String>();
		info.put("logName", name);
		info.put("status", status);
		
//		System.out.println(name + "   " + status); //��������
		
		GetApplicationInfoService service = new GetApplicationInfoService();
		ArrayList<Meeting> temp = service.getMeetingInfoList(info);
		
//		System.out.println( temp.get(0).getMeeting_name()); // ��������
		
		if( temp != null ){
			this.setMeetingList( temp );
			if( "0".equals(status) ){ //���û�ѡ��δ���еĻ���ʱ
				return "UnTake";
			}else{					  //���û�ѡ���Ѿ����еĻ����ȡ���Ļ���ʱ
				return "Taken";
			}
		}
		return "error";
	}
	
}
