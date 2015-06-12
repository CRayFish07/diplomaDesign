package com.toy.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.AddUserLogMapper;
import com.toy.util.MyFactory;

public class AddUserLogService {
	
	/**
	 * 
	 * @return
	 */
	public boolean addUserLog(String logName, String passWord, String empId){
		
		HashMap<String, String> info = new HashMap<String, String>();
		info.put("logName", logName);   //放入用户名
		info.put("passWord", passWord);	//放入密码
		info.put("empId", empId);		//放入用户id
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			
			AddUserLogMapper addUserLog = session.getMapper(AddUserLogMapper.class);
			int reNum = addUserLog.insertUserLog(info);
			session.commit();
			
			if( reNum > 0 ){
				return true;
			}
			
		}catch(Exception e){
			System.out.println("加入用户登录信息异常");
			e.printStackTrace();
			System.out.println("加入用户登录信息异常");
		}finally{
			session.close();
		}
		return false;
	}
}
