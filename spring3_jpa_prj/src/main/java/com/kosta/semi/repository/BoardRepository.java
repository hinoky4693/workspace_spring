package com.kosta.semi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosta.semi.entity.BoardEntity;


@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
	public List<BoardEntity> findByTitleLike(String searchStr);
}