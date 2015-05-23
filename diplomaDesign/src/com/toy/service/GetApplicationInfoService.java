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
	 * 通过传入需要查询的状态和用户名，能够得到要求的信息集合
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
	 * 输入要查询的申请人的用户名，得到该用户申请会议通过的信息链表
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
}
