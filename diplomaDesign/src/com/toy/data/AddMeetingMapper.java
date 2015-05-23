package com.toy.data;

import java.util.Map;
import com.toy.model.Meeting;

public interface AddMeetingMapper {
	/**
	 * 传入Meeting Model,将数据插入数据库中
	 * @param meeting
	 * @return 插入数据库中的信息
	 */
	int insertMeeting(Meeting meeting);
	
	
	/**
	 * 将Application 中的feedback更改成 state的值
	 * state的值为0/1/2/3,每个值有不同的含义
	 * applicationId 的值为需要修改的条目的id
	 * @param feedback
	 * @param applicationId
	 * @return 返回值是修改成功的数量
	 */
	int updateApplicationState(Map<String, Integer> info);
}