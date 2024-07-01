package com.kosta.semi.svc;

import java.util.ArrayList;
import java.util.List;

import com.kosta.semi.entity.BoardEntity;
import com.kosta.semi.entity.ReplyEntity;




public interface BoardService {
	public List<BoardEntity> svcBoardSelectList();
	public void svcBoardInsert(BoardEntity bvo);
	public void svcReplyInsert(ReplyEntity rvo);
	public void svcBoardUpdate(BoardEntity bvo);
	public void svcBoardDelete(Long seq);
	public void svcReplyDelete(Long rseq);
	public void svcReplyUpdate(ReplyEntity rvo);
	public BoardEntity svcBoardSelectOne(Long seq);
//	public List<ReplyEntity> svcReplySelect(Long seq);
//	public List<BoardEntity> svcSearchForRest(String searchStr);
}
