package com.lec06.aop;

import org.springframework.stereotype.Repository;

@Repository
public class AOPDAO {
	public void delete() {
		System.out.println("3. AOPDAO.delete() 실행");
	}
}
