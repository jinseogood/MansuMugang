package com.msmg.board.review.model.dao;

import static com.msmg.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
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

import com.msmg.board.information.model.vo.Board;
import com.msmg.board.review.model.vo.BoardFile;

public class ReviewDao {
	private Properties prop = new Properties();
	
	public ReviewDao() {
		String fileName = ReviewDao.class.getResource("/sql/board/review/review-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertReviewContent(Connection con, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReview");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getuCode());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		
		return result;
	}

	public int selectCurrval(Connection con) {
		System.out.println("selectCurrval넘어옴");
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int bid = 0;
		
		System.out.println("쿼리문 작성");
		String query = prop.getProperty("selectCurrval");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			System.out.println("try rset :" + rset);
			if(rset.next()) {
				System.out.println("If rset : " + rset);
				bid = rset.getInt("currval");
				System.out.println("ReviewDao : " + bid);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return bid;
	}

	public int insertBoardFile(Connection con, ArrayList<BoardFile> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		
		String query = prop.getProperty("insertBoardFile");
		
		try {
			for(int i = 0; i < fileList.size(); i++) {
				System.out.println("dao board_no : " + fileList.get(i).getBoard_no());
				
				
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, fileList.get(i).getOrigin_name());
				pstmt.setString(2, fileList.get(i).getEdit_name());
				pstmt.setString(3, fileList.get(i).getFile_src());
				pstmt.setInt(4, fileList.get(i).getBoard_no());
				pstmt.setInt(5, fileList.get(i).getU_code());
				
				result += pstmt.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public ArrayList<HashMap<String, Object>> selectReviewList(Connection con) {
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;
		
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectReviewMap");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, Object>();
				
				hmap.put("fileNo", rset.getInt("file_no"));
				hmap.put("originName", rset.getString("origin_name"));
				hmap.put("editName",rset.getString("edit_name"));
				hmap.put("fileSrc", rset.getString("file_src"));
				hmap.put("fileDate", rset.getDate("file_date"));
				hmap.put("boardSort", rset.getInt("board_sort"));
				hmap.put("boardNo", rset.getInt("board_id"));
				hmap.put("uCode", rset.getInt("u_code"));
				hmap.put("title", rset.getString("title"));
				hmap.put("content", rset.getString("content"));
				
				list.add(hmap);
			}
			
			System.out.println("dao : " + list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return list;
	}

}
