package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.UpdateEmployeeMapper;
import com.toy.model.Employee;
import com.toy.util.MyFactory;

public class UpdateEmployeeService {
	Employee employee = null;
	
	public UpdateEmployeeService(Employee employee){
		this.employee = employee;
	}
	
	public boolean updateEmployee(){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			UpdateEmployeeMapper updateEmployee = session.getMapper(UpdateEmployeeMapper.class);
			int reNum = updateEmployee.updateEmployee(employee);
			session.commit();
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
