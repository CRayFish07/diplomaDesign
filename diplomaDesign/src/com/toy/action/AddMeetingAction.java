package com.toy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.model.Meeting;
import com.toy.model.Room;
import com.toy.service.AddMeetingService;
import com.toy.service.GetApplicationInfoService;

import java.util.ArrayList;

//������ͨ����ʱ�򣬾�����ͨ����ť������Ҫ�����ݼ��뵽���ݿ���
public class AddMeetingAction extends ActionSupport{

	@Override
	public String execute() throws Exception{
//		System.out.println("test1");  //���ݲ���
		AddMeetingService addMeeting = new AddMeetingService();
		
		GetApplicationInfoService getApp = new GetApplicationInfoService();
		getApp.getPassMeetingList("tany");
		
//		addMeeting.ApplicationState(1, 3);
//		System.out.println("pass");
//		System.out.println(	addMeeting.getApplicateInfo(1).getLog_name() );
		
//		int reNum = addMeeting.getRoomId("2015-05-12 12:25:01.0", "2015-05-12 12:50:22.0");
//		System.out.println(reNum);
	
//		ArrayList<Room> list = addMeeting.getRoomInfoList(); 							  //���ݲ���
// 		System.out.println(list.get(0).getRoom_id() + " " + list.get(1).getRoom_name());  //���ݲ���
		
		//��������
//		ArrayList<Meeting> meetingList = addMeeting.getMeetingInfoList(1);				
//		System.out.println(meetingList.get(0).getMeeting_start()); 						 //���ݲ���
//		System.out.println(addMeeting.dateToNum(meetingList.get(0).getMeeting_start())); // ���ݲ���
//		System.out.println("num is:" + meetingList.size());
		return "success";
	}
}
