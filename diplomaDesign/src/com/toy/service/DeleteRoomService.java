package com.toy.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.toy.data.DeleteRoomMapper;
import com.toy.util.MyFactory;

public class DeleteRoomService {
	
	/**
	 * ������Ҫɾ�������id��ɾ����֮��Ӧ�ķ������Ϣ
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
			session.commit(); // �ύ����
			
			if(reNum != 0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close(); //�رջỰ
		}
		return false;
	}
}
