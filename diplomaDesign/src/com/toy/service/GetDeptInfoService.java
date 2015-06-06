package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.util.MyFactory;

public class GetDeptInfoService {
	
	/**
	 * 传入用户名得到用户对应的部门编号
	 * @param logName
	 * @return
	 */
	public int getDept(String logName){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		return 0;   //先默认返回0
	}
}
