package com.msmg.board.notice.model.dao;

import static com.msmg.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import com.msmg.board.notice.model.vo.Attachment;
import com.msmg.board.notice.model.vo.Notice;

public class NoticeDao {
	private Properties prop = new Properties();
	
	public NoticeDao(){
		String fileName = NoticeDao.class.getResource("/sql/board/notice/notice-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getListCount(Connection conn) {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getListCount");
		
		try {
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
			
			if(rset.next()){
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}
	public ArrayList<Notice> selectList(Connection conn, int currentPage, int pageLimit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Notice> list = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			int startRow = (currentPage - 1) * pageLimit + 1;
			int endRow = startRow + pageLimit - 1;
			
			System.out.println(startRow + " + " + endRow);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Notice>();
			
			while(rset.next()){
				Notice no = new Notice();
				
				no.setBoard_id(rset.getInt("board_id"));
				no.setBoard_no(rset.getInt("board_no"));
				no.setTitle(rset.getString("title"));
				no.setContent(rset.getString("content"));
				no.setU_name(rset.getString("u_name"));
				no.setBoard_date(rset.getDate("board_date"));
				
				list.add(no);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			
		}
		
		
		
		return list;
	}
	public Notice selectOne(Connection conn, String bid) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice no = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bid));
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				no = new Notice();
				
				no.setBoard_id(rset.getInt("board_id"));
				no.setTitle(rset.getString("title"));
				no.setContent(rset.getString("content"));
				no.setB_count(rset.getInt("b_count"));
				no.setBoard_date(rset.getDate("board_date"));
				no.setU_name(rset.getString("u_name"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return no;
	}
	
	public int insertBoard(Connection conn, int ucode) {
		PreparedStatement pstmt = null;
		int result = 0;
		int rand = new Random().nextInt(1000) + 1;
		
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ucode);
			pstmt.setInt(2, rand);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		if(result > 0){
			return rand;
			
		}else{
			return result;
		}
	}
	
	public int insertAttachment(Connection conn, Attachment at) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			pstmt.setInt(4, at.getBoard_no());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			
		}
		
		return result;
	}
	public int deleteImg(Connection conn, String fileName) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteAttachment");
		
		try {
			pstmt = conn.prepareStatement(query);
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
	public int updateBoard(Connection conn, Notice no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, no.getTitle());
			pstmt.setString(2, no.getContent());
			pstmt.setInt(3, no.getBoard_no());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public int selectCurrval(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int bid = 0;
		
		String query = prop.getProperty("selectCurrval");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()){
				bid = rset.getInt("currval");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
			
		}
		
		
		return bid;
	}
	
	public int updatePhotho(Connection conn, int bno, int randbno) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatePhoto");
		System.out.println(bno);
		System.out.println(randbno);
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bno);
			pstmt.setInt(2, randbno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public int insertDocument(Connection conn, ArrayList<Attachment> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertDocument");
		
		try {
			for(int i = 0; i < fileList.size(); i++){
				System.out.println(fileList.get(i).getOriginName());
				System.out.println(fileList.get(i).getChangeName());
				System.out.println(fileList.get(i).getFilePath());
				System.out.println(fileList.get(i).getBoard_no());
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileList.get(i).getOriginName());
			pstmt.setString(2, fileList.get(i).getChangeName());
			pstmt.setString(3, fileList.get(i).getFilePath());
			pstmt.setInt(4, fileList.get(i).getBoard_no());
			
			result = pstmt.executeUpdate();
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public int selectPhoto(Connection conn, int randbno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectPhoto");
		
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, randbno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return result;
	}
	public int updateCount(Connection conn, String bid) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bid));
			pstmt.setInt(2, Integer.parseInt(bid));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public Notice selectPreNo(Connection conn, String bid) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice no = null;
		
		String query = prop.getProperty("selectPreNotice");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bid));
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				no = new Notice();
				
				no.setBoard_id(rset.getInt("board_id"));
				no.setTitle(rset.getString("title"));
				no.setBoard_date(rset.getDate("board_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return no;
	}
	
	public Notice selectNextNo(Connection conn, String bid) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice no = null;
		
		String query = prop.getProperty("selectNextNo");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bid);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				System.out.println("들어옴");
				no = new Notice();
				
				no.setBoard_id(rset.getInt("board_id"));
				no.setTitle(rset.getString("title"));
				no.setBoard_date(rset.getDate("board_date"));
			}
			
			System.out.println("dao nno : " + no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return no;
	}

}
