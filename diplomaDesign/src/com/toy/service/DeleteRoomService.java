package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.DeleteRoomMapper;
import com.toy.util.MyFactory;

public class DeleteRoomService {
	
	/**
	 * 传入想要删除对象的id，删除与之对应的房间的信息
	 * @param id
	 * @return
	 */
	public boolean deleteRoom(int id){
		SqlSession session = null;
		try{
			SqlSessionFactory sessionFactory = MyFactory.getFactory();
			session = sessionFactory.openSession();
			DeleteRoomMapper deleteRoom = session.getMapper(DeleteRoomMapper.class);
			int reNum = deleteRoom.deleteRoom(id);
			session.commit(); // 提交事务
			
			if(reNum != 0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close(); //关闭会话
		}
		return false;
	}
}
