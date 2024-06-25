package com.lec09.orm.mybatis;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
//@Transactional	// DataSourceTXManager를 통한 트랜잭션 관리 대상 : 문제 발생 시 롤백
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;
	
	public int svcUserInsert(UserVO uvo) {
		return userDAO.userInsert(uvo);	
	}

	public ArrayList<UserVO> svcUserSelectAll(){
		return userDAO.userSelectAll();
	}

	public UserVO svcUserSelectOne(UserVO uvo) {
		return userDAO.userSelectOne(uvo);
	}
	
	public int svcUserUpdate(UserVO uvo) {
		return userDAO.userUpdate(uvo);
	}

	public int svcUserDelete(UserVO uvo) {
		return userDAO.userDelete(uvo);
	}



}
