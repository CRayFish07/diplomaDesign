package com.toy.data;

import com.toy.model.Employee;
public interface UpdateEmployeeMapper {
	
	/**
	 * 传入员工全部信息，通过传入的employee中的id进行修改
	 * @param employee
	 * @return
	 */
	int updateEmployee(Employee employee);
}
