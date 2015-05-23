package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.DeleteEmployeeMapper;
import com.toy.util.MyFactory;

public class DeleteEmployeeService {
	private int id;
	
	public DeleteEmployeeService(String id){
		this.id = Integer.parseInt(id);
	}
	
	//通过id删除员工
	public boolean deleteEmployee(){
		// to do something here
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			DeleteEmployeeMapper deleteEmployee = session.getMapper(DeleteEmployeeMapper.class);
			int reNum = deleteEmployee.deleteEmployee( id );
			session.commit();
			if( reNum != 0 ){ //当删除成功的时候
				return true;
			}
		}catch(Exception e){
			e.printStackTrace(); //打印错误的信息
		}finally{
			session.close();
		}
		return false;
	}
}
