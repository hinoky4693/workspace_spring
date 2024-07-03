package com.kosta.semi.svc;

import java.util.ArrayList;
import java.util.List;

import com.kosta.semi.vo.BoardVO;
import com.kosta.semi.vo.FileVO;
import com.kosta.semi.vo.ReplyVO;


public interface BoardService {
	public ArrayList<BoardVO> svcBoardSelectList();
	public void svcBoardInsert(BoardVO bvo, List<FileVO> files);
	public int svcReplyInsert(ReplyVO rvo);
	public int svcBoardUpdate(BoardVO bvo);
	public int svcBoardDelete(int seq);
	public int svcReplyDelete(int rseq);
	public int svcReplyUpdate(ReplyVO rvo);
	public BoardVO svcBoardSelectOne(int seq);
	public ArrayList<ReplyVO> svcReplySelect(int seq);
	public ArrayList<BoardVO> svcSearchForRest(String searchStr);
}
