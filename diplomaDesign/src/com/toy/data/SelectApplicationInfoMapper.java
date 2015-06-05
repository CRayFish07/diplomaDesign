package com.toy.data;

import java.util.ArrayList;
import java.util.Map;
import com.toy.model.Application;

public interface SelectApplicationInfoMapper {
	/**
	 * 传入要查询 申请信息的id，得到该id标记的一条信息
	 * @param id
	 * @return
	 */
	Application selectOneApplicationInfo(int id);
	
	/**
	 * 传入需要查询的状态，和自己的用户名，得到自己的数据链表
	 * Map中的参数，state：表示需要查询的状态。
	 * 				logName:表示是关于当前用户的信息
	 * @param info
	 * @return 符合条件的结果集
	 */
	ArrayList<Application> selectApplicationInfoList(Map<String, Object> info);
	
	/**
	 * 在总经理页面，查询传入的时间段之后的申请信息
	 * @param Time
	 * @return
	 */
	ArrayList<Application> selectApplicationByTime(String time);
	
	/**
	 * 在总经理页面，不传入任何信息，返回所有符合条件的信息，即没有处理的信息
	 * @return
	 */
	ArrayList<Application> selectApplicationAll();
}
