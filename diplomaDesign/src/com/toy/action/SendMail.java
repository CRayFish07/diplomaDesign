package com.toy.action;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.opensymphony.xwork2.ActionSupport;

public class SendMail extends ActionSupport{
	//定义数据类型
	private String theme;			//邮件标题
	private String meetingStart;	//开始时间
	private String meetingEnd;		//结束时间
	private String applicationTime; //申请时间
	private String launcher;		//申请人
	private String roomId;			//房间id
	private int deptId;				//部门id
	private int id;					//这个信息自己的id
	private String tarList;			//这是需要发送给的用户名单
	
	//getter && setter
	public String getTheme() {   
		return theme;
	}
	public void setTheme(String theme) {	
		this.theme = theme;
	}
	public String getMeetingStart() {
		return meetingStart;
	}
	public void setMeetingStart(String meetingStart) {
		this.meetingStart = meetingStart;
	}
	public String getMeetingEnd() {
		return meetingEnd;
	}
	public void setMeetingEnd(String meetingEnd) {
		this.meetingEnd = meetingEnd;
	}
	public String getApplicationTime() {
		return applicationTime;
	}
	public void setApplicationTime(String applicationTime) {
		this.applicationTime = applicationTime;
	}
	public String getLauncher() {
		return launcher;
	}
	public void setLauncher(String launcher) {
		this.launcher = launcher;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTarList() {
		return tarList;
	}
	public void setTarList(String tarList) {
		this.tarList = tarList;
	}
	
	
	/**
	 * 重写execute方法
	 */
	@Override
	public String execute() throws Exception{
		String temp = this.colectInfoToEmail();
		
		if( this.sendMeassage(temp) ){
			return "sendSuccess";
		}else{
			return "sendErr";
		}
	}
	
	/** 
	 * 搜集信息，自动生成Email传送给相应的人员
	 * @return
	 */
	public String colectInfoToEmail(){
		String message = "您好: \r\n" + "我们部门在 " + this.meetingStart + "到" + this.meetingEnd + "有一个关于 \"" + this.theme + "\" 主题的会议，希望您能够准时参加\r\n                                                   通知人：" + this.launcher;

		return message;
	}
	
	/**
	 * 用于信息发送的方法
	 * @return
	 */
	public boolean sendMeassage(String Msg){
		Properties props = new Properties();  
        props.setProperty("mail.smtp.host", "smtp.163.com");  
        // 必须有这项设置  
        props.setProperty("mail.smtp.auth", "true");  
        props.setProperty("mail.debug", "true");  
  
        // Session管理与stmp的链接信息  
        Session session = Session.getDefaultInstance(props, new Authenticator(){  
            protected PasswordAuthentication getPasswordAuthentication(){  
                return new PasswordAuthentication("tanoya321@163.com","txy+8335");  
            }  
        });
          
        MimeMessage  msg = new MimeMessage(session);  
        try {  
            msg.setFrom(new InternetAddress("tanoya321@163.com"));
            msg.addRecipients(Message.RecipientType.TO, this.tarList);
            msg.setSubject(this.theme, "UTF-8");    //添加邮件的标题
            msg.setSentDate(new Date());  
            msg.setText(Msg, "UTF-8");  			//添加邮件的体、内容
          
            // 使用静态的方法发送信息  
            //Transport.send(msg,new InternetAddress[]{new InternetAddress("lianyumoshen@sina.com")});  
            
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        } 
		return true;
	}
}
