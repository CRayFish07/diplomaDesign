package com.toy.model;

public class Meeting {
	private int meeting_id;
	private int meeting_room_id;
	private String meeting_name;
	private String log_name;
	private String meeting_start;
	private String meeting_end;
	private String meeting_order_time;
	private short meeting_mark; //此处定义为shortl类型，不知道和mysql数据库中的TINYINT一样不？

	// getter && setter
	public int getMeeting_id() {
		return meeting_id;
	}
	public void setMeeting_id(int meetingId) {
		meeting_id = meetingId;
	}
	public int getMeeting_room_id() {
		return meeting_room_id;
	}
	public void setMeeting_room_id(int meetingRoomId) {
		meeting_room_id = meetingRoomId;
	}
	public String getMeeting_start() {
		return meeting_start;
	}
	public void setMeeting_start(String meetingStart) {
		meeting_start = meetingStart;
	}
	public String getMeeting_end() {
		return meeting_end;
	}
	public void setMeeting_end(String meetingEnd) {
		meeting_end = meetingEnd;
	}
	public String getMeeting_order_time() {
		return meeting_order_time;
	}
	public void setMeeting_order_time(String meetingOrderTime) {
		meeting_order_time = meetingOrderTime;
	}
	public short getMeeting_mark() {
		return meeting_mark;
	}
	public void setMeeting_mark(short meetingMark) {
		meeting_mark = meetingMark;
	}
	public String getLog_name() {
		return log_name;
	}
	public void setLog_name(String logName) {
		log_name = logName;
	}
	public String getMeeting_name() {
		return meeting_name;
	}
	public void setMeeting_name(String meetingName) {
		meeting_name = meetingName;
	}
		
}
