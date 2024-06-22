//package com.lec05.rest;
//
//
//import java.util.ArrayList;
//
//import javax.servlet.RequestDispatcher;
//
//import org.springframework.beans.factory.annotation.Autowired;	// @Autowired -> new 된 DAO 주세요.
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;				// @Controller -> 난 이제부터 controller 이다.
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;	// @ModelAttribute
//import org.springframework.web.bind.annotation.RequestMapping;	// @RequestMapping	-> 밑에주소 
//import org.springframework.web.bind.annotation.RequestMethod;	// @RequestMapping
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//
//
//@Controller
//public class BoardController {
//	@Autowired
//	private BoardDAO boardDAO;
//	
//	@RequestMapping(value = "/board_insert", method=RequestMethod.POST)
//    public String ctlBoardInsert(@ModelAttribute BoardVO bvo){
//		boardDAO.boardInsert(bvo);
//		
//		return "redirect:/board_list";
//	}
//	
//	@RequestMapping(value = "/board_list")
//    public String ctlBoardList(Model model){
//		boardDAO.boardSelect();
//		ArrayList<BoardVO> list = boardDAO.boardSelect();
//		model.addAttribute("KEY_BOARDLIST", list);
//		
//		
//		return "lec05_board/board_list";
//	}
//	
////	@RequestMapping(value = "/board_detail")
////	public ModelAndView ctlBoardDetail(@RequestParam("seq") int seq) {
////
////		ModelAndView mav = new ModelAndView();
////		BoardVO bvo = boardDAO.boardReplySelect(seq);
////		mav.addObject("KEY_BOARDVO", bvo);
////		mav.setViewName("lec05_board/board_detail");
////		
////		
////		return mav;
////	}
//	
//	@RequestMapping(value = "/board_detail")
//	public String ctlBoardDetail(@RequestParam("seq") int seq, Model model) {
//		
//		BoardVO bvo = boardDAO.boardSelectOne(seq);
//		model.addAttribute("KEY_BOARDVO", bvo);
//				
//		return "lec05_board/board_detail";
//	}
//	
//	@RequestMapping(value = "/board_update")
//	public String ctlBoardUpdate(@ModelAttribute BoardVO bvo) {
//		boardDAO.boardUpdate(bvo);
//		
//		return "redirect:/board_list";
//	}
//	
//	@RequestMapping(value = "/board_delete")
//	public String ctlBoardDelete(@RequestParam("seq") int seq) {
//		boardDAO.boardDelete(seq);
//		
//		return "redirect:/board_list";
//	}
//	
//	@RequestMapping(value = "/reply_delete", method=RequestMethod.POST)
//	@ResponseBody
//	public String ctlReplyDelete(@RequestParam int rseq) {
//		int deleteRows = boardDAO.replyDelete(rseq);
//		
//		String msg = "delete 성공";
//		if (deleteRows == 0) {
//			msg = "delete 실패";
//		}
//		
//		return msg;
//	}
//	
//	
//	
//	
//	@RequestMapping(value = "/reply_insert")
//	@ResponseBody
//	public String ctlReplyInsert(@ModelAttribute ReplyVO rvo) {
//		int insertRows = boardDAO.replyInsert(rvo);
//		
//		String msg = "insert 성공";
//		if (insertRows == 0) {
//			msg = "insert 실패";
//		}
//		
//		return msg;
//	}
//	
////	@RequestMapping(value = "/reply_insert")
////	@ResponseBody
////	public ResponseEntity<BoardVO> ctlReplyInsert(@ModelAttribute ReplyVO rvo) {
////		boardDAO.replyInsert(rvo);
////		BoardVO bvo = boardDAO.boardReplySelect(rvo.getSeq());
////		System.out.println(bvo);
////		
////		return new ResponseEntity<> (bvo, HttpStatus.OK);
////	}
//	
//	
//	@RequestMapping(value = "/reply_update")
//	public String ctlReplyUpdate(@ModelAttribute ReplyVO rvo) {
//		boardDAO.replyUpdate(rvo);
//		
//		
//		return "redirect:/board_detail?seq="+rvo.getSeq();
//	}
//	
//	@RequestMapping(value = "/reply_list")
//	@ResponseBody
//	public ResponseEntity<ArrayList<ReplyVO>> ctlReplySelect(@RequestParam("seq") int seq) {
//		ArrayList<ReplyVO> rlist = boardDAO.replySelect(seq);
//			
//		return new ResponseEntity<> (rlist, HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/board_search")
//	@ResponseBody
//	public ResponseEntity<ArrayList<BoardVO>> ctlSearchForRest(@RequestParam("search_str") String search_str) {
//		System.out.println(search_str);
//		
//		ArrayList<BoardVO> list = boardDAO.boardSelectBySearch(search_str);
//			
//		return new ResponseEntity<> (list, HttpStatus.OK);
//	}
//}
