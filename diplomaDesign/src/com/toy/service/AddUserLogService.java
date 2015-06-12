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
		info.put("logName", logName);   //�����û���
		info.put("passWord", passWord);	//��������
		info.put("empId", empId);		//�����û�id
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
			System.out.println("�����û���¼��Ϣ�쳣");
			e.printStackTrace();
			System.out.println("�����û���¼��Ϣ�쳣");
		}finally{
			session.close();
		}
		return false;
	}
}
