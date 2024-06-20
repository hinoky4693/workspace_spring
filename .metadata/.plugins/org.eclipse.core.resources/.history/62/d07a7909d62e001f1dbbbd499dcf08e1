package com.lec06.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AOPController extends MultiActionController {

	//property 방식으로 DI 주입
	private AOPService aOPService;
	public void setAOPService(AOPService svc) {
		this.aOPService = svc;
	}
	
	public void ctlDelete(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("1. AOPController.ctlDelete() 실행");
		aOPService.svcDelete();
	}
	
}
