package com.lec08.dao;

import com.lec09.orm.mybatis.UserVO;

public class LombokCallTest {

	public static void main(String[] args) {
		UserVO uvo = new UserVO();
		uvo.setUserName("아무개");
		
		String name = uvo.getUserName();
		System.out.println(name);
	}

}
