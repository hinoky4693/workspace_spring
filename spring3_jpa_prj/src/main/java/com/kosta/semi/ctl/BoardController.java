package com.kosta.semi.ctl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosta.semi.entity.BoardEntity;
import com.kosta.semi.entity.ReplyEntity;
import com.kosta.semi.svc.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	
	@RequestMapping(value="/board_list")
	public String ctlBoardSelect(Model model){
		List<BoardEntity> blist = boardService.svcBoardSelectList();
		model.addAttribute("KEY_BOARDLIST", blist);
		return "/board/board_list";
	}
	
	@RequestMapping(value="/board_insert")
	public String ctlBoardInsert(@ModelAttribute BoardEntity bvo) {
		boardService.svcBoardInsert(bvo);
		
		return "redirect:/board_list";
	}
	
	@RequestMapping(value="/reply_insert")
	@ResponseBody
	public String ctlReplyInsert(@ModelAttribute ReplyEntity rvo) {
		boardService.svcReplyInsert(rvo);

		return null;
	}
	
	@RequestMapping(value="/board_update")
	public String ctlBoardUpdate(@ModelAttribute BoardEntity bvo) {
		boardService.svcBoardUpdate(bvo);
		return "redirect:/board_list";
	}
	
	@RequestMapping(value="/board_delete")
	public String ctlBoardDelete(@RequestParam Long seq) {
		boardService.svcBoardDelete(seq);
		return "redirect:/board_list";
	}
	
	@RequestMapping(value="/reply_delete")
	@ResponseBody
	public String ctlReplyDelete(@RequestParam Long rseq) {
		boardService.svcReplyDelete(rseq);
		return null;
	}
	
	@RequestMapping(value="/reply_update")
	public String ctlReplyUpdate(@ModelAttribute ReplyEntity rvo) {
		boardService.svcReplyUpdate(rvo);
		return "redirect:/reply_list";
	}
	
	@RequestMapping(value="/board_detail")
	public String ctlBoardSelectOne(@RequestParam Long seq, Model model) {
		BoardEntity bvo = boardService.svcBoardSelectOne(seq);
		model.addAttribute("KEY_BOARDVO", bvo);
		
		return "/board/board_detail";
	}
	
	@RequestMapping(value="/reply_list")
	@ResponseBody
	public ResponseEntity<List<ReplyEntity>> ctlReplySelect(@RequestParam Long seq, Model model){
//		List<ReplyEntity> rlist = boardService.svcReplySelect(seq);
		List<ReplyEntity> rlist = new ArrayList<ReplyEntity>();
		
		model.addAttribute("KEY_REPLYLIST", rlist);
		
		return new ResponseEntity<List<ReplyEntity>> (rlist,HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/board_search")
//	@ResponseBody
//	public ResponseEntity<ArrayList<BoardEntity>> ctlSearchForRest(@RequestParam("search_str") String searchStr) {
//		searchStr = "%"+searchStr+"%";
//		System.out.println(searchStr);
//		ArrayList<BoardEntity> list = boardService.svcSearchForRest(searchStr);
//			
//		return new ResponseEntity<ArrayList<BoardEntity>> (list, HttpStatus.OK);
//	}
	
	
}
