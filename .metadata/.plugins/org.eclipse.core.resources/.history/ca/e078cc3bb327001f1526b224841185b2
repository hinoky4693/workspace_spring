package com.kosta.sample.chart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kosta.sample.jdbc.EmpVO;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpVO> list = dao.empSelect();
		System.out.println("총 : "+ list.size());
		for(EmpVO evo : list) {
			System.out.println(evo.getSal());
		}
			
		request.setAttribute("KEY_EMPLIST", list);
		request.getRequestDispatcher("lec_chart.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
//		response.setContentType("application/json;charset=UTF-8");
		
		Gson gson = new Gson();
		
		
		EmpDAO dao = new EmpDAO();
		ArrayList<EmpVO> list = dao.empSelect();

		String jsonStr = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		out.print(jsonStr);
	}
	
}
