package com.toy.data;

import java.util.Map;

public interface OperatePasswordMapper {
	
	/**
	 * 传入用户名和新的密码<Map>,修改值
	 * @param info
	 * @return
	 */
	int changePassword(Map<String, String> info);
	
	/**
	 * 传入自己的用户名，查询得到旧的密码，用于验证
	 * @param logName
	 * @return
	 */
	String getOldPassword(String logName);
	
	/**
	 * 修改管理员的密码
	 * @param info
	 * @return
	 */
	int changePasswordAdmin(Map<String, String> info);
}
