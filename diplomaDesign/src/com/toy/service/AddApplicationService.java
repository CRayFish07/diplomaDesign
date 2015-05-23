package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.AddApplicationMapper;
import com.toy.model.Application;
import com.toy.util.MyFactory;

public class AddApplicationService {
	
	//增加申请信息
	public boolean addApplication(Application application){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			AddApplicationMapper addApplication = session.getMapper(AddApplicationMapper.class);
			int reNum = addApplication.insertApplication(application);
			session.commit();//提交事务
			
			if( reNum != 0 ){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return false;
	}
}
