package com.lec04.di;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lec03.spring.EmpDAO;
import com.lec03.spring.EmpVO;

public class CtxCallTest {
	/**
	   기능 : xml을 읽어 해당 설정에 있는 (클래스들의 인스턴스 초기화) == (new)
	    <interface>				<class>	
	    BeanFactory    			XmlBeanFactory						path 경로
		ApplicationContext   	ClassPathXmlApplicationContext	: src/main/resources
								FileSystemXmlApplicationContext	: full path
		WebApplicationContext	XmlWebApplicationContext		: session, request ... 꺼내볼 수 있음.
	 */
	public static void main(String[] args) {

		String xmlFile = "C:\\KOSTA\\S3917_J11\\workspace_sts3\\spring3_prj\\src\\main\\webapp\\WEB-INF\\spring\\lec03-servlet-context.xml";
        ApplicationContext ctx = new FileSystemXmlApplicationContext(xmlFile);
        /**
            <beans:bean name="MY_IR_VIEW_RESOLVER_BEAN_NAME"   class="org.springframework.web.servlet.view.InternalResourceViewResolver">
				<beans:property name="prefix" value="/" />
				<beans:property name="suffix" value=".jsp" />
			</beans:bean>
			
			import org.springframework.web.servlet.view.InternalResourceViewResolver;
			InternalResourceViewResolver irvr = new InternalResourceViewResolver();
			
         */
        InternalResourceViewResolver ds = (InternalResourceViewResolver)ctx.getBean("MY_IR_VIEW_RESOLVER_BEAN_NAME");
	    if(ds != null) {
	    	System.out.println("인스턴스 생성" + ds);
	    } else {
	    	System.out.println("인스턴스 생성 실패");
	    }
	    
	    //----  POJO(Plain Old Java Object) : 결합도가 높아 비효율적 --------------------------------------
	    EmpDAO dao = new EmpDAO();
	    ArrayList<EmpVO> list = dao.empSelect();
	    System.out.println(list.size() + "건 - new");
	    //---- DI(Dependency Injection) : 결합도를 낮춰 상당히 효율적(재사용, 확장) --------------------------- 
	    /**
         * <beans:bean name="MY_EMPDAO_BEAN_NAME" class="com.lec03.spring.EmpDAO"></beans:bean> 
         * == EmpDAO dao = new EmpDAO();
         */
	    
	    String xmlFile04 = "C:\\KOSTA\\S3917_J11\\workspace_sts3\\spring3_prj\\src\\main\\webapp\\WEB-INF\\spring\\lec04-servlet-context.xml";
        ApplicationContext ctx4 = new FileSystemXmlApplicationContext(xmlFile04);
        EmpDAO sdao = (EmpDAO)ctx4.getBean("MY_EMPDAO_BEAN_NAME");
        
        ArrayList<EmpVO> list4 = sdao.empSelect();
	    System.out.println(list4.size() + "건 - 스프링사용");
	}

}
