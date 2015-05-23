package com.toy.data;

import com.toy.model.verification.UserLogVerify;

public interface EmployeeLogMapper {
	UserLogVerify selectPassword(String name);
}
