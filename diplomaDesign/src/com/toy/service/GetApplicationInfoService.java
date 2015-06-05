package com.toy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.SelectApplicationInfoMapper;
import com.toy.data.SelectMeetingInfoMapper;
import com.toy.model.Application;
import com.toy.model.Meeting;
import com.toy.util.MyFactory;

/**
 * GetApplicationInfoService��������ǵõ������������ص���Ϣ
 * 1.�õ�Applcation�����Ϣ 	getApplicationInfoList()
 * 2.�õ�Meeting�����Ϣ 		getPassMeetingList()
 * 
 * @author Tanoya
 *
 */

public class GetApplicationInfoService {
	
	/**
	 * ͨ��������Ҫ��ѯ��״̬���û������ܹ��õ�Ҫ�����Ϣ���ϣ���ѯApplication��
	 * @param state 
	 * @param logName
	 * @return ��Ϣ���� 
	 */
	public ArrayList<Application> getApplicationInfoList(int state, String logName){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			SelectApplicationInfoMapper applicationInfo = session.getMapper(SelectApplicationInfoMapper.class);
			Map<String, Object> info = new HashMap<String, Object>();
			info.put("state", state); //ע������
			info.put("logName", logName);
			ArrayList<Application> listInfo = applicationInfo.selectApplicationInfoList(info);
			
//			System.out.print(listInfo.size()); //test
			if( listInfo != null ){
				return listInfo;
			}
		}catch(Exception e){
			System.out.println("��ѯ�û�δͨ�����������쳣");
			e.printStackTrace();
			System.out.println("��ѯ�û�δͨ�����������쳣");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * ����Ҫ��ѯ�������˵��û������õ����û��������ͨ������Ϣ������ѯ
	 * @param logName
	 * @return Meeting Model List
	 */
	public ArrayList<Meeting> getPassMeetingList(String logName){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			SelectMeetingInfoMapper meetingInfo = session.getMapper(SelectMeetingInfoMapper.class);
			ArrayList<Meeting> listInfo = meetingInfo.selectPassMeetingList(logName);
			
			System.out.println("The return Num is:" + listInfo.size()); //�������ݣ��鿴�Ƿ񷵻ؽ��
			
			if(listInfo != null){ //�жϸò�ѯ�Ƿ�������������������򷵻ؽ��
				return listInfo;
			}
		}catch(Exception e){
			System.out.println("��������ͨ����ѯ�쳣");
			e.printStackTrace();
			System.out.println("��������ͨ����ѯ�쳣");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * �����û�����״̬���õ����״̬��Ӧ����Ϣ
	 * @param info
	 * @return
	 */
	public ArrayList<Meeting> getMeetingInfoList(Map<String, String> info){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			SelectMeetingInfoMapper meetingInfo = session.getMapper(SelectMeetingInfoMapper.class);
			ArrayList<Meeting> listInfo = meetingInfo.selectMeeingInfoList(info);
			
			if( listInfo != null ){
				return listInfo;
			}
			
		}catch(Exception e){
			System.out.println("����״̬��ѯ�����쳣");
			e.printStackTrace();
			System.out.println("����״̬��ѯ�����쳣");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * ���ܾ���Ľ��棬������ʱ���ʱ����ѯ��ʱ��֮��Ļ���
	 * @param time
	 * @return
	 */
	public ArrayList<Application> getApplicationByTime(String time){
		return null;
	}
	
	/**
	 * ���ܾ���Ľ��棬�õ�ȫ��û�����ĵ�������Ϣ�����ص���ҳ��
	 * @return
	 */
	public ArrayList<Application> getApplicationAll(){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			
			SelectApplicationInfoMapper selectApplication = session.getMapper(SelectApplicationInfoMapper.class);
			ArrayList<Application> infoList = selectApplication.selectApplicationAll();
			
			if( infoList != null ){
				return infoList;
			}
		}catch(Exception e){
			System.out.println("�ܾ�������ѯδ�����������Ϣ�쳣");
			e.printStackTrace();
			System.out.println("�ܾ�������ѯδ�����������Ϣ�쳣");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * ����id���õ�id��Ӧ��Application�ĵ�����Ϣ
	 * @param id
	 * @return
	 */
	public Application getApplicationById(int id){
		SqlSession session = null;
		
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			SelectApplicationInfoMapper selectApplication = session.getMapper(SelectApplicationInfoMapper.class);
			
			Application info = selectApplication.selectOneApplicationInfo(id);
			
			if( info != null){
				return info;
			}
		}catch(Exception e){
			System.out.println("ͨ��id��ѯApplication�쳣");
			e.printStackTrace();
			System.out.println("ͨ��id��ѯApplication�쳣");
		}finally{
			session.close();
		}
		return null;
	}
}
