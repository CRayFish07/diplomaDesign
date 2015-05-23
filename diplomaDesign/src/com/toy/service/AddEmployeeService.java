package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.AddEmployeeMapper;
import com.toy.model.Employee;
import com.toy.util.MyFactory;

public class AddEmployeeService {
	
	Employee employee = null;
	
	public AddEmployeeService(Employee employee){
		this.employee = employee; //��ʼ������
	}
	
	//����Ա��
	public boolean addEmployee(){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			AddEmployeeMapper addEmployee = session.getMapper(AddEmployeeMapper.class);
			int reNum = addEmployee.insertEmployee(employee); //��������
			session.commit(); //���д���ǳ���Ҫ��������Ҫ�ύ�ſ��Խ����ݲ������ݿ���
			if( reNum != 0 ){
				return true; //����ֵ��Ϊ0��˵������������
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return false; //�������˵��û�в�������
	}

}
