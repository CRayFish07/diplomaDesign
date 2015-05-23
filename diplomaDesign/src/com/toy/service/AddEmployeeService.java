package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.AddEmployeeMapper;
import com.toy.model.Employee;
import com.toy.util.MyFactory;

public class AddEmployeeService {
	
	Employee employee = null;
	
	public AddEmployeeService(Employee employee){
		this.employee = employee; //初始化数据
	}
	
	//增加员工
	public boolean addEmployee(){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			AddEmployeeMapper addEmployee = session.getMapper(AddEmployeeMapper.class);
			int reNum = addEmployee.insertEmployee(employee); //插入数据
			session.commit(); //这行代码非常重要，事务需要提交才可以将数据插入数据库中
			if( reNum != 0 ){
				return true; //返回值不为0，说明插入了数据
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return false; //其他情况说明没有插入数据
	}

}
