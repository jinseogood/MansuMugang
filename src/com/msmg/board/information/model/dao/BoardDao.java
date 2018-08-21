package com.msmg.board.information.model.dao;

import static com.msmg.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.msmg.board.information.model.vo.Board;
import com.msmg.board.information.model.vo.Reply;

public class BoardDao {
	private Properties prop = new Properties();
	
	public BoardDao() {
		String fileName = BoardDao.class.getResource("/sql/board/information/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public int insertBoard(Connection con, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getuCode());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Board> selectList(Connection con, int currentPage, int limit) {
		ArrayList<Board> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			
			while(rset.next()) {
				Board b = new Board();
				
				b.setBoardId(rset.getInt("board_id"));
				b.setBoardNo(rset.getInt("board_no"));
				b.setBoardSort(rset.getString("board_sort"));
				b.setTitle(rset.getString("title"));
				b.setContent(rset.getString("content"));
				b.setBoardDate(rset.getDate("board_date"));
				b.setuCode(rset.getString("u_name"));
				b.setbCount(rset.getInt("b_count"));
				
				list.add(b);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
	}

	//총 게시물 수
	public int getListCount(Connection con) {
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return listCount;
	}

	public Board selectOne(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(num));
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				System.out.println(num);
				b = new Board();
				
				b.setBoardId(rset.getInt("board_id"));
				b.setBoardNo(rset.getInt("board_no"));
				b.setTitle(rset.getString("title"));
				b.setContent(rset.getString("content"));
				b.setBoardDate(rset.getDate("board_date"));
				b.setuCode(rset.getString("u_name"));
				b.setbCount(rset.getInt("b_count"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return b;
	}

	public int updateCount(Connection con, String num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.setInt(2, Integer.parseInt(num));
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertReply(Connection con, Reply r) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReply");
		
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, r.getU_code());
			pstmt.setString(2, r.getRe_content());
			pstmt.setInt(3, r.getBoard_id());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Reply> selectReplyList(Connection con, int boardId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Reply r = null;
		ArrayList<Reply> list = new ArrayList<Reply>();
		
		String query = prop.getProperty("selectReplyList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				r = new Reply();
				
				r.setBoard_sort(rset.getString("board_sort"));
				r.setRe_content(rset.getString("re_content"));
				r.setU_code(rset.getString("u_name"));
				r.setBoard_id(rset.getInt("board_id"));
				r.setRe_date(rset.getDate("re_date"));
				
				
				list.add(r);
			}
			
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
 		
		return list;
	}

}
