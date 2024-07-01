package com.kosta.semi.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.semi.entity.BoardEntity;
import com.kosta.semi.entity.ReplyEntity;
import com.kosta.semi.repository.BoardRepository;
import com.kosta.semi.repository.ReplyRepository;


@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	/**
	카운트	:	count();
	삭제		: 	delete(Long id);   		delete(UserEntity entity);   deleteAll();
	레코드유무	: 	exists(Long id);
	목록		:	findAll() 				findAll(Pageable);			findAll(Sort)
	상세		: 	findOne(Long id);		getOne(Long id);
	저장/수정	:	save(UserEntity entity);
	사용자정의	:	findByUserIdAndUserPw(String, Stirng);    
	 */
	
	public List<BoardEntity> svcBoardSelectList(){
		return boardRepository.findAll();
	}
	public void svcBoardInsert(BoardEntity bvo) {
		boardRepository.save(bvo);
	}
	public void svcReplyInsert(ReplyEntity rvo) {
		replyRepository.save(rvo);
	}
	public void svcBoardUpdate(BoardEntity bvo) {
		boardRepository.save(bvo);
	}
	public void svcBoardDelete(Long seq) {
		boardRepository.delete(seq);
	}
	public void svcReplyDelete(Long rseq) {
		boardRepository.delete(rseq);
	}
	public void svcReplyUpdate(ReplyEntity rvo) {
		replyRepository.save(rvo);
	}
	public BoardEntity svcBoardSelectOne(Long seq) {
		return boardRepository.findOne(seq);
	}
//	public List<ReplyEntity> svcReplySelect(Long seq){
//		return boardRepository.findAll();
//	}
//	public List<BoardEntity> svcSearchForRest(String searchStr){
//		return boardRepository.searchForRest(searchStr);
//	}
	
}
