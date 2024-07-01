package com.lec11.orm.jpa;

import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;

import com.lec11.orm.jpa.entity.UserEntity;

public interface UserService {	
	public UserEntity svcUserLogin(String userId, String userPw);
	public List<UserEntity> svcUserList();
	public UserEntity svcUserDetail(Long userSeq);
	public UserEntity svcUserUpdate(UserEntity userEntity);
	public void svcUserDelete(Long userSeq);

	
}
