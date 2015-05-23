package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.util.MyFactory;
import com.toy.data.EmployeeLogMapper;
import com.toy.data.ManagerLogMapper;
import com.toy.model.verification.UserLogVerify;

public class LogService{

	//普通用户登录时使用的调用的方法
	public boolean userLogService(String name, String password){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			EmployeeLogMapper employeeLogMapper = session.getMapper(EmployeeLogMapper.class);
			UserLogVerify info = employeeLogMapper.selectPassword(name);
			
			//测试数据
			//System.out.println(info.getEmp_authority() + " " + info.getLog_password());
			
			if( info.getEmp_authority() == 9   //判断权限是否等于9
					&& info.getLog_password() != null 
					&& (info.getLog_password()).equals(password) ){
				return true;
			}
		}catch(Exception e){
			System.out.println("用户登录打开session失败");
			e.printStackTrace();
		}finally{
			session.close(); //关闭session
		}	
		return false;
	}
	
	//管理员用户登录时使用的调用方法
	public boolean adminLogService(String name, String password){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
//			System.out.println(name + " " + password);  //测试数据debug使用
			session = sessionFactory.openSession();
			ManagerLogMapper managerLogMapper = session.getMapper(ManagerLogMapper.class);
			String info = managerLogMapper.selectPassword(name);
			
			if( info !=null && info.equals(password)){
				return true;
			}
		}catch(Exception e){
			//System.out.println("管理员登陆打开session失败");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return false;
	}
	//总经理登录时使用的身份验证方法
	public boolean managerLogService(String name, String password){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			EmployeeLogMapper employeeLog = session.getMapper(EmployeeLogMapper.class);
			UserLogVerify info = employeeLog.selectPassword(name);
			//验证权限和密码
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
	
	//部门经理登录时使用的什么分验证方法
	public boolean deptManagerLogService(String name, String password){		
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			EmployeeLogMapper employeeLogMapper = session.getMapper(EmployeeLogMapper.class);
			UserLogVerify info = employeeLogMapper.selectPassword(name);
			
			if( info.getEmp_authority() == 5   //判断权限是否等于5
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
