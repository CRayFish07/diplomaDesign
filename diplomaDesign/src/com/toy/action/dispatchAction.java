package com.toy.action;

import com.opensymphony.xwork2.ActionSupport;

public class dispatchAction extends ActionSupport{
	private String mark;
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	@Override
	public String execute()throws Exception{
		if("deleteEmp".equals(mark)){
			return "deleteEmp";
		}else if("updateEmp".equals(mark)){
			return "updateEmp";
		}else if("addRoom".equals(mark)){
			return "addRoom";
		}else if("deleteRoom".equals(mark)){
			return "deleteRoom";
		}else if("updateRoom".equals(mark)){
			return "updateRoom";
		}else if("addEmp".equals(mark)){
			return "addEmp";
		}else if("addApp".equals(mark)){
			return "addApp";
		}else if("passApp".equals(mark)){
			return "passApp";
		}else if("unPassApp".equals(mark)){
			return "unPassApp";
		}else if("checkApp".equals(mark)){
			return "checkApp";
		}else if("deptMeet".equals(mark)){
			return "deptMeet";
		}else if( "deptMeetOurs".equals(mark)){
			return "deptMeetOurs";
		}else if( "addUserLog".equals(mark) ){
			return "addUserLog";
		}
		return null;
	}
}
