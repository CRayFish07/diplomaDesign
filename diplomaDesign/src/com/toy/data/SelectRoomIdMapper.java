package com.toy.data;

import java.util.ArrayList;
import com.toy.model.Room;

public interface SelectRoomIdMapper {
	/**
	 *  将所有的房间号的id取出，封装到数组里面去
	 */
	ArrayList<Room> selectRoomIdList();
}
