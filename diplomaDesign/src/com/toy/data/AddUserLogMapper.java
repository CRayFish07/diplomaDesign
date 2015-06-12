package com.toy.data;

import java.util.Map;

public interface AddUserLogMapper {
	/**
	 * 插入用户登录信息
	 * @param info
	 * @return
	 */
	int insertUserLog(Map<String, String> info);
}
