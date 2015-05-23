package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.AddRoomMapper;
import com.toy.model.Room;
import com.toy.util.MyFactory;
public class AddRoomService {
	private Room room = null;
	
	public AddRoomService(Room room){
		this.room = room;
	}
	
	public boolean addRoom(){
		// to do something here
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			AddRoomMapper addRoom = session.getMapper(AddRoomMapper.class);
			int reNum = addRoom.insertRoom(room);
			session.commit();
			
			if(reNum != 0){ //有数据返回，说明插入数据成功
				return true;
			}
	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return false;
	}
}
