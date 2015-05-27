package com.toy.service;

import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.toy.data.SelectEmployeeMapper;
import com.toy.model.Employee;
import com.toy.util.MyFactory;

public class GetEmployeeInfoService {
	
	/**
	 * 当传入的姓名不为空的时候，进行模糊查询，得到和名字模糊匹配的员工信息
	 * @param name
	 * @return
	 */
	public ArrayList<Employee> getEmployeeList(String name){
		SqlSession session = null; 
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			
			SelectEmployeeMapper employeeMapper = session.getMapper(SelectEmployeeMapper.class);
			System.out.println("?????" + name); //测试  
			ArrayList<Employee> list = employeeMapper.getEmployeeList(name);
			
			if( list != null){
				return list;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("查询员工模糊信息异常");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * 当传入的姓名为空的时候，则查询得到全部的员工信息
	 * @return
	 */
	public ArrayList<Employee> getEmployeeListNULL(){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			
			SelectEmployeeMapper employeeMapper = session.getMapper(SelectEmployeeMapper.class);
			ArrayList<Employee> list = employeeMapper.getEmployeeListNULL();
			
			if( list != null ){
				return list;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("查询员工全部信息异常");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * 传入要提取信息的id，得到该id员工的全部信息
	 * @param id
	 * @return
	 */
	public Employee getEmployeeById(int id){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			
			SelectEmployeeMapper employeeMapper = session.getMapper(SelectEmployeeMapper.class);
			Employee employee = employeeMapper.getEmployeeById(id);
			
			if( employee != null ){
				return employee;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("通过id查询员工信息异常");
		}finally{
			session.close();
		}
		return null;
	}
}
