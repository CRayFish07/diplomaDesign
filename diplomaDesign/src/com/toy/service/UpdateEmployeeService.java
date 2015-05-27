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
	
	/**
	 * 初始化的时候传入了employee，然后进行全部值的输入修改
	 * @return
	 */
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
