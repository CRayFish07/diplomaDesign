package com.toy.data;

import java.util.ArrayList;
import java.util.Map;
import com.toy.model.Application;

public interface SelectApplicationInfoMapper {
	/**
	 * ����Ҫ��ѯ ������Ϣ��id���õ���id��ǵ�һ����Ϣ
	 * @param id
	 * @return
	 */
	Application selectOneApplicationInfo(int id);
	
	/**
	 * ������Ҫ��ѯ��״̬�����Լ����û������õ��Լ�����������
	 * Map�еĲ�����state����ʾ��Ҫ��ѯ��״̬��
	 * 				logName:��ʾ�ǹ��ڵ�ǰ�û�����Ϣ
	 * @param info
	 * @return ���������Ľ����
	 */
	ArrayList<Application> selectApplicationInfoList(Map<String, Object> info);
}
