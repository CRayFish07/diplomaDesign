package com.toy.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.toy.service.LogService;
import com.opensymphony.xwork2.ActionSupport;

public class LogAction extends ActionSupport{
	private String name;
	private String password;
	
	// getter && setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String execute() throws Exception{
		LogService ls = new LogService();  
		HttpServletRequest request = ServletActionContext.getRequest(); //得到http中的request中的信息
		String radio = request.getParameter("radio"); //获取选项框的内容
//		System.out.println(radio);  //测试数据
		int dept = ls.getDeptId(name);
		
		HttpSession session = request.getSession();    //得到session,将用户名和密码放入到里面
		session.setAttribute("name", name);
		session.setAttribute("password", password);
		session.setAttribute("department", dept);		//将部门的id放入到session
		
		if("admin".equals(radio)){ //返回管理员的的登录字符串
			return adminLog();
		}else if("emp".equals(radio)){ //返回普通员工的登录字符串
			return userLog();			
		}else if("deptManager".equals(radio)){ //返回部门经理的 登录字符串
			return deptManagerLog();
		}else if("manager".equals(radio)){
			return managerLog();
		}
		return "error";
				
	}
	
	//用户登录的处理方法
	public String userLog(){
		LogService ls = new LogService();
		if(ls.userLogService(name, password)){
			return "employee"; //跳转到普通员工界面
		}
		return "error";
	}
	
	//管理员登录的处理方法
	public String adminLog(){
		LogService ls = new LogService();
//		System.out.println(name + " " + password);
		if(ls.adminLogService(name, password)){
			return "admin";	//跳转到管理员的界面
		}
		return "error";
	}
	
	//部门经理登录的处理方法
	public String deptManagerLog(){
		LogService ls = new LogService();
		if(ls.deptManagerLogService(name, password)){
			return "deptManager"; //跳转到部门经理的界面
		}
		return "error";
	}
	
	//总经理登录的处理方法
	public String managerLog(){
		LogService ls = new LogService();
		if(ls.managerLogService(name, password)){
			return "manager"; //跳转到总经理的登录界面	
		}
		return "error";
	}
	
//--------------------------------华丽的分割线------------------------------
//-------------------------------------------------------------------------
	public String logOut(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("name", null);  //清除用户名
		session.setAttribute("password", null); //清除密码
		session.setAttribute("department", null); //清除部门信息
		return "logout";
	}
}
