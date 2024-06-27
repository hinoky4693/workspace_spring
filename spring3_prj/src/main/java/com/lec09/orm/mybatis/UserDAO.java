//package com.lec09.orm.mybatis;
//
//import java.util.ArrayList;
//
//import org.apache.ibatis.session.SqlSession;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public class UserDAO {
//	
//	@Autowired
//	SqlSession session;	//sqlSession
//	
//	public int userInsert(UserVO uvo) {
//		return session.insert("userNameSpace.userInsert", uvo);
//	}
//
//	public ArrayList<UserVO> userSelectAll(){
//		return (ArrayList)session.selectList("userNameSpace.allUser");
//	}
//
//	public UserVO userSelectOne(UserVO uvo) {
//		return session.selectOne("userNameSpace.login", uvo);
//	}
//	
//	public int userUpdate(UserVO uvo) {
//		return session.update("userNameSpace.userUpdate", uvo);
//	}
//
//	public int userDelete(UserVO uvo) {
//		return session.delete("userNameSpace.userDelete", uvo);
//	}
//
//
//
//}
