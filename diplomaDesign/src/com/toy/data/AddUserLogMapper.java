package com.toy.data;

import java.util.Map;

public interface AddUserLogMapper {
	/**
	 * �����û���¼��Ϣ
	 * @param info
	 * @return
	 */
	int insertUserLog(Map<String, String> info);
}
