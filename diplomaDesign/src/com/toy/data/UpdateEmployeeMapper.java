package com.toy.data;

import com.toy.model.Employee;
public interface UpdateEmployeeMapper {
	
	/**
	 * ����Ա��ȫ����Ϣ��ͨ�������employee�е�id�����޸�
	 * @param employee
	 * @return
	 */
	int updateEmployee(Employee employee);
}
