package com.toy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.toy.util.MyFactory;
import com.toy.data.AddMeetingMapper;
import com.toy.data.SelectApplicationInfoMapper;
import com.toy.data.SelectMeetingInfoMapper;
import com.toy.data.SelectRoomIdMapper;
import com.toy.model.Application;
import com.toy.model.Room;
import com.toy.model.Meeting;

public class AddMeetingService {
	
	/**
	 * 得到room表中所有房间的信息
	 * @return 得到房间信息的链表
	 */
	public ArrayList<Room> getRoomInfoList(){
		// to do something here
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			SelectRoomIdMapper selectRoomId = session.getMapper(SelectRoomIdMapper.class);
			ArrayList<Room> list = selectRoomId.selectRoomIdList();
			
			if( list.size() != 0 ){
				return list;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * 得到相应的id对应的会议信息，这里的id应该是room的id。
	 * @param id
	 * @return 会议信息链表
	 */
	public ArrayList<Meeting> getMeetingInfoList(int id){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			SelectMeetingInfoMapper selectMeetingList = session.getMapper(SelectMeetingInfoMapper.class);
			ArrayList<Meeting> list = selectMeetingList.selectMeetingList(id);
			
			
			if( list.size() != 0 ){
				return list;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();  //关闭会话
		}
		return null; 		//没有取到数据的时候，数据返回null，说明没有取到数据
	}
	
	/**
	 * 顺序遍历所有房间的id，查看能否分配房间，能则返回房间的id， 不能的话返回-1
	 * @param startTime
	 * @param endTime
	 * @return int
	 */
	public int getRoomId(String startTime, String endTime){
		// to do something here
		long start = this.dateToNum(startTime); //将日期转换成long整型比较，方便比较
		long end = this.dateToNum(endTime);     //同上
//		SqlSession session = null;
		try{
			int i = 0;  //遍历每个房间
			int j = 0;	//遍历每个房间的使用状态
			int mark = 0; //用于检测时间是不是有冲突
			ArrayList<Room> roomInfo = this.getRoomInfoList();
			ArrayList<Meeting> meetingInfo = null;
			while( i < roomInfo.size() ){ //遍历整个房间信息表，查看每个房间的时间信息状态
//				System.out.println( roomInfo.size()); //测试使用的数据
				/**
				 * 此处的房间信息可能为空值，也就是房间号存在，但是该房间还没有插入任何数据，如果根据该房间号去查询的时候，
				 * 会出现null，这时调用的时候会引发java.lang.nullpointException异常
				 */
				try{ 
//					System.out.println(roomInfo.get(i).getRoom_id()); //测试数据
				    meetingInfo = this.getMeetingInfoList(roomInfo.get(i).getRoom_id());
				    if( meetingInfo == null){  //如果该房间没有任何预定信息，则返回该房间的空白房号
				    	return ( roomInfo.get(i).getRoom_id() );
				    }
				}catch(Exception e){
					System.out.println("空房间处理处理啊错误，AddMeetingService.java; row: 80");
				}finally{
					
				}
				
				
//				System.out.println(meetingInfo.size());
//				System.out.println(meetingInfo.get(i).getMeeting_name()); //测试数据
				
				while( j < meetingInfo.size() ){
					
					long tempStart = 0;
					long tempEnd = 0;
					
					tempStart = this.dateToNum( (meetingInfo.get(j)).getMeeting_start() );  //得到房间的每次会议记录的开始时间
					tempEnd = this.dateToNum( (meetingInfo.get(j)).getMeeting_end() );		//得到房间的每次会议记录的结束时间
					
//					System.out.println("hellocc"); //测试数据，查看循环了几次
					
					if( (start > tempStart && start < tempEnd) || (end > tempStart &&  	end < tempEnd) ){ //两种情况 
						break;
					}else if( (tempStart > start && tempStart < end) || (tempEnd > start && tempEnd < end) ){ 
						break;
					}else{
						mark++;  //记录没有冲突的记录数量
					}
					j++;         // 循环遍历
				}
				
				if( mark == meetingInfo.size() ){               //如果当前的会议室的已经有的预约和当前预约时间都没有冲突
					return ( roomInfo.get(i).getRoom_id() );	//返回当前，也就是可以插入新的信息的房间号
				}
				
				mark = 0; //数据还原，重新记录数据
				j = 0;	  //数据还原，重新遍历房间的预约时间表
				
//				System.out.println("hello,I am baymax"); // 测试数据
				
				i++;	  //房间号的遍历顺序自增				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			// to do something here
		}
		return -1;
	}
	
	/**
	 * 本类使用的功能函数，将字符串日期转换成long型整数，用于日期的比较
	 * @param date
	 * @return long
	 */
	public long dateToNum(String date){
		long timeNum = 0;
		try{
			date = date.replace(" ", "");
			date = date.replace(":", "");
			date = date.replace("-", "");
			date = date.replace(".", "");
			timeNum = Long.parseLong(date);
		}catch(Exception e){
			System.out.println(date); //测试数据
			e.printStackTrace();
			System.out.println("日期转换成数字有误!"); //测试数据
		}finally{
			// to do something here
		}
		return timeNum;
	}
	
	/**
	 * 通过id得到Application表中的一条信息，在界面显示中通过id可以得到相对应的申请的信息。
	 * @param id
	 * @return
	 */
	public Application getApplicateInfo(int id){
		SqlSession session = null;
		Application application = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			SelectApplicationInfoMapper applicationInfo = session.getMapper(SelectApplicationInfoMapper.class);
			
			application = applicationInfo.selectOneApplicationInfo(id);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return application;
	}
	
	
	/**
	 * 通过传入Application，将数据插入到Meeting表中
	 * @param application
	 * @return boolean     true表示数据插入成功，false表示数据插入失败
	 */
	public boolean insertMeetingInfo(Application application){
		Meeting meeting = new Meeting();
		int roomId = -1; //用来记录能够插入房间的房间号，-1表示没有房间能够插入
		String startTime = application.getApplication_start();
		String endTime = application.getApplication_end();
		/*
		 * 将Application表中的信息装入到Meeting中，并且将Meeting信息插入到数据库中
		 */
		// 能够分配房间的id号
		roomId = this.getRoomId(startTime, endTime);
		if( roomId != -1 ){ //此处表示有房间能够分配
			//数据注入Application To Meeting
			meeting.setLog_name(application.getLog_name()); //申请人
			meeting.setMeeting_room_id( roomId );			//申请房间号
			meeting.setMeeting_name(application.getApplication_remarks()); //会议名称
			meeting.setMeeting_start(startTime);			//开始时间
			meeting.setMeeting_end(endTime);				//结束时间
			meeting.setMeeting_order_time(application.getApplication_time()); //会议申请时间
			meeting.setMeeting_mark((short)0);  //因为类型不匹配，需要进行转换，将int 强制转换成 short
			
			// 调用AddMeetingMapper(meeting)向数据库中插入数据
			SqlSession session = null;
			try{
				SqlSessionFactory sessionFactory = MyFactory.getFactory();
				session = sessionFactory.openSession();
				AddMeetingMapper addMeeting = session.getMapper(AddMeetingMapper.class);
				int reNum = addMeeting.insertMeeting(meeting);
				//提交数据
				session.commit();  //数据没有修改
				if( reNum != 0){  //条件判断，成功返回true;
					return true;
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				session.close();
			}
		}
		return false;
	}
	
	/**
	 * state为要修改的状态，applicationId为需要修改的信息的Application的id
	 * @param state
	 * @param applicationId
	 * @return 修改成功返回true;
	 */
	public boolean ApplicationState(int state, int applicationId){
		SqlSession session = null;
		Map<String, Integer> info = new HashMap<String, Integer>();
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			AddMeetingMapper addMeeting = session.getMapper(AddMeetingMapper.class);
			info.put("state", state);				//此处有将Int转换成Integer带来的影响
			info.put("applicationId", applicationId);
			
			int reNum = addMeeting.updateApplicationState(info);
			
			session.commit();
			if( reNum != 0 ){  //状态判断，有返回数据说明修改成功
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return false;
	}
}
