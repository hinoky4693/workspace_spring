package com.kosta.semi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.kosta.semi.entity.ReplyEntity;


@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {
//	List<ReplyEntity> findBySeq(Long seq);
}