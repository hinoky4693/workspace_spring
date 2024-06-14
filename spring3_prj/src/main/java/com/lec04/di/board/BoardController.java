package com.lec04.di.board;


import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import org.springframework.beans.factory.annotation.Autowired;	// @Autowired -> new 된 DAO 주세요.
import org.springframework.stereotype.Controller;				// @Controller -> 난 이제부터 controller 이다.
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;	// @ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping;	// @RequestMapping	-> 밑에주소 
import org.springframework.web.bind.annotation.RequestMethod;	// @RequestMapping
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



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
	
//	@RequestMapping(value = "/board_detail")
//	public ModelAndView ctlBoardDetail(@RequestParam("seq") int seq) {
//
//		ModelAndView mav = new ModelAndView();
//		BoardVO bvo = boardDAO.boardReplySelect(seq);
//		mav.addObject("KEY_BOARDVO", bvo);
//		mav.setViewName("lec04_board/board_detail");
//		
//		
//		return mav;
//	}
	
	@RequestMapping(value = "/board_detail")
	public String ctlBoardDetail(@RequestParam("seq") int seq, Model model) {

		BoardVO bvo = boardDAO.boardReplySelect(seq);
		model.addAttribute("KEY_BOARDVO", bvo);		
		
		
		return "lec04_board/board_detail";
	}
	
	@RequestMapping(value = "/board_update")
	public String ctlBoardUpdate(@ModelAttribute BoardVO bvo) {
		boardDAO.boardUpdate(bvo);
		
		return "redirect:/board_list";
	}
	
	@RequestMapping(value = "/board_delete")
	public String ctlBoardDelete(@RequestParam("seq") int seq) {
		boardDAO.boardDelete(seq);
		
		return "redirect:/board_list";
	}
	
	@RequestMapping(value = "/reply_delete")
	public String ctlReplyDelete(@ModelAttribute ReplyVO rvo, Model model) {
		boardDAO.replyDelete(rvo.getRseq());
		
		return "redirect:/board_detail?seq="+rvo.getSeq();
	}
	
	@RequestMapping(value = "/reply_insert")
	public String ctlReplyInsert(@ModelAttribute ReplyVO rvo) {
		boardDAO.replyInsert(rvo);
		
		
		return "redirect:/board_detail?seq="+rvo.getSeq();
	}
	
	@RequestMapping(value = "/reply_update")
	public String ctlReplyUpdate(@ModelAttribute ReplyVO rvo) {
		boardDAO.replyUpdate(rvo);
		
		
		return "redirect:/board_detail?seq="+rvo.getSeq();
	}
}
