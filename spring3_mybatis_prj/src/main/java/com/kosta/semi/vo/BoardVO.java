package com.kosta.semi.vo;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BoardVO {
	private int seq;
	private String title;
	private String contents;
	private String regid;
	private String regdate;
	List<ReplyVO> replies;
}
