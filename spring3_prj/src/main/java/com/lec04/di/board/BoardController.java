package com.lec04.di.board;


import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import org.springframework.beans.factory.annotation.Autowired;	// @Autowired -> new 된 DAO 주세요.
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;				// @Controller -> 난 이제부터 controller 이다.
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;	// @ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping;	// @RequestMapping	-> 밑에주소 
import org.springframework.web.bind.annotation.RequestMethod;	// @RequestMapping
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class BoardController {
	@Autowired
//	private BoardDAO boardDAO;
	private BoardService boardService; // 부모타입_인터페이스 = new 자식클래스(); 다형성
	
	@RequestMapping(value = "/board_insert", method=RequestMethod.POST)
    public String ctlBoardInsert(@ModelAttribute BoardVO bvo, Model model){
		int insertRows = boardService.svcBoardInsert(bvo);
		
		return "redirect:/board_list";
	}
	
	@RequestMapping(value = "/board_list")
    public String ctlBoardList(Model model){
		ArrayList<BoardVO> list = boardService.svcBoardList();
		model.addAttribute("KEY_BOARDLIST", list);
		
		
		return "lec04_board/board_list";
	}
	
	@RequestMapping(value = "/board_detail")
	public String ctlBoardDetail(@RequestParam("seq") int seq, Model model) {
		Map<String, Object> map = boardService.svcBoardDetail(seq);
		model.addAttribute("KEY_BOARDVO", (BoardVO)map.get("my_bvo"));
		model.addAttribute("KEY_REPLYLIST", (ArrayList<ReplyVO>)map.get("my_rlist"));
		
		return "lec04_board/board_detail";
	}
	
	@RequestMapping(value = "/board_update")
	public String ctlBoardUpdate(@ModelAttribute BoardVO bvo, Model model) {
		boardService.svcBoardUpdate(bvo);
		
		return "redirect:/board_list";
	}
	
	@RequestMapping(value = "/board_delete")
	public String ctlBoardDelete(@RequestParam("seq") int seq, Model model) {
		boardService.svcBoardDelete(seq);
		
		return "redirect:/board_list";
	}
	
	@RequestMapping(value = "/reply_delete")
	public String ctlReplyDelete(@ModelAttribute ReplyVO rvo, Model model) {
		boardService.svcReplyDelete(rvo);
		
		return "redirect:/board_detail?seq="+rvo.getSeq();
	}
	
	@RequestMapping(value = "/reply_insert")
	public String ctlReplyInsert(@ModelAttribute ReplyVO rvo, Model model) {
		boardService.svcReplyInsert(rvo);
		
		return "redirect:/board_detail?seq="+rvo.getSeq();
	}
	
	
	@RequestMapping(value = "/reply_update")
	public String ctlReplyUpdate(@ModelAttribute ReplyVO rvo, Model model) {
		boardService.svcReplyUpdate(rvo);
		
		
		return "redirect:/board_detail?seq="+rvo.getSeq();
	}
}
