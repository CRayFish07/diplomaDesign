package com.toy.data;

import java.util.ArrayList;

import com.toy.model.Employee;

public interface SelectEmployeeMapper {
	/**
	 * �������ݵ�ʱ��Ҳ����name������null��ʱ�򣬽���ģ����ѯ
	 * @param name
	 * @return
	 */
	ArrayList<Employee> getEmployeeList(String name);
	
	/**
	 * û�д������ݵ�ʱ��Ҳ����name����null��ʱ�򣬽���ȫ����ѯ
	 * @return
	 */
	ArrayList<Employee> getEmployeeListNULL();
	
	/**
	 * ����һ��id���õ����id��һ��modelֵ��
	 * @param id
	 * @return
	 */
	Employee getEmployeeById(int id);
	
	/**
	 * �����û������õ��û������ڵĲ���id
	 * @param logName
	 * @return
	 */
	int getDeptId(String logName);
	
	/**
	 * ���벿��id���õ���id�Ĳ�������
	 * @param id
	 * @return
	 */
	String getDeptName(int id);
}
