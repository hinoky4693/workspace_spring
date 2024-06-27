package com.lec09.orm.mybatis;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec09.orm.mybatis.mapper.UserMapper;



@Service
//@Transactional	// DataSourceTXManager를 통한 트랜잭션 관리 대상 : 문제 발생 시 롤백
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	
	
	
	@Transactional
	public int svcUserInsert(UserVO uvo) {
		return userMapper.userInsert(uvo);	
	}

	public ArrayList<UserVO> svcUserSelectAll(){
		return userMapper.allUser();
	}

	public UserVO svcUserSelectOne(UserVO uvo) {
		return userMapper.login(uvo);
	}
	
	public int svcUserUpdate(UserVO uvo) {
		return userMapper.userUpdate(uvo);
	}

	public int svcUserDelete(UserVO uvo) {
		return userMapper.userDelete(uvo);
	}
	
	//TX rollback test용
		//3건의 insert 중 에러 발생 시 TX에 의해 모두 rollback 처리됨
	public void svcInsertRuntimeErrorFunc(UserVO uvo) throws RuntimeException {
		userMapper.userInsert(uvo);
		userMapper.userInsert(uvo);
		System.err.println("----------------- 모두 롤백처리 됨 ----------------");
		throw new RuntimeException("RuntimeException(Unchecked Exception) -- UserServiceImpl.svcInsertRuntimeErrorFunc() 강제 에러 발생");
	}

	public void svcInsertSQLErrorFunc(UserVO uvo) throws SQLException {
		userMapper.userInsert(uvo);
		userMapper.userInsert(uvo);
		System.err.println("----------------- 모두 롤백처리 됨 ----------------");
		throw new SQLException("SQLException(Checked Exception) -- UserServiceImpl.svcInsertSQLErrorFunc() 강제 에러 발생");

	}




}
