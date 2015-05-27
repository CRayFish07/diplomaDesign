package com.toy.service;

import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.SelectRoomIdMapper;
import com.toy.model.Room;
import com.toy.util.MyFactory;

public class GetRoomInfoService {
	
	/**
	 * �������κ�ֵ������ȫ����Room��Ϣ����һ��Room����
	 * @return
	 */
	public ArrayList<Room> getRoomList(){
		SqlSession session = null;
		ArrayList<Room> list = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			
			SelectRoomIdMapper roomList = session.getMapper(SelectRoomIdMapper.class);
			list = roomList.selectRoomList();
			
			if(list != null){ //�з���ֵ
				return list;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("��ѯȫ����Ϣ�쳣");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * ���뷿�����ƣ��õ���֮��Ӧ ������Ϣ���˴�ʵ�ֵ���ģ����ѯ
	 * @param id
	 * @return
	 */
	public ArrayList<Room> getRoomList(String name){
		SqlSession session = null;
		ArrayList<Room> list = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			
			SelectRoomIdMapper getRoom = session.getMapper(SelectRoomIdMapper.class);
			list = getRoom.selectSingleRoom("%" + name + "%");
			
			if( list != null){
				return list;
			}	
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ͨ��nameģ����ѯRoom��Ϣ�쳣");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * ���뷿��id���õ���֮���Ӧ�ķ�����Ϣ
	 * @param id
	 * @return
	 */
	public Room getSingleRoom(int id){
		SqlSession session = null;
		Room room = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			
			SelectRoomIdMapper getRoomInfo = session.getMapper(SelectRoomIdMapper.class);
			room = getRoomInfo.selectRoomById(id);
			
			if( room != null){
				return room;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ͨ��id��ѯ����Room�쳣");
		}finally{
			session.close();
		}
		return null;
	}
}
