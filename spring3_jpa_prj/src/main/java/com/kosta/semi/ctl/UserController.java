package com.kosta.semi.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosta.semi.entity.UserEntity;
import com.kosta.semi.svc.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/jpa_login")
	//http://localhost:9020/jpa_login?userId=admin&userPw=000
	public String ctlUserLogin(@ModelAttribute UserEntity userEntity,ModelMap model) {
//		UserEntity userEntity = userService.svcUserLogin("admin","000");
		userEntity = userService.svcUserLogin(userEntity.getUserId(), userEntity.getUserPw());
		model.addAttribute("MY_ENTITY", userEntity);
		System.out.println(userEntity.toString());
		return "hello";
	}
	
	@RequestMapping(value="/jpa_list")
	public String ctlUserList(ModelMap model) {
		List<UserEntity> list = userService.svcUserList();
		model.addAttribute("MY_LIST", list);
		System.out.println(list.toString());
		return "hello";
	}
	
	// 둘 중 하나.
//	@RequestMapping(value="/jpa_detail")
//	public String ctlUserDetail(ModelMap model, @RequestParam("userSeq") int useq) {
	@RequestMapping(value="/jpa_detail/{aaa}")
	public String ctlUserDetail(ModelMap model, @PathVariable("aaa") Long userSeq) {
		
		UserEntity entity = userService.svcUserDetail(userSeq);
		model.addAttribute("MY_LIST", entity);
		System.out.println(entity.toString());
		return "hello";
	}
	
	@RequestMapping(value="/jpa_update")
	//http://localhost:9020/jpa_update?userId=admin&userPw=333?userSeq=51
	public String ctlUserUpdate(ModelMap model) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(50L);
		userEntity.setUserId("goo");
		userEntity.setUserPw("777");
		userEntity = userService.svcUserUpdate(userEntity);
		
		System.out.println(userEntity.toString());
		return "hello";
	}
	
	@RequestMapping(value="/jpa_delete/{userSeq}")
	//http://localhost:9020/jpa_delete/{userSeq}
	public String ctlUserDelete(ModelMap model, @PathVariable("userSeq") long userSeq) {		
		userService.svcUserDelete(userSeq);
		return "hello";
	}
	
	
}
