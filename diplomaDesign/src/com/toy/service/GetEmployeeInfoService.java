package com.toy.service;

import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.toy.data.SelectEmployeeMapper;
import com.toy.model.Employee;
import com.toy.util.MyFactory;

public class GetEmployeeInfoService {
	
	/**
	 * �������������Ϊ�յ�ʱ�򣬽���ģ����ѯ���õ�������ģ��ƥ���Ա����Ϣ
	 * @param name
	 * @return
	 */
	public ArrayList<Employee> getEmployeeList(String name){
		SqlSession session = null; 
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			
			SelectEmployeeMapper employeeMapper = session.getMapper(SelectEmployeeMapper.class);
			System.out.println("?????" + name); //����  
			ArrayList<Employee> list = employeeMapper.getEmployeeList(name);
			
			if( list != null){
				return list;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("��ѯԱ��ģ����Ϣ�쳣");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * �����������Ϊ�յ�ʱ�����ѯ�õ�ȫ����Ա����Ϣ
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
			System.out.println("��ѯԱ��ȫ����Ϣ�쳣");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * ����Ҫ��ȡ��Ϣ��id���õ���idԱ����ȫ����Ϣ
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
			System.out.println("ͨ��id��ѯԱ����Ϣ�쳣");
		}finally{
			session.close();
		}
		return null;
	}
}
