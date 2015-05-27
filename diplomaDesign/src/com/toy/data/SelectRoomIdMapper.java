package com.toy.data;

import java.util.ArrayList;
import com.toy.model.Room;

public interface SelectRoomIdMapper {
	/**
	 *  �����еķ���ŵ�idȡ������װ����������ȥ
	 */
	ArrayList<Room> selectRoomIdList();
	
	/**
	 * ��ȫ���ķ�����Ϣȡ������װ��������
	 * @return
	 */
	ArrayList<Room> selectRoomList();
	
	/**
	 *  ������������ַ������Ӧ�ķ��䣬���ظ÷����ȫ����Ϣ
	 * @param id
	 * @return
	 */
	ArrayList<Room> selectSingleRoom(String name);
	
	/**
	 * ����id��������֮��Ӧ�ĵ���Room��Ϣ
	 * @param id
	 * @return
	 */
	Room selectRoomById(int id);
}
