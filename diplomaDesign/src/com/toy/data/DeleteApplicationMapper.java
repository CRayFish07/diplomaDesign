package com.toy.data;

public interface DeleteApplicationMapper {
	
	/**
	 * 传入id，删除与之对应的Application值
	 * @param id
	 * @return
	 */
	public int deleteApplicationById(int id);
}
