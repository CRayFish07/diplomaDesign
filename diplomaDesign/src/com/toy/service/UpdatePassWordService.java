package com.toy.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.OperatePasswordMapper;
import com.toy.util.MyFactory;

public class UpdatePassWordService {
	
	/**
	 * 传入修改的用户名和新的密码，修改用户自己的密码
	 * @return
	 */
	public boolean changePassWord(String logName, String newPassword, String oldPassword){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			OperatePasswordMapper operatePassword = session.getMapper(OperatePasswordMapper.class);
			
			String tempOldPassword = operatePassword.getOldPassword(logName);
			tempOldPassword = (tempOldPassword != null) ? tempOldPassword : ""; //预防取到的数据为null，在判断相同时异常
			HashMap<String, String> info = new HashMap<String, String>();
			
			info.put("newPassword", newPassword);
			info.put("logName", logName);
			
			if( tempOldPassword.equals(oldPassword) ){ 				//输入的密码验证错误，直接返回错误
				int reNum = operatePassword.changePassword(info);   //密码的修改   
				session.commit();
				if( reNum != 0){
					return true;
				}
			}
		}catch(Exception e){
			System.out.println("修改密码异常");
			e.printStackTrace();
			System.out.println("修改密码异常");
		}finally{
			session.close();
		}
		return false;
	}
}
