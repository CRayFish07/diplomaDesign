package com.toy.data;

import java.util.Map;
import com.toy.model.Meeting;

public interface AddMeetingMapper {
	/**
	 * ����Meeting Model,�����ݲ������ݿ���
	 * @param meeting
	 * @return �������ݿ��е���Ϣ
	 */
	int insertMeeting(Meeting meeting);
	
	
	/**
	 * ��Application �е�feedback���ĳ� state��ֵ
	 * state��ֵΪ0/1/2/3,ÿ��ֵ�в�ͬ�ĺ���
	 * applicationId ��ֵΪ��Ҫ�޸ĵ���Ŀ��id
	 * @param feedback
	 * @param applicationId
	 * @return ����ֵ���޸ĳɹ�������
	 */
	int updateApplicationState(Map<String, Integer> info);
}