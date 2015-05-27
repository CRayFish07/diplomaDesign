package com.toy.service;

import java.util.ArrayList;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.SelectRoomIdMapper;
import com.toy.model.Room;
import com.toy.util.MyFactory;

public class GetRoomInfoService {
	
	/**
	 * 不传入任何值，返回全部的Room信息，是一个Room数组
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
			
			if(list != null){ //有返回值
				return list;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("查询全部信息异常");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * 传入房间名称，得到与之对应 房间信息，此处实现的是模糊查询
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
			System.out.println("通过name模糊查询Room信息异常");
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * 传入房间id，得到与之相对应的房间信息
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
			System.out.println("通过id查询单个Room异常");
		}finally{
			session.close();
		}
		return null;
	}
}
