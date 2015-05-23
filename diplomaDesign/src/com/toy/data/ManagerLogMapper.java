package com.toy.data;

//import java.util.HashMap;

public interface ManagerLogMapper {
	// Select("select password from Manager where name=#{name}")
	String selectPassword(String name);
}
