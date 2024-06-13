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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;				// @Controller -> 난 이제부터 controller 이다.
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;	// @RequestMapping	-> 밑에주소 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.lec01.hello.HomeController;



@Controller
	//@Controller의 역할
	// 1. 컨트롤러로 동작	 : extends **Controller(ex) MultiActionController)
	// 2. 인스턴스 생성(new) : <bean name="MY_EMPCTL_BEAN_NAME" class="com.lec04.di.EmpController" scope="singleton">

public class EmpController2 {
	//// -------------------- 어노테이션 기반 --------------------
	@Autowired
	// <property name="dao" ref="MY_EMPDAO_BEAN_NAME"/>
	private EmpDAO dao;
	
	@Value("abcd")
	// <property name="stringTest" value="abc"/>
	private String str;

	@RequestMapping(value = "/emp_list", method = RequestMethod.GET)
    public String empList(Model model){
    	ArrayList<EmpVO> list = dao.empSelect();	
		model.addAttribute("KEY_EMPLIST", list);
		model.addAttribute("KEY_TESTSTR", this.str);
		
		return "lec02_servlet";
    }
	
	@RequestMapping(value = "/emp_dummy", method = RequestMethod.GET)
    public String empDumy(Model model){

		model.addAttribute("KEY_EMPLIST", new ArrayList<EmpVO>());
		model.addAttribute("KEY_TESTSTR", "empDumy : DumyTest");

    	return "lec02_servlet";
    }
	
//	@RequestMapping(value = "/emp_list", method = RequestMethod.GET)
//    public ModelAndView empList(HttpServletRequest request, HttpServletResponse response){
//    	
//    	ModelAndView mav = new ModelAndView();
//    	//Model
//    	ArrayList<EmpVO> list = dao.empSelect();	
//		mav.addObject("KEY_EMPLIST", list);
//		mav.addObject("KEY_TESTSTR", this.str);
//		//View
//		mav.setViewName("lec02_servlet");
//		
//		System.out.println("DI로 주입 받은 String 값 : " + this.str);
//		return mav;
//    }
    
//	@RequestMapping(value = "/emp_dummy", method = RequestMethod.GET)
//    public ModelAndView empDumy(HttpServletRequest request, HttpServletResponse response){
//
//    	ModelAndView mav = new ModelAndView();
//    	//Model	
//    	mav.addObject("KEY_EMPLIST", new ArrayList<EmpVO>());
//    	mav.addObject("KEY_TESTSTR", "empDumy : DumyTest");
//    	//View
//    	mav.setViewName("lec02_servlet");
//
//    	System.out.println("DI로 주입 받은 String 값 : " + this.str);
//    	return mav;
//    }

//	@Override
//	import org.springframework.web.servlet.mvc.AbstractController;
//	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	} // doGet, doPost 랑 비슷해서 안씀. method마다 주소를 줄 수 없을 듯함.
	
}
