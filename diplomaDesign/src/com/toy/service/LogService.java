package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.util.MyFactory;
import com.toy.data.EmployeeLogMapper;
import com.toy.data.ManagerLogMapper;
import com.toy.model.verification.UserLogVerify;

public class LogService{

	//��ͨ�û���¼ʱʹ�õĵ��õķ���
	public boolean userLogService(String name, String password){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			EmployeeLogMapper employeeLogMapper = session.getMapper(EmployeeLogMapper.class);
			UserLogVerify info = employeeLogMapper.selectPassword(name);
			
			//��������
			//System.out.println(info.getEmp_authority() + " " + info.getLog_password());
			
			if( info.getEmp_authority() == 9   //�ж�Ȩ���Ƿ����9
					&& info.getLog_password() != null 
					&& (info.getLog_password()).equals(password) ){
				return true;
			}
		}catch(Exception e){
			System.out.println("�û���¼��sessionʧ��");
			e.printStackTrace();
		}finally{
			session.close(); //�ر�session
		}	
		return false;
	}
	
	//����Ա�û���¼ʱʹ�õĵ��÷���
	public boolean adminLogService(String name, String password){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
//			System.out.println(name + " " + password);  //��������debugʹ��
			session = sessionFactory.openSession();
			ManagerLogMapper managerLogMapper = session.getMapper(ManagerLogMapper.class);
			String info = managerLogMapper.selectPassword(name);
			
			if( info !=null && info.equals(password)){
				return true;
			}
		}catch(Exception e){
			//System.out.println("����Ա��½��sessionʧ��");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return false;
	}
	//�ܾ����¼ʱʹ�õ������֤����
	public boolean managerLogService(String name, String password){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			EmployeeLogMapper employeeLog = session.getMapper(EmployeeLogMapper.class);
			UserLogVerify info = employeeLog.selectPassword(name);
			//��֤Ȩ�޺�����
			if( info.getEmp_authority() == 1
				&& info.getLog_password() != null 
				&& (info.getLog_password()).equals(password) ){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return false;
	}
	
	//���ž����¼ʱʹ�õ�ʲô����֤����
	public boolean deptManagerLogService(String name, String password){		
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			EmployeeLogMapper employeeLogMapper = session.getMapper(EmployeeLogMapper.class);
			UserLogVerify info = employeeLogMapper.selectPassword(name);
			
			if( info.getEmp_authority() == 5   //�ж�Ȩ���Ƿ����5
				&& info.getLog_password() != null
				&& (info.getLog_password()).equals(password) ){
				
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
