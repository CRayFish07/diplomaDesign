package com.toy.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.toy.model.Application;
import com.toy.service.GetApplicationInfoService;

public class SelectApplicationAction extends ActionSupport{
	//��Ҫ��ѯ��״̬
	private int status;
	//���ڲ�ѯʹ�õ�ʱ��
	private String time;
	
	//���ڷ��ز�ѯ������δͨ����״̬��Ϣ��
	private ArrayList<Application> applicationList;
	
	//	getter && setter
	public String getTime(){
		return this.time;
	}
	public void setTime(String time){
		this.time = time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}	
	public ArrayList<Application> getApplicationList() {
		return applicationList;
	}
	public void setApplicationList(ArrayList<Application> applicationList) {
		this.applicationList = applicationList;
	}

	@Override
	public String execute() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String logName = (String)session.getAttribute("name");
		
		GetApplicationInfoService service = new GetApplicationInfoService();
		ArrayList<Application> temp = service.getApplicationInfoList(0, logName);
		
//		System.out.println("���ص�����" + temp.get(0).getApplication_remarks() + "userName:" + logName + " " + status );
//		System.out.println( temp );
		if( temp != null ){
			this.setApplicationList(temp);
			return "success";
		}
		return "error";
	}
	
	/**
	 * ͨ������ʱ�������в�ѯ��ʱ���֮������룬�����ݿյ�ʱ��������ѯȫ��δ���������
	 * @param time
	 * @return
	 */
	public String checkApplicationByTime(){
		
		GetApplicationInfoService getApplication = new GetApplicationInfoService();
		ArrayList<Application> infoList = null;
		if( "".equals(this.time) ){

//			System.out.println("test1");  //��������
			infoList = getApplication.getApplicationAll();
			if( infoList != null ){
				this.setApplicationList(infoList);
				return "ManagerApp";
			}
		}else{
			//���ʱ�䣬�������ﴦ������
			
		}
		return "ManagerError";
	}
}
