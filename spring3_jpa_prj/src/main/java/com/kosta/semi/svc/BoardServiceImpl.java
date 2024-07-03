package com.kosta.semi.svc;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public ArrayList<BoardEntity> svcBoardSelectList(){
		return (ArrayList)boardRepository.findAll();
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
		replyRepository.delete(rseq);
	}
	public void svcReplyUpdate(ReplyEntity rvo) {
		replyRepository.save(rvo);
	}
	public BoardEntity svcBoardSelectOne(Long seq) {
		return boardRepository.findOne(seq);
	}
	
	//댓글목록 가져오기 : REST
	@Transactional
	@Override
    public List<ReplyEntity> svcReplySelect(Long seq) {
		//BoardEntity board = boardRepository.findById(seq).orElseThrow();
		BoardEntity board = boardRepository.findOne(seq);
	    Hibernate.initialize(board.getReplies());
	    return new ArrayList<>(board.getReplies());
    }
	
	@Transactional
	public List<BoardEntity> svcSearchForRest(String searchStr){
		return boardRepository.findByTitleLike(searchStr);
	}
	
}
