package com.toy.model;

public class Application {
	private int application_id;
	private String application_start;
	private String application_end;
	private String application_remarks;
	private String application_time;
	private int feedback;
	private String log_name;
	
	//setter && getter
	public int getApplication_id() {
		return application_id;
	}
	public void setApplication_id(int applicationId) {
		application_id = applicationId;
	}
	public String getApplication_start() {
		return application_start;
	}
	public void setApplication_start(String applicationStart) {
		application_start = applicationStart;
	}
	public String getApplication_end() {
		return application_end;
	}
	public void setApplication_end(String applicationEnd) {
		application_end = applicationEnd;
	}
	public String getApplication_remarks() {
		return application_remarks;
	}
	public void setApplication_remarks(String applicationRemarks) {
		application_remarks = applicationRemarks;
	}
	public String getApplication_time() {
		return application_time;
	}
	public void setApplication_time(String applicationTime) {
		application_time = applicationTime;
	}
	public int getFeedback() {
		return feedback;
	}
	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}
	public String getLog_name() {
		return log_name;
	}
	public void setLog_name(String logName) {
		log_name = logName;
	}
	
	
	
}
