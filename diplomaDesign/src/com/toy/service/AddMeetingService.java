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
	 * �õ�room�������з������Ϣ
	 * @return �õ�������Ϣ������
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
	 * �õ���Ӧ��id��Ӧ�Ļ�����Ϣ�������idӦ����room��id��
	 * @param id
	 * @return ������Ϣ����
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
			session.close();  //�رջỰ
		}
		return null; 		//û��ȡ�����ݵ�ʱ�����ݷ���null��˵��û��ȡ������
	}
	
	/**
	 * ˳��������з����id���鿴�ܷ���䷿�䣬���򷵻ط����id�� ���ܵĻ�����-1
	 * @param startTime
	 * @param endTime
	 * @return int
	 */
	public int getRoomId(String startTime, String endTime){
		// to do something here
		long start = this.dateToNum(startTime); //������ת����long���ͱȽϣ�����Ƚ�
		long end = this.dateToNum(endTime);     //ͬ��
//		SqlSession session = null;
		try{
			int i = 0;  //����ÿ������
			int j = 0;	//����ÿ�������ʹ��״̬
			int mark = 0; //���ڼ��ʱ���ǲ����г�ͻ
			ArrayList<Room> roomInfo = this.getRoomInfoList();
			ArrayList<Meeting> meetingInfo = null;
			while( i < roomInfo.size() ){ //��������������Ϣ���鿴ÿ�������ʱ����Ϣ״̬
//				System.out.println( roomInfo.size()); //����ʹ�õ�����
				/**
				 * �˴��ķ�����Ϣ����Ϊ��ֵ��Ҳ���Ƿ���Ŵ��ڣ����Ǹ÷��仹û�в����κ����ݣ�������ݸ÷����ȥ��ѯ��ʱ��
				 * �����null����ʱ���õ�ʱ�������java.lang.nullpointException�쳣
				 */
				try{ 
//					System.out.println(roomInfo.get(i).getRoom_id()); //��������
				    meetingInfo = this.getMeetingInfoList(roomInfo.get(i).getRoom_id());
				    if( meetingInfo == null){  //����÷���û���κ�Ԥ����Ϣ���򷵻ظ÷���Ŀհ׷���
				    	return ( roomInfo.get(i).getRoom_id() );
				    }
				}catch(Exception e){
					System.out.println("�շ��䴦��������AddMeetingService.java; row: 80");
				}finally{
					
				}
				
				
//				System.out.println(meetingInfo.size());
//				System.out.println(meetingInfo.get(i).getMeeting_name()); //��������
				
				while( j < meetingInfo.size() ){
					
					long tempStart = 0;
					long tempEnd = 0;
					
					tempStart = this.dateToNum( (meetingInfo.get(j)).getMeeting_start() );  //�õ������ÿ�λ����¼�Ŀ�ʼʱ��
					tempEnd = this.dateToNum( (meetingInfo.get(j)).getMeeting_end() );		//�õ������ÿ�λ����¼�Ľ���ʱ��
					
//					System.out.println("hellocc"); //�������ݣ��鿴ѭ���˼���
					
					if( (start > tempStart && start < tempEnd) || (end > tempStart &&  	end < tempEnd) ){ //������� 
						break;
					}else if( (tempStart > start && tempStart < end) || (tempEnd > start && tempEnd < end) ){ 
						break;
					}else{
						mark++;  //��¼û�г�ͻ�ļ�¼����
					}
					j++;         // ѭ������
				}
				
				if( mark == meetingInfo.size() ){               //�����ǰ�Ļ����ҵ��Ѿ��е�ԤԼ�͵�ǰԤԼʱ�䶼û�г�ͻ
					return ( roomInfo.get(i).getRoom_id() );	//���ص�ǰ��Ҳ���ǿ��Բ����µ���Ϣ�ķ����
				}
				
				mark = 0; //���ݻ�ԭ�����¼�¼����
				j = 0;	  //���ݻ�ԭ�����±��������ԤԼʱ���
				
//				System.out.println("hello,I am baymax"); // ��������
				
				i++;	  //����ŵı���˳������				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			// to do something here
		}
		return -1;
	}
	
	/**
	 * ����ʹ�õĹ��ܺ��������ַ�������ת����long���������������ڵıȽ�
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
			System.out.println(date); //��������
			e.printStackTrace();
			System.out.println("����ת������������!"); //��������
		}finally{
			// to do something here
		}
		return timeNum;
	}
	
	/**
	 * ͨ��id�õ�Application���е�һ����Ϣ���ڽ�����ʾ��ͨ��id���Եõ����Ӧ���������Ϣ��
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
	 * ͨ������Application�������ݲ��뵽Meeting����
	 * @param application
	 * @return boolean     true��ʾ���ݲ���ɹ���false��ʾ���ݲ���ʧ��
	 */
	public boolean insertMeetingInfo(Application application){
		Meeting meeting = new Meeting();
		int roomId = -1; //������¼�ܹ����뷿��ķ���ţ�-1��ʾû�з����ܹ�����
		String startTime = application.getApplication_start();
		String endTime = application.getApplication_end();
		/*
		 * ��Application���е���Ϣװ�뵽Meeting�У����ҽ�Meeting��Ϣ���뵽���ݿ���
		 */
		// �ܹ����䷿���id��
		roomId = this.getRoomId(startTime, endTime);
		if( roomId != -1 ){ //�˴���ʾ�з����ܹ�����
			//����ע��Application To Meeting
			meeting.setLog_name(application.getLog_name()); //������
			meeting.setMeeting_room_id( roomId );			//���뷿���
			meeting.setMeeting_name(application.getApplication_remarks()); //��������
			meeting.setMeeting_start(startTime);			//��ʼʱ��
			meeting.setMeeting_end(endTime);				//����ʱ��
			meeting.setMeeting_order_time(application.getApplication_time()); //��������ʱ��
			meeting.setMeeting_mark((short)0);  //��Ϊ���Ͳ�ƥ�䣬��Ҫ����ת������int ǿ��ת���� short
			
			// ����AddMeetingMapper(meeting)�����ݿ��в�������
			SqlSession session = null;
			try{
				SqlSessionFactory sessionFactory = MyFactory.getFactory();
				session = sessionFactory.openSession();
				AddMeetingMapper addMeeting = session.getMapper(AddMeetingMapper.class);
				int reNum = addMeeting.insertMeeting(meeting);
				//�ύ����
				session.commit();  //����û���޸�
				if( reNum != 0){  //�����жϣ��ɹ�����true;
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
	 * stateΪҪ�޸ĵ�״̬��applicationIdΪ��Ҫ�޸ĵ���Ϣ��Application��id
	 * @param state
	 * @param applicationId
	 * @return �޸ĳɹ�����true;
	 */
	public boolean ApplicationState(int state, int applicationId){
		SqlSession session = null;
		Map<String, Integer> info = new HashMap<String, Integer>();
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			AddMeetingMapper addMeeting = session.getMapper(AddMeetingMapper.class);
			info.put("state", state);				//�˴��н�Intת����Integer������Ӱ��
			info.put("applicationId", applicationId);
			
			int reNum = addMeeting.updateApplicationState(info);
			
			session.commit();
			if( reNum != 0 ){  //״̬�жϣ��з�������˵���޸ĳɹ�
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
