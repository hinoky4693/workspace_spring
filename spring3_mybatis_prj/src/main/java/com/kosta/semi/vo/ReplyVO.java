package com.kosta.semi.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ReplyVO {
	private int rseq;
	private String reply;
	private String regid;
	private String regdate;
	private int seq ;
}
