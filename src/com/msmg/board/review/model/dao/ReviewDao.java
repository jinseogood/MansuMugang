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
				System.out.println("dao board_no : " + fileList.get(i).getBoard_id());
				
				
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, fileList.get(i).getOrigin_name());
				pstmt.setString(2, fileList.get(i).getEdit_name());
				pstmt.setString(3, fileList.get(i).getFile_src());
				pstmt.setInt(4, fileList.get(i).getBoard_id());
				pstmt.setInt(5, fileList.get(i).getU_code());
				
				int level = 0;
				if(i == 0) level = 0;
				else level = 1;
				
				pstmt.setInt(6, level);
				
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
				hmap.put("editName", rset.getString("edit_name"));
				hmap.put("fileSrc", rset.getString("file_src"));
				hmap.put("fileDate", rset.getDate("file_date"));
				hmap.put("boardSort", rset.getInt("board_sort"));
				hmap.put("boardId", rset.getInt("board_id"));
				hmap.put("uCode", rset.getInt("u_code"));
				hmap.put("uName", rset.getString("u_name"));
				hmap.put("title", rset.getString("title"));
				hmap.put("content", rset.getString("content"));
				
				list.add(hmap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		return list;
	}

	public HashMap<String, Object> selectOneReviewMap(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		ArrayList<BoardFile> list = null;
		Board b = null;
		BoardFile bf = null;
		
		String query = prop.getProperty("selectReviewOne");
		
		try {
			System.out.println("BoardDao num : " + num);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			System.out.println("query : " + query);
			rset = pstmt.executeQuery();
			System.out.println("rset : " + rset);
			
			list = new ArrayList<BoardFile>();
			System.out.println("list : " + list);
			
			while(rset.next()) {
				b = new Board();
				b.setBoardId(rset.getInt("board_id"));
				b.setBoardSort(rset.getString("board_sort"));
				b.setTitle(rset.getString("title"));
				b.setContent(rset.getString("content"));
				b.setBoardDate(rset.getDate("board_date"));
				b.setuCode(rset.getString("u_name"));
				b.setBuyInfoNo(rset.getInt("buy_info_no"));
				b.setRefBno(rset.getInt("ref_bno"));
				b.setbCount(rset.getInt("b_count"));
				b.setWriteYn(rset.getString("write_yn"));
				
				System.out.println(b);
				
				
				bf = new BoardFile();
				bf.setBoard_id(rset.getInt("board_id"));
				bf.setOrigin_name(rset.getString("origin_name"));
				bf.setEdit_name(rset.getString("edit_name"));
				bf.setFile_src(rset.getString("file_src"));
				bf.setFile_date(rset.getDate("file_date"));
				bf.setFile_no(rset.getInt("file_no"));
				bf.setBoard_sort(rset.getString("board_sort"));
				bf.setU_code(rset.getInt("u_code"));
				bf.setFile_level(rset.getInt("file_level"));
				
				
				System.out.println("bf");
				
				list.add(bf);
			}
			
			hmap = new HashMap<String, Object>();
			hmap.put("board", b);
			hmap.put("boardFile", list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return hmap;
	}

	

}
