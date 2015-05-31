package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.DeleteApplicationMapper;
import com.toy.util.MyFactory;

public class DeleteApplicationService {

	/**
	 * ����id��ɾ�����idֵ���Ӧ��Applicationֵ
	 * @param id
	 * @return
	 */
	public boolean deleteApplicationById(int id){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			DeleteApplicationMapper deleteApplication = session.getMapper(DeleteApplicationMapper.class);
			
			int reNum = deleteApplication.deleteApplicationById(id);
			session.commit();  //�ύ����
//			System.out.println("the Number is: " + reNum); //�������� 
	
			if(reNum != 0){
				return true;
			}
		}catch(Exception e){
			System.out.println("ɾ��Application�쳣");
			e.printStackTrace();
			System.out.println("ɾ��Application�쳣");
		}finally{
			session.close();
		}
		return false;
	}
}
