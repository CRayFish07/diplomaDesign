package com.toy.data;

import java.util.ArrayList;
import com.toy.model.Meeting;

public interface SelectMeetingInfoMapper {
	/**
	 * ���뷿���id���õ����Ǹ÷�������Ļ�û�о��еĻ����ԤԼ����
	 * @param id
	 * @return
	 */
	ArrayList<Meeting> selectMeetingList(int id);
	
	/**
	 * �������������˵��û��������ظ��û��������ͨ���ļ�¼
	 * @param logName
	 * @return 
	 */
	ArrayList<Meeting> selectPassMeetingList(String logName);
}
