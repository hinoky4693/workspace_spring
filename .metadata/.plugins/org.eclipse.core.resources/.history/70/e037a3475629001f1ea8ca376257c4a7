package com.kosta.sample.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.internal.StateSignatures;

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardServlet() {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		BoardDAO dao = new BoardDAO();

		if (request.getParameter("pagecode").equals("B001")){
			ArrayList<BoardVO> list = dao.boardSelect();

			request.setAttribute("KEY_BOARDLIST", list);
			RequestDispatcher rd = request.getRequestDispatcher("tables.jsp");
			rd.forward(request, response);

		} else if (request.getParameter("pagecode").equals("B002")){
			//			BoardVO bvo = dao.boardSelectOne(Integer.parseInt(request.getParameter("seq")));
			BoardVO bvo = dao.boardReplySelect(Integer.parseInt(request.getParameter("seq")));
			ArrayList<ReplyVO> rlist = (ArrayList<ReplyVO>)bvo.getReplies();
			request.setAttribute("KEY_BOARDVO", bvo);
			request.setAttribute("KEY_REPLYLIST", rlist);
			RequestDispatcher rd = request.getRequestDispatcher("tables_detail.jsp");
			rd.forward(request, response);
		} else if(request.getParameter("pagecode").equals("B005")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			int rseq = Integer.parseInt(request.getParameter("rseq"));


			int deleteRows = dao.replyDelete(rseq);
			if (deleteRows>=1) {
				response.sendRedirect(request.getContextPath()+"/BoardServlet?pagecode=B002&seq="+seq);
			} else {
				response.sendRedirect("500.html");
			}

		}





	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		BoardDAO dao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		ReplyVO rvo = new ReplyVO();

		if(request.getParameter("pagecode").equals("B003")) {

			bvo.setSeq(Integer.parseInt(request.getParameter("seq")));
			bvo.setTitle(request.getParameter("title"));
			bvo.setContents(request.getParameter("contents"));

			int updateRows = dao.boardUpdate(bvo);

			if (updateRows>=1) {
				response.sendRedirect(request.getContextPath() + "/BoardServlet?seq="+Integer.parseInt(request.getParameter("seq"))+"&pagecode=B002");
			} else {
				response.sendRedirect("500.html");
			}

		} else if(request.getParameter("pagecode").equals("B004")) {

			int seq = Integer.parseInt(request.getParameter("seq"));
			int deleteRows = dao.boardDelete(seq);
			//			bvo.setSeq(Integer.parseInt(request.getParameter("seq")));
			//			int deleteRows = dao.boardDelete(Integer.parseInt(request.getParameter("seq")));

			if (deleteRows>=1) {
				response.sendRedirect(request.getContextPath() + "/BoardServlet?pagecode=B001");
			} else {
				response.sendRedirect("500.html");
			} 
		} else if(request.getParameter("pagecode").equals("B006")) {
			rvo.setReply(request.getParameter("reply"));
			rvo.setSeq(Integer.parseInt(request.getParameter("seq")));
			int insertRows = dao.replyInsert(rvo);
			if (insertRows>=1) {
				response.sendRedirect(request.getContextPath() + "/BoardServlet?seq="+Integer.parseInt(request.getParameter("seq"))+"&pagecode=B002");
			} else {
				response.sendRedirect("500.html");
			} 
		}
		System.out.println("====method : POST====");
	}

}
