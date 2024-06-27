package com.lec09.orm.mybatis;


import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.io.Resources;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TXCallTest {


	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("resource-servlet-context-lec09.xml");
		
		
		//----------------------------------------------------------------------------
		// Spring DBCP 설정을 통한 DB 연결 
		//   - 설정파일 : webapp/WEB-INF/servlet-context-lec09.xml
		//----------------------------------------------------------------------------
		String url2 = "C:\\KOSTA\\S3917_J11\\workspace_sts3\\spring3_prj\\src\\main\\webapp\\WEB-INF\\spring\\lec09-servlet-context.xml";
		ApplicationContext ctx = new FileSystemXmlApplicationContext(url2);
	
		DataSource ds = (DataSource)ctx.getBean("MY_tomcat_ds");
		Connection conn = null;
		try {
			conn = ds.getConnection();
			if(conn != null)
				System.out.println("Properties DataSource myDS conn ok");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		/**
		 *  Spring Transaction 은 기본적으로 unchecked Exception (RuntimeException)만 관리하며 
		 *  checked Exception (IOException, SQLException 등) 은 관리하지 않는다.
		 * 			: <tx:method name="*" rollback-for="RuntimeException"/> 설정한 경우 SQLException(checked)은 잡지못해 롤백 처리가 안된다.
		 *  
		 *  처리방법	: @Transactional(rollbackFor=Exception.class) 와 같이 설정하여 모든 Exception 발생시 rollback 이 발생하게 처리 
		 *  	  	: <tx:method name="*" rollback-for="Exception"/>
		 */
		
		//TX rollback test용
//		@Service == UserService svc = new UserServiceImpl();
//		설정에 <bean>등록이 안되어 있는 경우(어노테이션 방식의 경우): bean의 클래스로 getBean()
		UserService svc = (UserService)ctx.getBean(UserService.class);
		if (svc!=null)
			System.out.println("svc ins.ok");
		System.out.println(svc.svcUserSelectAll().toString());
	
//		정상 트랜잭션 : DB insert 확인
		UserVO uvo = new UserVO();
//		uvo.setUserId("trans");
//		uvo.setUserPw("777");
//		svc.svcUserInsert(uvo);
		
//		unchecked 예외 발생 : 롤백처리 확인
		uvo.setUserId("runex123123");
		uvo.setUserPw("000");
		svc.svcInsertRuntimeErrorFunc(uvo);
		
		
//		checked 예외 발생 : 롤백처리 확인
		uvo.setUserId("sqlex123123");
		uvo.setUserPw("000");
		try {
			svc.svcInsertSQLErrorFunc(uvo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
