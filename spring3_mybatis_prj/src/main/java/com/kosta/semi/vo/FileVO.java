package com.kosta.semi.vo;

import lombok.Data;

@Data
public class FileVO {
	private int bseq;		// board_file_seq.nextval
	private String oname; 	// 사용자가 올린 파일 원본 명			ex) aa.jpg
	private String sname; 	// 시스템에 올릴 때 rename되는 파일 명.	ex) 2015777aa.jpg
	private long fsize=0;	  	// byte 47182334
	private String fpath; 	// 파일 저장 경로 : </webapp> /uploads/2015777aa.jpg
	private int seq;		// 게시물번호
	private String regid;
	private String regdate;
}