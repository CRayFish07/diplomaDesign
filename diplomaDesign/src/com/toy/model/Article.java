package com.toy.model;

public class Article {
	private int arti_id;
	private String arti_name;
	private int arti_num;
	private String proposer_name;
	private String proposer_time;
	private String proposer_remarks;
	private int arti_meeting_id;
	
	//getter && setter
	public int getArti_id() {
		return arti_id;
	}
	public void setArti_id(int artiId) {
		arti_id = artiId;
	}
	public String getArti_name() {
		return arti_name;
	}
	public void setArti_name(String artiName) {
		arti_name = artiName;
	}
	public int getArti_num() {
		return arti_num;
	}
	public void setArti_num(int artiNum) {
		arti_num = artiNum;
	}
	public String getProposer_name() {
		return proposer_name;
	}
	public void setProposer_name(String proposerName) {
		proposer_name = proposerName;
	}
	public String getProposer_time() {
		return proposer_time;
	}
	public void setProposer_time(String proposerTime) {
		proposer_time = proposerTime;
	}
	public String getProposer_remarks() {
		return proposer_remarks;
	}
	public void setProposer_remarks(String proposerRemarks) {
		proposer_remarks = proposerRemarks;
	}
	public int getArti_meeting_id() {
		return arti_meeting_id;
	}
	public void setArti_meeting_id(int artiMeetingId) {
		arti_meeting_id = artiMeetingId;
	}
	
	

}
