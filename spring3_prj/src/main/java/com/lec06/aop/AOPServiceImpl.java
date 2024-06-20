package com.lec06.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class AOPServiceImpl implements AOPService {

	private AOPDAO aOPDAO;
	public void setAOPDAO(AOPDAO aOPDAO) {
		this.aOPDAO = aOPDAO;
	}
	
	@Override
	public void svcDelete() {
		System.out.println("2. AOPServiceImpl.svcDelete() 실행");
		aOPDAO.delete();
//		// 강제 에러 발생
//		throw new RuntimeException();
	}

}
