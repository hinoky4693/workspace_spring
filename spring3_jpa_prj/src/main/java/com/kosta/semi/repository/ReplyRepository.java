package com.kosta.semi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.kosta.semi.entity.ReplyEntity;


@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {

	//BoardEntity의 seq를 기준으로 Reply 목록 가져오기
    List<ReplyEntity> findByBoardSeq(Long seq);
	
    
    //게시물 상세보기 + 댓글(REST) 처리를 하나의 트랜잭션으로 Lazy Loading 하기 위한 시도
    //방법0) ***
    //서비스에 @Transactional 사용

    //방법5) Hibernate.initialize() 사용
    //트랜잭션 내에서 명시적으로 컬렉션을 초기화합니다.
    
    //방법1) 
    //OSIV 패턴(뷰 렌더링이 완료될 때까지 영속성 컨텍스트를 열어 두는 방법) 사용
    //Spring Boot 애플리케이션에서는 기본적으로 OSIV가 활성화
    
    //방법2)Fetch Join 사용
//	 @Query("SELECT r FROM ReplyEntity r JOIN FETCH r.board b WHERE b.seq = :seq")
//	 List<ReplyEntity> findByBoardSeq(@Param("seq") Long seq);
    
    //방법3) EntityGraph 사용 (연관된 엔티티를 EAGER 로딩)
    
    //방법4)fetchType을 EAGER로 변경
    //@OneToMany(mappedBy = "board", fetch = FetchType.EAGER)
    //private List<ReplyEntity> replies;
    
	 
    //방법6) DTO(VO)사용 -- boardVO.toEntity().build()
}