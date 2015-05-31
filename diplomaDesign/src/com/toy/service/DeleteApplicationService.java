package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.DeleteApplicationMapper;
import com.toy.util.MyFactory;

public class DeleteApplicationService {

	/**
	 * 传入id，删除与该id值相对应的Application值
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
			session.commit();  //提交事务
//			System.out.println("the Number is: " + reNum); //测试数据 
	
			if(reNum != 0){
				return true;
			}
		}catch(Exception e){
			System.out.println("删除Application异常");
			e.printStackTrace();
			System.out.println("删除Application异常");
		}finally{
			session.close();
		}
		return false;
	}
}
