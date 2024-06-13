package com.kosta.sample.board;

import java.util.ArrayList;
import java.util.List;

public class BoardCallTest {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		
		//-------------------------------------------------- JOIN
		BoardVO bvo =  dao.boardReplySelect(1);
		int seq      = bvo.getSeq(); 
		String title = bvo.getTitle();
		System.out.println(seq + "\t" + title);
		
		List<ReplyVO> rlist = bvo.getReplies();
		for(ReplyVO rvo  : rlist) {
			int rseq = rvo.getRseq(); 
			String reply = rvo.getReply();
			System.out.println("\t" +rseq + "\t" + reply);
		}
		//-------------------------------------------------- 상세보기 + 댓글목록
		BoardVO ovo = dao.boardSelectOne(1);
		System.out.println(ovo.getSeq() + "," + ovo.getTitle());
		
		ArrayList<ReplyVO> rlist2 = dao.replySelect(1);
		for(ReplyVO rvo  : rlist2) {
			int rseq = rvo.getRseq(); 
			String reply = rvo.getReply();
			System.out.println("\t" +rseq + "\t" + reply);
		}
				
	
		
//		BoardVO ovo = dao.boardSelectOne(1);
//		System.out.println(ovo.getSeq() + "," + ovo.getTitle());
		
		//public int boardDelete(int seq) {}
		// ORA-02292: integrity constraint (IT.FK_REPLY) violated - child record found
//		int delRows = dao.boardDelete(11);
//		System.out.println(delRows + "건 삭제");

		//public ArrayList<BoardVO> boardSelect() {}
//		ArrayList<BoardVO> list = dao.boardSelect();
//		System.out.println("총 : " + list.size());
//		for(BoardVO bvo : list) {
//			int seq         = bvo.getSeq();
//			String title    = bvo.getTitle();
//			String contents = bvo.getContents();
//			String regid    = bvo.getRegid();
//			String regdate  = bvo.getRegdate();
//			System.out.println(seq + "\t" + title + "\t" + contents + "\t" + regid + "\t" + regdate);			
//		}
//				
//		//public ArrayList<BoardVO> boardSelect() {}
//		list = dao.boardSelect();
//		System.out.println("총 : " + list.size());
//		for(BoardVO bvo : list) {
//			int seq         = bvo.getSeq();
//			String title    = bvo.getTitle();
//			String contents = bvo.getContents();
//			String regid    = bvo.getRegid();
//			String regdate  = bvo.getRegdate();
//			System.out.println(seq + "\t" + title + "\t" + contents + "\t" + regid + "\t" + regdate);			
//		}
//		
//		BoardVO bvo  = new BoardVO();
//		bvo.setTitle("title...");
//		bvo.setContents("contents...");   	
//		bvo.setSeq(1);   		
//		int updateRows = dao.boardUpdate(bvo);
//		System.out.println(updateRows + "건 수정");
//		
//		bvo  = new BoardVO();
//		bvo.setTitle("title222...");
//		bvo.setContents("contents222...");   	
//		bvo.setRegid("zzzz");   
//		int insertRows = dao.boardInsert(bvo);
//		System.out.println(insertRows + "건 입력");		
//		
//		for(int i=0; i<list.size(); i++) {
//			int seq         = list.get(i).getSeq();
//			String title    = list.get(i).getTitle();
//			String contents = list.get(i).getContents();
//			String regid    = list.get(i).getRegid();
//			String regdate  = list.get(i).getRegdate();
//			System.out.println(seq + "\t" + title + "\t" + contents + "\t" + regid + "\t" + regdate);			
//		}
				
		
	}

}

