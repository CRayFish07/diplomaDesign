package com.toy.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyFactory {
	public static SqlSessionFactory getFactory(){
		SqlSessionFactory sessionFactory = null;
		String resource = "configuration.xml";
		InputStream inputStream = null;
		try{
			inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e){
			System.out.println("¥¥Ω®sessionFactory ß–ß");
			e.printStackTrace();
		}
		return sessionFactory;
	}
}
