package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.UpdateRoomMapper;
import com.toy.model.Room;
import com.toy.util.MyFactory;

public class UpdateRoomService {
	
	public boolean updateRoom(Room room){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			UpdateRoomMapper updateRoom = session.getMapper(UpdateRoomMapper.class);
			int reNum = updateRoom.updateRoom(room);
			session.commit();
			
			if( reNum != 0 ){
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
