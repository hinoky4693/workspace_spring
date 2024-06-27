package com.lec09.orm.mybatis.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.lec09.orm.mybatis.UserVO;

@Mapper
@Repository
public interface UserMapper {
	public int userInsert(UserVO uvo);
	public ArrayList<UserVO> allUser();
	public UserVO login(UserVO uvo);
	public int userUpdate(UserVO uvo);
	public int userDelete(UserVO uvo);
}
