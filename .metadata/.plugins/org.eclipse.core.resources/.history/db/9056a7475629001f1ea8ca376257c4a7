package com.kosta.sample.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/board_servlet_url")
public class LecServletCall extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LecServletCall() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Hello ㅋㅋ Served at: ")
//		                    .append(request.getContextPath());
		String vUserid = request.getParameter("vUserid");
		response.getWriter().append("Get : " + vUserid);
		System.out.println("====request method : GET====");
//		response.sendRedirect("index.html");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vUserid = request.getParameter("userid");
		String vUserpw = request.getParameter("userpw");
		String vGen = request.getParameter("gen");
		String vSubject = request.getParameter("subject");
		String vUserfile = request.getParameter("userfile");
		String vSsn = request.getParameter("ssn");
		String vContents = request.getParameter("contents");
		String[] vHabit = request.getParameterValues("habit");
		
		response.getWriter().append("POST : " + vUserid);
		
		System.out.println(vUserid);
		System.out.println(vUserpw);
		System.out.println(vGen);
		System.out.println(vSubject);
		System.out.println(vUserfile);
		System.out.println(vSsn);
		System.out.println(vContents);
		
		for(String vh:vHabit) {
			System.out.println(vh);
		}
		
		System.out.println("====request method : POST====");
	}

}
