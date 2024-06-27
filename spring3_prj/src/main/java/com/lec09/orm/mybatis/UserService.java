package com.lec09.orm.mybatis;

import java.sql.SQLException;
import java.util.ArrayList;


public interface UserService {
	public int svcUserInsert(UserVO uvo);

	public ArrayList<UserVO> svcUserSelectAll();

	public UserVO svcUserSelectOne(UserVO uvo);
	
	public int svcUserUpdate(UserVO uvo);

	public int svcUserDelete(UserVO uvo);
	
	public void svcInsertRuntimeErrorFunc(UserVO uvo) throws RuntimeException;
	
	public void svcInsertSQLErrorFunc(UserVO uvo) throws SQLException;
}
