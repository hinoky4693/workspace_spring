package com.kosta.semi.svc;

import java.util.ArrayList;

import com.kosta.semi.vo.BoardVO;
import com.kosta.semi.vo.ReplyVO;


public interface BoardService {
	public ArrayList<BoardVO> svcBoardSelectList();
	public int svcBoardInsert(BoardVO bvo);
	public int svcReplyInsert(ReplyVO rvo);
	public int svcBoardUpdate(BoardVO bvo);
	public int svcBoardDelete(int seq);
	public int svcReplyDelete(int rseq);
	public int svcReplyUpdate(ReplyVO rvo);
	public BoardVO svcBoardSelectOne(int seq);
	public ArrayList<ReplyVO> svcReplySelect(int seq);
	public ArrayList<BoardVO> svcSearchForRest(String searchStr);
}
