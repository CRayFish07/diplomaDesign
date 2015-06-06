package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.util.MyFactory;

public class GetDeptInfoService {
	
	/**
	 * �����û����õ��û���Ӧ�Ĳ��ű��
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
		return 0;   //��Ĭ�Ϸ���0
	}
}
