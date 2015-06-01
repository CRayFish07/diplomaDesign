package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.UpdateMeetingMapper;
import com.toy.util.MyFactory;

public class UpdateMeetingService {
	
	/**
	 * ���캯��
	 */
	public UpdateMeetingService(){
	}
	
	/**
	 * ����Meeting���ȡ������
	 * @param id
	 * @return
	 */
	public boolean updateMeetingCancel(int id){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			
			UpdateMeetingMapper updateMeeting = session.getMapper(UpdateMeetingMapper.class);
			int reNum = updateMeeting.updateMeetingCancel(id);
			session.commit();
			
			if( reNum != 0){
				return true;
			}
		}catch(Exception e){
			System.out.println("�޸Ļ���Ϊȡ��״̬�쳣");
			e.printStackTrace();
			System.out.println("�޸Ļ���Ϊȡ��״̬�쳣");
		}finally{
			session.close();
		}
		return false;
	}
	
	/**
	 * ����Meeting����Ϊ�Ѿ�����
	 * @param id
	 * @return
	 */
	public boolean updateMeetingTaken(int id){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			
			UpdateMeetingMapper updateMeeting = session.getMapper(UpdateMeetingMapper.class);
			int reNum = updateMeeting.updateMeetingTaken(id);
			session.commit();
			
			if( reNum != 0 ){
				return true;
			}
		}catch(Exception e){
			System.out.println("�޸Ļ���Ϊ�Ѿ��ٿ�״̬�쳣");
			e.printStackTrace();
			System.out.println("�޸Ļ���Ϊ�Ѿ��ٿ�״̬�쳣");
		}finally{
			session.close();
		}
		return false;
	}
	
	
}
