package com.toy.data;

import java.util.ArrayList;

import com.toy.model.Employee;

public interface SelectEmployeeMapper {
	/**
	 * 传入数据的时候，也就是name不等于null的时候，进行模糊查询
	 * @param name
	 * @return
	 */
	ArrayList<Employee> getEmployeeList(String name);
	
	/**
	 * 没有传入数据的时候，也就是name等于null的时候，进行全部查询
	 * @return
	 */
	ArrayList<Employee> getEmployeeListNULL();
	
	/**
	 * 传入一个id，得到相关id的一个model值。
	 * @param id
	 * @return
	 */
	Employee getEmployeeById(int id);
	
	/**
	 * 传入用户名，得到用户名所在的部门id
	 * @param logName
	 * @return
	 */
	int getDeptId(String logName);
	
	/**
	 * 传入部门id，得到该id的部门名字
	 * @param id
	 * @return
	 */
	String getDeptName(int id);
}
