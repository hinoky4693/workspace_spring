package com.lec09.orm.mybatis;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user_insert")
	public String ctlUserInsert(@ModelAttribute UserVO uvo){
		int insertRows = userService.svcUserInsert(uvo);
		
		return "hello";
	}
	@RequestMapping(value="/user_list")
	public String ctlUserSelectAll(Model model){
		ArrayList<UserVO> ulist = userService.svcUserSelectAll();
		model.addAttribute("KEY_USERLIST", ulist);
		
		return "hello";
	}
	@RequestMapping(value="/user_detail")
	public String svcUserSelectOne(@ModelAttribute UserVO uvo, Model model) {
		uvo = userService.svcUserSelectOne(uvo);
		model.addAttribute("KEY_USERVO", uvo);
		
		return "hello";
	}
	@RequestMapping(value="/user_update")
	public String svcUserUpdate(@ModelAttribute UserVO uvo) {
		int updateRows = userService.svcUserUpdate(uvo);
		return "hello";
	}
	@RequestMapping(value="/user_delete")
	public String svcUserDelete(@ModelAttribute UserVO uvo) {
		int deleteRows = userService.svcUserDelete(uvo);
		return "hello";
	}
	
}
