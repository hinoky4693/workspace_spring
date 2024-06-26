package com.lec04.di;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;	// @Autowired -> new 된 DAO 주세요.
import org.springframework.stereotype.Controller;				// @Controller -> 난 이제부터 controller 이다.
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;	// @RequestMapping	-> 밑에주소 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.lec01.hello.HomeController;



//@Controller
//<bean name="MY_EMPCONTROLLER_BEAN_NAME" class="com.lec04.di.EmpController"</bean>
public class EmpController extends MultiActionController{
	//// -------------------- 어노테이션 기반 --------------------

	
	// -------------------- xml 기반 --------------------
//	// 생성자 (constructor) 
//	private EmpDAO dao;
//	public EmpController(EmpDAO dao){
//		this.dao = dao;
//	}
//	
//	
	// 프로퍼티(setter)
	private EmpDAO dao;
	public void setDao(EmpDAO dao){
		this.dao = dao;
	}
	
	private String str;
	public void setStringTest(String str){
		this.str = str;
	}
	

	//@RequestMapping(value = "/emp_list_servlet", method = RequestMethod.GET)
    public ModelAndView empList(HttpServletRequest request, HttpServletResponse response){
    	
    	ModelAndView mav = new ModelAndView();
    	//Model
    	ArrayList<EmpVO> list = dao.empSelect();	
		mav.addObject("KEY_EMPLIST", list);
		mav.addObject("KEY_TESTSTR", this.str);
		//View
		mav.setViewName("lec02_servlet");
		
		System.out.println("DI로 주입 받은 String 값 : " + this.str);
		return mav;
    }
    
    public ModelAndView empDumy(HttpServletRequest request, HttpServletResponse response){

    	ModelAndView mav = new ModelAndView();
    	//Model
    	mav.addObject("KEY_EMPLIST", new ArrayList<EmpVO>());
    	mav.addObject("KEY_TESTSTR", "empDumy : DumyTest");
    	//View
    	mav.setViewName("lec02_servlet");

    	System.out.println("DI로 주입 받은 String 값 : " + this.str);
    	return mav;
    }

//	@Override
//	import org.springframework.web.servlet.mvc.AbstractController;
//	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	} // doGet, doPost 랑 비슷해서 안씀. method마다 주소를 줄 수 없을 듯함.
	
}
