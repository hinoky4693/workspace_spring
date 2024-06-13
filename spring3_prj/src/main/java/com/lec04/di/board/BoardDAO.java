package com.lec04.di.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;


@Repository
public class BoardDAO {
	/** 
	 * ----------------------------------------------------------------
	 *  board 전체 목록 
	 * ----------------------------------------------------------------- 
	 */
	public ArrayList<BoardVO> boardSelect() {	
		Connection conn = null;
		PreparedStatement pstmt  = null;
		ResultSet rs = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		DataSource ds = null;
		MyOracleConnection moc = new MyOracleConnection();  //클래스 분리시켜놓아서 인스턴스 생성해서 사용
		try {
			//---------------DBCP를 사용한 DB 연결 -----------------------
			//conn = moc.oracleConn();
			ds = moc.myOracleDataSource();
			conn = ds.getConnection();  
			String sql = "select * from board order by seq desc";
			pstmt = conn.prepareStatement(sql);
			rs =  pstmt.executeQuery();
			while(rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setSeq(rs.getInt("seq"));
				bvo.setTitle(rs.getString("title"));
				bvo.setContents(rs.getString("contents"));
				bvo.setRegid(rs.getString("regid"));
				bvo.setRegdate(rs.getString("regdate"));
				list.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			moc.oracleClose(conn, pstmt, rs);
		}
		return list;
	}
	
	/** 
	 * ----------------------------------------------------------------
	 *  board 입력
	 * ----------------------------------------------------------------- 
	 */
	//public int boardInsert(String title, String tag, String contents, String regid) {
	public int boardInsert(BoardVO bvo) {
		//seq       *title *contents *regid            regdate
		//nextval                    session,cookies   sysdate  
		Connection conn = null;
		PreparedStatement pstmt  = null;
		int insertRows = 0;
		DataSource ds = null;
		MyOracleConnection moc = new MyOracleConnection();  //클래스 분리시켜놓아서 인스턴스 생성해서 사용
		
		try {
			//---------------DBCP를 사용한 DB 연결 -----------------------
			//conn = moc.oracleConn();
			ds = moc.myOracleDataSource();
			conn = ds.getConnection();  

			//String sql = "insert into board(seq,title,contens,regid) values(board_seq.nextval,?,?,?)";
			String sql = "insert into board values(board_seq.nextval,?,?,'홍길동',sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getContents());   	
			insertRows =  pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			moc.oracleClose(conn, pstmt);
		}
		return insertRows;
	}
	
}