package com.toy.data;

public interface UpdateMeetingMapper {
	/**
	 * ����id���޸Ķ�Ӧid��һ�����޸�Meeing���޸�Ϊȡ��״̬
	 * @param id
	 * @return
	 */
	int updateMeetingCancel(int id);
	
	/**
	 * ��������id���޸Ķ�Ӧ����Ϣ���ø����ݵ�״̬��Ϊ�Ѿ�����״̬
	 * @param id
	 * @return
	 */
	int updateMeetingTaken(int id);
}
