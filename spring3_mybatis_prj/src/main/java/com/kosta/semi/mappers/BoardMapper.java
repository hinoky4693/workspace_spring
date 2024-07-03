package com.kosta.semi.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.kosta.semi.vo.BoardVO;
import com.kosta.semi.vo.FileVO;
import com.kosta.semi.vo.ReplyVO;

@Repository
@Mapper
public interface BoardMapper {
	public ArrayList<BoardVO> boardSelectList();
	public int boardInsert(BoardVO bvo);
	public int fileInsert(FileVO fvo);
	public int replyInsert(ReplyVO rvo);
	public int boardUpdate(BoardVO bvo);
	public int boardDelete(int seq);
	public int replyDelete(int rseq);
	public int replyUpdate(ReplyVO rvo);
	public BoardVO boardSelectOne(int seq);
	public ArrayList<ReplyVO> replySelect(int seq);
	public ArrayList<BoardVO> searchForRest(String searchStr);
}
