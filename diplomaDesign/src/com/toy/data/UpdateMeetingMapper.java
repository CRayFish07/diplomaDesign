package com.toy.data;

public interface UpdateMeetingMapper {
	/**
	 * 传入id，修改对应id的一个，修改Meeing表，修改为取消状态
	 * @param id
	 * @return
	 */
	int updateMeetingCancel(int id);
	
	/**
	 * 传入数据id，修改对应的信息，让该数据的状态变为已经举行状态
	 * @param id
	 * @return
	 */
	int updateMeetingTaken(int id);
}
