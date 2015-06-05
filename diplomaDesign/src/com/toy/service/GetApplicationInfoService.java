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
 * GetApplicationInfoService类的作用是得到与会议申请相关的信息
 * 1.得到Applcation表的信息 	getApplicationInfoList()
 * 2.得到Meeting表的信息 		getPassMeetingList()
 * 
 * @author Tanoya
 *
 */

public class GetApplicationInfoService {
	
	/**
	 * 通过传入需要查询的状态和用户名，能够得到要求的信息集合，查询Application表
	 * @param state 
	 * @param logName
	 * @return 信息集合 
	 */
	public ArrayList<Application> getApplicationInfoList(int state, String logName){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			SelectApplicationInfoMapper applicationInfo = session.getMapper(SelectApplicationInfoMapper.class);
			Map<String, Object> info = new HashMap<String, Object>();
			info.put("state", state); //注入数据
			info.put("logName", logName);
			ArrayList<Application> listInfo = applicationInfo.selectApplicationInfoList(info);
			
//			System.out.print(listInfo.size()); //test
			if( listInfo != null ){
				return listInfo;
			}
		}catch(Exception e){
			System.out.println("查询用户未通过会议申请异常");
			e.printStackTrace();
			System.out.println("查询用户未通过会议申请异常");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * 输入要查询的申请人的用户名，得到该用户申请会议通过的信息链表，查询
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
			
			System.out.println("The return Num is:" + listInfo.size()); //测试数据，查看是否返回结果
			
			if(listInfo != null){ //判断该查询是否产生结果，产生结果，则返回结果
				return listInfo;
			}
		}catch(Exception e){
			System.out.println("会议申请通过查询异常");
			e.printStackTrace();
			System.out.println("会议申请通过查询异常");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * 传入用户名和状态，得到与该状态对应的信息
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
			System.out.println("根据状态查询会议异常");
			e.printStackTrace();
			System.out.println("根据状态查询会议异常");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * 在总经理的界面，当输入时间的时候会查询改时间之后的会议
	 * @param time
	 * @return
	 */
	public ArrayList<Application> getApplicationByTime(String time){
		return null;
	}
	
	/**
	 * 在总经理的界面，得到全部没有审阅的申请信息，返回到主页面
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
			System.out.println("总经理界面查询未处理申请表信息异常");
			e.printStackTrace();
			System.out.println("总经理界面查询未处理申请表信息异常");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * 传入id，得到id对应的Application的单条信息
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
			System.out.println("通过id查询Application异常");
			e.printStackTrace();
			System.out.println("通过id查询Application异常");
		}finally{
			session.close();
		}
		return null;
	}
}
