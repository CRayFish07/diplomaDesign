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
	
	//ͨ��idɾ��Ա��
	public boolean deleteEmployee(){
		// to do something here
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			DeleteEmployeeMapper deleteEmployee = session.getMapper(DeleteEmployeeMapper.class);
			int reNum = deleteEmployee.deleteEmployee( id );
			session.commit();
			if( reNum != 0 ){ //��ɾ���ɹ���ʱ��
				return true;
			}
		}catch(Exception e){
			e.printStackTrace(); //��ӡ�������Ϣ
		}finally{
			session.close();
		}
		return false;
	}
}
