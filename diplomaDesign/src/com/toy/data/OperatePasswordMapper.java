package com.toy.data;

import java.util.Map;

public interface OperatePasswordMapper {
	
	/**
	 * �����û������µ�����<Map>,�޸�ֵ
	 * @param info
	 * @return
	 */
	int changePassword(Map<String, String> info);
	
	/**
	 * �����Լ����û�������ѯ�õ��ɵ����룬������֤
	 * @param logName
	 * @return
	 */
	String getOldPassword(String logName);
	
	/**
	 * �޸Ĺ���Ա������
	 * @param info
	 * @return
	 */
	int changePasswordAdmin(Map<String, String> info);
}
