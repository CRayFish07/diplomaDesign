package com.toy.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.toy.model.Meeting;

public interface SelectMeetingInfoMapper {
	/**
	 * ���뷿���id���õ����Ǹ÷�������Ļ�û�о��еĻ����ԤԼ����
	 * @param id
	 * @return
	 */
	ArrayList<Meeting> selectMeetingList(int id);
	
	/**
	 * ��������id��Ȼ��õ�����ĵ���Ϣ
	 * @param id
	 * @return
	 */
	Meeting selectSingleMeeting(int id);
	
	/**
	 * �������������˵��û��������ظ��û��������ͨ���ļ�¼
	 * @param logName
	 * @return 
	 */
	ArrayList<Meeting> selectPassMeetingList(String logName);
	
	/**
	 * ͨ��HashMap�����û�����״̬����ѯ��صĻ���
	 * @param info
	 * @return
	 */
	ArrayList<Meeting> selectMeetingInfoList(Map<String, String> info);
	
	/**
	 * ���벿��id���õ��ò���ȫ���Ļ��飬�����ǻ�δ���е�id,������ȫ���Ļ��飬�����Ѿ����е�
	 * @param deptId
	 * @return
	 */
	ArrayList<Meeting> selectMeetingInfoListE(int deptId);
}
