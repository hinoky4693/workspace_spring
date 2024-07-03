package com.lec12.web;

import java.util.List;

import lombok.Data;

@Data
public class BoardVO {
	private int seq;            //PK sequence
	private String title;
	private String contents;
	private String regid;       //session cookie
	private String regdate;     //default sysdate
	
	private List<FileVO> files;
}
