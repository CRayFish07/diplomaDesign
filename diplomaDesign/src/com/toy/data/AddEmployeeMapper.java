package com.toy.data;

import com.toy.model.Employee;

public interface AddEmployeeMapper {
	//根据Employee类注入的数据插入数据库中
	int insertEmployee(Employee employee);

}
