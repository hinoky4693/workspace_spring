package com.kosta.semi.ctl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
import org.springframework.web.multipart.MultipartFile;

import com.kosta.semi.svc.BoardService;
import com.kosta.semi.vo.BoardVO;
import com.kosta.semi.vo.FileVO;
import com.kosta.semi.vo.ReplyVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	
	@RequestMapping(value="/board_list")
	public String ctlBoardSelect(Model model){
		ArrayList<BoardVO> blist = boardService.svcBoardSelectList();
		model.addAttribute("KEY_BOARDLIST", blist);
		return "/board/board_list";
	}
	
	@RequestMapping(value="/board_insert")
	public String ctlBoardInsert(@RequestParam("ufiles") List<MultipartFile> files, @ModelAttribute BoardVO bvo) {
		ArrayList<FileVO> flist = new ArrayList<FileVO>();
		System.out.println(files.toString()+"======================================");
			if(files.isEmpty() == true) {
				for(MultipartFile file : files) {
					FileVO fvo = new FileVO();
					String uploadFolder = "C:\\KOSTA\\S3917_J11\\workspace_sts3\\uploads";
					String uniqueName	= UUID.randomUUID().toString().split("-")[0];
					String fileRealName = file.getOriginalFilename();
					String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
					String filePath = uploadFolder + "\\" + uniqueName + fileExtension;

					fvo.setOname(file.getOriginalFilename());
					fvo.setFsize(file.getSize());
					fvo.setSname(uniqueName);
					fvo.setFpath(filePath);
					System.out.println(fvo.toString());

					try {
						file.transferTo(new File(filePath));
						flist.add(fvo);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		boardService.svcBoardInsert(bvo, flist);
		return "redirect:/board_list";
	}
	
	@RequestMapping(value="/reply_insert")
	@ResponseBody
	public String ctlReplyInsert(@ModelAttribute ReplyVO rvo) {
		boardService.svcReplyInsert(rvo);

		return null;
	}
	
	@RequestMapping(value="/board_update")
	public String ctlBoardUpdate(@ModelAttribute BoardVO bvo) {
		boardService.svcBoardUpdate(bvo);
		return "redirect:/board_list";
	}
	
	@RequestMapping(value="/board_delete")
	public String ctlBoardDelete(@RequestParam int seq) {
		boardService.svcBoardDelete(seq);
		return "redirect:/board_list";
	}
	
	@RequestMapping(value="/reply_delete")
	@ResponseBody
	public String ctlReplyDelete(@RequestParam int rseq) {
		boardService.svcReplyDelete(rseq);
		return null;
	}
	
	@RequestMapping(value="/reply_update")
	public String ctlReplyUpdate(@ModelAttribute ReplyVO rvo) {
		boardService.svcReplyUpdate(rvo);
		return "redirect:/reply_list";
	}
	
	@RequestMapping(value="/board_detail")
	public String ctlBoardSelectOne(@RequestParam int seq, Model model) {
		BoardVO bvo = boardService.svcBoardSelectOne(seq);
		model.addAttribute("KEY_BOARDVO", bvo);
		
		return "/board/board_detail";
	}
	
	@RequestMapping(value="/reply_list")
	@ResponseBody
	public ResponseEntity<ArrayList<ReplyVO>> ctlReplySelect(@RequestParam int seq, Model model){
		ArrayList<ReplyVO> rlist = boardService.svcReplySelect(seq);
		model.addAttribute("KEY_REPLYLIST", rlist);
		
		return new ResponseEntity<ArrayList<ReplyVO>> (rlist,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/board_search")
	@ResponseBody
	public ResponseEntity<ArrayList<BoardVO>> ctlSearchForRest(@RequestParam("search_str") String searchStr) {
		searchStr = "%"+searchStr+"%";
		System.out.println(searchStr);
		ArrayList<BoardVO> list = boardService.svcSearchForRest(searchStr);
			
		return new ResponseEntity<ArrayList<BoardVO>> (list, HttpStatus.OK);
	}
	
	
}
