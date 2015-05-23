package com.toy.model;

public class Message {
	private int message_id;
	private String message_information;
	private int message_emp_id;
	
	//getter && setter
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int messageId) {
		message_id = messageId;
	}
	public String getMessage_information() {
		return message_information;
	}
	public void setMessage_information(String messageInformation) {
		message_information = messageInformation;
	}
	public int getMessage_emp_id() {
		return message_emp_id;
	}
	public void setMessage_emp_id(int messageEmpId) {
		message_emp_id = messageEmpId;
	}
}
