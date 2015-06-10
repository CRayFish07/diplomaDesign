package com.toy.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.OperatePasswordMapper;
import com.toy.util.MyFactory;

public class UpdatePassWordService {
	
	/**
	 * �����޸ĵ��û������µ����룬�޸��û��Լ�������
	 * @return
	 */
	public boolean changePassWord(String logName, String newPassword, String oldPassword){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			OperatePasswordMapper operatePassword = session.getMapper(OperatePasswordMapper.class);
			
			String tempOldPassword = operatePassword.getOldPassword(logName);
			tempOldPassword = (tempOldPassword != null) ? tempOldPassword : ""; //Ԥ��ȡ��������Ϊnull�����ж���ͬʱ�쳣
			HashMap<String, String> info = new HashMap<String, String>();
			
			info.put("newPassword", newPassword);
			info.put("logName", logName);
			
			if( tempOldPassword.equals(oldPassword) ){ 				//�����������֤����ֱ�ӷ��ش���
				int reNum = operatePassword.changePassword(info);   //������޸�   
				session.commit();
				if( reNum != 0){
					return true;
				}
			}
		}catch(Exception e){
			System.out.println("�޸������쳣");
			e.printStackTrace();
			System.out.println("�޸������쳣");
		}finally{
			session.close();
		}
		return false;
	}
}
