package com.kosta.semi.svc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.semi.mappers.BoardMapper;
import com.kosta.semi.vo.BoardVO;
import com.kosta.semi.vo.ReplyVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardMapper boardMapper;

	
	public ArrayList<BoardVO> svcBoardSelectList(){
		return boardMapper.boardSelectList();
	}
	public int svcBoardInsert(BoardVO bvo) {
		return boardMapper.boardInsert(bvo);
	}
	public int svcReplyInsert(ReplyVO rvo) {
		return boardMapper.replyInsert(rvo);
	}
	public int svcBoardUpdate(BoardVO bvo) {
		return boardMapper.boardUpdate(bvo);
	}
	public int svcBoardDelete(int seq) {
		return boardMapper.boardDelete(seq);
	}
	public int svcReplyDelete(int rseq) {
		return boardMapper.replyDelete(rseq);
	}
	public int svcReplyUpdate(ReplyVO rvo) {
		return boardMapper.replyUpdate(rvo);
	}
	public BoardVO svcBoardSelectOne(int seq) {
		return boardMapper.boardSelectOne(seq);
	}
	public ArrayList<ReplyVO> svcReplySelect(int seq){
		return boardMapper.replySelect(seq);
	}
	public ArrayList<BoardVO> svcSearchForRest(String searchStr){
		return boardMapper.searchForRest(searchStr);
	}
	
}