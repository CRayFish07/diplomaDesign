package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.UpdateMeetingMapper;
import com.toy.util.MyFactory;

public class UpdateMeetingService {
	
	/**
	 * 构造函数
	 */
	public UpdateMeetingService(){
	}
	
	/**
	 * 用于Meeting表的取消会议
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
			System.out.println("修改会议为取消状态异常");
			e.printStackTrace();
			System.out.println("修改会议为取消状态异常");
		}finally{
			session.close();
		}
		return false;
	}
	
	/**
	 * 用于Meeting表标记为已经举行
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
			System.out.println("修改会议为已经召开状态异常");
			e.printStackTrace();
			System.out.println("修改会议为已经召开状态异常");
		}finally{
			session.close();
		}
		return false;
	}
	
	
}
