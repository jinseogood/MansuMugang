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
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import com.msmg.board.information.model.vo.Board;
import com.msmg.board.information.model.vo.Reply;
import com.msmg.board.review.model.vo.BoardFile;

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
		System.out.println("Bao : " + b);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getBoardNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		System.out.println("DaoboardNo : " + b.getBoardNo());
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
			
			System.out.println("startRow : " + startRow);
			System.out.println("endRow : " + endRow);
			System.out.println("currentPage : " + currentPage);
			
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
				b.setBuyInfoNo(rset.getInt("buy_info_no"));
				b.setRefBno(rset.getInt("ref_bno"));
				b.setbCount(rset.getInt("b_count"));
				b.setWriteYn(rset.getString("write_yn"));
				
				list.add(b);
			}
			System.out.println("list : " + list);
			
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
		int listCount = 0;
		Statement stmt = null;
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

	public Board selectOne(Connection con, String bid) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bid));
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board();
				
				b.setBoardSort(rset.getString("board_sort"));
				b.setBoardId(rset.getInt("board_id"));
				b.setBoardNo(rset.getInt("board_no"));
				b.setTitle(rset.getString("title"));
				b.setContent(rset.getString("content"));
				b.setBoardDate(rset.getDate("board_date"));
				b.setuCode(rset.getString("u_name"));
				b.setbCount(rset.getInt("b_count"));
				
				System.out.println("dao:" + b);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return b;
	}

	public int updateCount(Connection con, String bid) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bid);
			pstmt.setString(2, bid);
			
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
			pstmt.setString(3, r.getBoard_id());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Reply> selectReplyList(Connection con, String boardId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Reply r = null;
		ArrayList<Reply> list = new ArrayList<Reply>();
		
		String query = prop.getProperty("selectReplyList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, boardId);
			
			System.out.println("boardId Dao:"+boardId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				r = new Reply();
				
				r.setBoard_sort(rset.getString("board_sort"));
				r.setRe_content(rset.getString("re_content"));
				r.setU_code(rset.getString("u_name"));
				r.setBoard_id(rset.getString("board_id"));
				r.setRe_date(rset.getDate("re_date"));
				r.setReply_no(rset.getInt("reply_no"));
				
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
 		
		return list;
	}

	public int updateBoard(Connection con, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setDate(3, b.getBoardDate());
			pstmt.setInt(4, b.getBoardId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int deleteBoard(Connection con, int bid) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBoard");
		 
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectWrite(Connection con, String ucode) {
		PreparedStatement pstmt = null;
		int result = 0;
		int random = new Random().nextInt(1000) + 1;
		
		String query = prop.getProperty("selectWrite");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, random);
			pstmt.setString(2, ucode);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		if(result > 0) {
			return random;
		}else {
			return 0;
		}
	}

	public Board selectPreB(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		String query = prop.getProperty("selectPreBoard");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board();
				
				b.setuCode(rset.getString("u_name"));
				b.setBoardId(rset.getInt("board_id"));
				b.setBoardNo(rset.getInt("board_no"));
				b.setTitle(rset.getString("title"));
				b.setContent(rset.getString("content"));
				b.setBoardDate(rset.getDate("board_date"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
			
		}
		
		return b;
	}

	public Board selectNextB(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		String query = prop.getProperty("selectNextBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board();
				
				b.setuCode(rset.getString("u_name"));
				b.setBoardId(rset.getInt("board_id"));
				b.setBoardNo(rset.getInt("board_no"));
				b.setTitle(rset.getString("title"));
				b.setContent(rset.getString("content"));
				b.setBoardDate(rset.getDate("board_date"));
				
			}
			System.out.println("nextB : " + b);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
			
		}
		
		return b;
	}

	public int insertBoardFile(Connection con, BoardFile bf, int ucode) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoardFile");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bf.getOrigin_name());
			pstmt.setString(2, bf.getEdit_name());
			pstmt.setString(3, bf.getFile_src());
			pstmt.setInt(4, bf.getBoard_id());
			pstmt.setInt(5,  ucode);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		// TODO Auto-generated method stub
		return result;
	}

	public int deleteBoardFile(Connection con, String fileName) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBoardFile");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, fileName);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteReply(Connection con, String bid) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteReply");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, bid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
