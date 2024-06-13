package com.lec04.di.board;


import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import org.springframework.beans.factory.annotation.Autowired;	// @Autowired -> new 된 DAO 주세요.
import org.springframework.stereotype.Controller;				// @Controller -> 난 이제부터 controller 이다.
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;	// @ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping;	// @RequestMapping	-> 밑에주소 
import org.springframework.web.bind.annotation.RequestMethod;	// @RequestMapping



@Controller
public class BoardController {
	@Autowired
	private BoardDAO boardDAO;
	@RequestMapping(value = "/board_insert", method=RequestMethod.POST)
    public String ctlBoardInsert(@ModelAttribute BoardVO bvo){
		boardDAO.boardInsert(bvo);
		
		return "redirect:/board_list";
	}
	
	@RequestMapping(value = "/board_list")
    public String ctlBoardList(Model model){
		boardDAO.boardSelect();
		ArrayList<BoardVO> list = boardDAO.boardSelect();
		model.addAttribute("KEY_BOARDLIST", list);
		
		
		return "lec04_board/board_list";
	}
}
