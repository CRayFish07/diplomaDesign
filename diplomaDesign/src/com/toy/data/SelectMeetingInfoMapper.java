package com.toy.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.toy.model.Meeting;

public interface SelectMeetingInfoMapper {
	/**
	 * 传入房间的id，得到的是该房间里面的还没有举行的会议的预约数量
	 * @param id
	 * @return
	 */
	ArrayList<Meeting> selectMeetingList(int id);
	
	/**
	 * 传入申请会议的人的用户名，返回该用户申请会议通过的记录
	 * @param logName
	 * @return 
	 */
	ArrayList<Meeting> selectPassMeetingList(String logName);
	
	/**
	 * 通过HashMap传入用户名和状态，查询相关的会议
	 * @param info
	 * @return
	 */
	ArrayList<Meeting> selectMeeingInfoList(Map<String, String> info);
}
