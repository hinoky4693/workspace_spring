package com.lec05.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lec05.rest.BoardDAO;
import com.lec05.rest.BoardVO;


public class RestServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RestServletTest() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("pagecode").equals("B000")){
			String ename = request.getParameter("ename");
			System.out.println(ename);
			
			PrintWriter out = response.getWriter();
			out.print(ename);	
		} else if(request.getParameter("pagecode").equals("B001")) {
			Gson gson = new Gson();
			BoardDAO dao = new BoardDAO();
			
			ArrayList<BoardVO> list = dao.boardSelect();
			// 객체 리스트[VO] --> [{"title"="aaa", "regid"="kim"}]
			
			String jsonData = gson.toJson(list);
			// 스트링 리스트[JSON] --> [{"title":"aaa", "regid":"kim"}]
			System.out.println(request.getParameter("ename"));
			
			PrintWriter out = response.getWriter();
			out.print(jsonData);
		}  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("pagecode").equals("B002")) {
			BoardDAO dao = new BoardDAO();
			String jsonStr = request.getReader().lines().collect(Collectors.joining());
			// $.ajax   : JSON.stringify({"title":"aaaaatitle","regid":"hong"});
			// jsonStr  : "   {"title":"aaaaatitle","regid":"hong"}   "
			// bvo      : {"title":"aaaaatitle","regid":"hong"}
			
			Gson gson = new Gson();

			BoardVO bvo = gson.fromJson(jsonStr, BoardVO.class);
			
			System.out.println(bvo.getSeq()+ ", " + bvo.getTitle());
			
			PrintWriter out = response.getWriter();
			ArrayList<BoardVO> list = dao.boardSelect();
			// 객체 리스트[VO] --> [{"title"="aaa", "regid"="kim"}]
			
			String jsonData = gson.toJson(list);
			// 스트링 리스트[JSON] --> [{"title":"aaa", "regid":"kim"}]
			out.print(jsonData);
			
		} else if(request.getParameter("pagecode").equals("B003")) {
			response.setContentType("application/json;charset=UTF-8");
			
			System.out.println(request.getParameter("ename"));
			
			BoardDAO dao = new BoardDAO();
			Gson gson = new Gson();
			
			PrintWriter out = response.getWriter();
			ArrayList<BoardVO> list = dao.boardSelect();
			
			String jsonData = gson.toJson(list);
			
			out.print(jsonData);
		
		} else if(request.getParameter("pagecode").equals("B004")) {
			response.setContentType("application/json;charset=UTF-8");
			BoardDAO dao = new BoardDAO();
			Gson gson = new Gson();
			
			String jsonStr = request.getReader().lines().collect(Collectors.joining());
			BoardVO bvo = gson.fromJson(jsonStr, BoardVO.class);
			
			System.out.println(bvo.getTitle()+", "+bvo.getContents());
			
			PrintWriter out = response.getWriter();
			ArrayList<BoardVO> list = dao.boardSelect();
			
			String jsonData = gson.toJson(list);
			
			out.print(jsonData);
		
		}
		
	}
}
