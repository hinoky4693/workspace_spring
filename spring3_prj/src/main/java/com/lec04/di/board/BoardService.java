package com.lec04.di.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

public interface BoardService {
	public int svcBoardInsert(BoardVO bvo);
		
	public ArrayList<BoardVO> svcBoardList();
	
	public Map<String, Object> svcBoardDetail(int seq);
	
	public int svcBoardUpdate(BoardVO bvo);
	
	public int svcBoardDelete(int seq);
	
	public int svcReplyDelete(ReplyVO rvo);
	
	public int svcReplyInsert(ReplyVO rvo);
	
	public int svcReplyUpdate(ReplyVO rvo);
}
