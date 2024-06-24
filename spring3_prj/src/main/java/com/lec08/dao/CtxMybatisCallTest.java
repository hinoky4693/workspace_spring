package com.lec08.dao;

import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
public class CtxMybatisCallTest {

	/**
	   기능 : xml을 읽어 해당 설정에 있는 (클래스들의 인스턴스 초기화) == (new)
	    <interface>				<class>
	    BeanFactory    			XmlBeanFactory
		ApplicationContext   	ClassPathXmlApplicationContext  : src/main/resources
								FileSystemXmlApplicationContext : full path
		WebApplicationContext	XmlWebApplicationContext        : + session request..
	 */
	
	
	public static void main(String[] args) {
		
        String xmlFile08 = "C:\\KOSTA\\S3917_J11\\workspace_sts3\\spring3_prj\\src\\main\\webapp\\WEB-INF\\spring\\lec08-servlet-context.xml";
        ApplicationContext ctx = new FileSystemXmlApplicationContext(xmlFile08);

        //----------------------------------------------------------------------------
  		// Mybatis DBCP 설정을 통한 DB 연결
  		//   - 설정파일 : src/main/resources/mybatis-context.xml
  		//   - 매퍼파일 : src/main/resources/user-map.xml
  		//----------------------------------------------------------------------------
  		//Mybatis session build
  		String path = "mybatis-context-lec08.xml";
  		Reader reader; 
  		try {
  			reader = Resources.getResourceAsReader(path);
  			SqlSessionFactory sqlSessionFactory  = new SqlSessionFactoryBuilder().build(reader);
  			if(sqlSessionFactory == null)
  				System.out.println("err");
  			else
  				System.out.println("Mybatis session build ok");
  		
  			SqlSession session = sqlSessionFactory.openSession();
//  			BoardVO vo = new BoardVO();
//  			vo.setSeq(1);
//  			
//  			//1건 출력
//  			vo = (BoardVO)session.selectOne("boardNameSpace.getBoardBySeq", vo);
//  			System.out.println("DB에서 가져온 값:" + vo.getTitle());
//  			
//  			//목록 출력
//  			List<BoardVO> list = session.selectList("boardNameSpace.getBoardReplyBySeq", vo);
//  			System.out.println("DB에서 가져온 값:" + list.toString());
//  			
//

  			
  			
//  			----------------------------------------------------------------
//  			 Mybatis를 사용한 CRUD 예
//  			----------------------------------------------------------------
  			UserVO uvo = new UserVO();
  			uvo.setUserId("user1234");
  			uvo.setUserPw("9999");
  			Integer res = session.insert("userNameSpace.userInsert", uvo);
  			session.commit();
  			System.out.println("RES:" + res);
  			
  			System.out.println("----------------------");
  			ArrayList<UserVO> userList = (ArrayList)session.selectList("userNameSpace.allUser");
  			for(int i=0; i<userList.size(); i++) {
  				uvo = userList.get(i);
  				System.out.println(uvo.getUserId() + "," + uvo.getUserSeq());
  			}
  			
  			System.out.println("----------------------");
  			uvo.setUserId("user1234");
  			uvo.setUserPw("9999"); 
  			uvo = session.selectOne("userNameSpace.login", uvo);
  			System.out.println("로그인 성공!! userSeq = " + uvo.getUserSeq());
  			
  			System.out.println("----------------------");
  			uvo.setUserPw("1234");
  			uvo.setUserId("user1234");
  			int ur = session.update("userNameSpace.userUpdate", uvo);
  			session.commit();
  			System.out.println("upt건수 : " + ur);
  			
//  			System.out.println("----------------------");
//  			uvo.setUserId("user1234");
//  			int dr = session.delete("userNameSpace.userDelete", uvo);
//  			session.commit();
//  			System.out.println("del건수 : " + dr);
  			
  			session.close();
  			
  			
  		} catch(Exception e) {
  			e.printStackTrace();
  		}
       
        
        
	}

}
