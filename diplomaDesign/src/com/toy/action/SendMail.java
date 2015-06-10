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
	//������������
	private String theme;			//�ʼ�����
	private String meetingStart;	//��ʼʱ��
	private String meetingEnd;		//����ʱ��
	private String applicationTime; //����ʱ��
	private String launcher;		//������
	private String roomId;			//����id
	private int deptId;				//����id
	private int id;					//�����Ϣ�Լ���id
	private String tarList;			//������Ҫ���͸����û�����
	
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
	 * ��дexecute����
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
	 * �Ѽ���Ϣ���Զ�����Email���͸���Ӧ����Ա
	 * @return
	 */
	public String colectInfoToEmail(){
		String message = "����: \r\n" + "���ǲ����� " + this.meetingStart + "��" + this.meetingEnd + "��һ������ \"" + this.theme + "\" ����Ļ��飬ϣ�����ܹ�׼ʱ�μ�\r\n                                                   ֪ͨ�ˣ�" + this.launcher;

		return message;
	}
	
	/**
	 * ������Ϣ���͵ķ���
	 * @return
	 */
	public boolean sendMeassage(String Msg){
		Properties props = new Properties();  
        props.setProperty("mail.smtp.host", "smtp.163.com");  
        // ��������������  
        props.setProperty("mail.smtp.auth", "true");  
        props.setProperty("mail.debug", "true");  
  
        // Session������stmp��������Ϣ  
        Session session = Session.getDefaultInstance(props, new Authenticator(){  
            protected PasswordAuthentication getPasswordAuthentication(){  
                return new PasswordAuthentication("tanoya321@163.com","txy+8335");  
            }  
        });
          
        MimeMessage  msg = new MimeMessage(session);  
        try {  
            msg.setFrom(new InternetAddress("tanoya321@163.com"));
            msg.addRecipients(Message.RecipientType.TO, this.tarList);
            msg.setSubject(this.theme, "UTF-8");    //����ʼ��ı���
            msg.setSentDate(new Date());  
            msg.setText(Msg, "UTF-8");  			//����ʼ����塢����
          
            // ʹ�þ�̬�ķ���������Ϣ  
            //Transport.send(msg,new InternetAddress[]{new InternetAddress("lianyumoshen@sina.com")});  
            
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        } 
		return true;
	}
}
