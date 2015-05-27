package com.toy.data;

import java.util.ArrayList;
import com.toy.model.Room;

public interface SelectRoomIdMapper {
	/**
	 *  将所有的房间号的id取出，封装到数组里面去
	 */
	ArrayList<Room> selectRoomIdList();
	
	/**
	 * 将全部的房间信息取出，封装到数组中
	 * @return
	 */
	ArrayList<Room> selectRoomList();
	
	/**
	 *  传入包含传入字符串相对应的房间，返回该房间的全部信息
	 * @param id
	 * @return
	 */
	ArrayList<Room> selectSingleRoom(String name);
	
	/**
	 * 传入id，返回与之对应的单条Room信息
	 * @param id
	 * @return
	 */
	Room selectRoomById(int id);
}
