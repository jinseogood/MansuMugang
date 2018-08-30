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
import com.msmg.board.information.model.vo.Reply;
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
		/*String query2 = prop.getProperty("AddPoint"); 포인트 값 증가*/
		
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

	public ArrayList<HashMap<String, Object>> selectReviewList(Connection con, int currentPage, int limit) {
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectReviewMap");
		
		try {
			
			pstmt = con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			System.out.println("reviewDao startRow : " + startRow);
			System.out.println("reviewDao endRow : " + endRow);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
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
				hmap.put("bcount", rset.getInt("b_count"));
				hmap.put("boardNo", rset.getInt("board_no"));
				hmap.put("adminYn", rset.getString("admin_Yn"));
				
				list.add(hmap);
			}
			
			System.out.println("review Dao list admin_Yn 확인 : " + list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
		}
		return list;
	}

	public HashMap<String, Object> selectOneReviewMap(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		ArrayList<BoardFile> list = null;
		Board b = null;
		BoardFile bf = null;
		
		System.out.println("selectOneReviewMap num : " + num);
		String query = prop.getProperty("selectReviewOne");
		
		try {
			System.out.println("BoardDao num : " + num);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(num));
			
			System.out.println("query : " + query);
			rset = pstmt.executeQuery();
			System.out.println("rset : " + rset);
			
			list = new ArrayList<BoardFile>();
			System.out.println("list : " + list);
			
			while(rset.next()) {
				b = new Board();
				b.setBoardId(rset.getInt("board_id"));
				b.setBoardNo(rset.getInt("board_no"));
				b.setBoardSort(rset.getString("board_sort"));
				b.setTitle(rset.getString("title"));
				b.setContent(rset.getString("content"));
				b.setBoardDate(rset.getDate("board_date"));
				b.setuCode(rset.getString("u_name"));
				b.setbCount(rset.getInt("b_count"));
				b.setWriteYn(rset.getString("write_yn"));
				b.setAdminYn(rset.getString("admin_yn"));
				
				System.out.println("b : " + b);
				
				bf = new BoardFile();
				bf.setBoard_id(rset.getInt("board_id"));
				bf.setOrigin_name(rset.getString("origin_name"));
				bf.setEdit_name(rset.getString("edit_name"));
				bf.setFile_src(rset.getString("file_src"));
				bf.setFile_date(rset.getDate("file_date"));
				bf.setFile_no(rset.getInt("file_no"));
				bf.setBoard_sort(rset.getString("board_sort"));
				bf.setFile_level(rset.getInt("file_level"));
				
				
				System.out.println("bf : " + bf);
				
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

	public ArrayList<Reply> selectReplyList(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Reply r = null;
		ArrayList<Reply> list = new ArrayList<Reply>();
		
		 
		String query = prop.getProperty("selectReplyList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);
			
			
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
			System.out.println("ReviewDao list : " + r);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
 		
		return list;
	}

	public int updateCount(Connection con, String num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		System.out.println("updateCount num : " + num);
		String query = prop.getProperty("updateCount");
		System.out.println("query : " + query);
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.setInt(2, Integer.parseInt(num));
			
			System.out.println("updateCount 쿼리 나옴");
			
			result = pstmt.executeUpdate();
			
			System.out.println("updateCount result : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteReview(Connection con, int bid) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteReview");
		
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

	public HashMap<String, Object> updateReview(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		ArrayList<BoardFile> list = null;
		Board b = null;
		BoardFile bf = null;
		
		String query = prop.getProperty("selectReviewUpdateForm");
		
		try {
			System.out.println("BoardDao num : " + num);
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(num));
			
			System.out.println("query : " + query);
			rset = pstmt.executeQuery();
			System.out.println("rset : " + rset);
			
			list = new ArrayList<BoardFile>();
			
			while(rset.next()) {
				b = new Board();
				b.setBoardId(rset.getInt("board_id"));
				b.setBoardNo(rset.getInt("board_no"));
				b.setTitle(rset.getString("title"));
				b.setContent(rset.getString("content"));
				b.setBoardDate(rset.getDate("board_date"));
				b.setuCode(rset.getString("u_name"));
				b.setbCount(rset.getInt("b_count"));
				b.setWriteYn(rset.getString("write_yn"));
				b.setBoardSort(rset.getString("board_sort"));
				
				
				System.out.println("b : " + b);
				
				bf = new BoardFile();
				bf.setOrigin_name(rset.getString("origin_name"));
				bf.setEdit_name(rset.getString("edit_name"));
				bf.setFile_src(rset.getString("file_src"));
				bf.setFile_date(rset.getDate("file_date"));
				bf.setFile_no(rset.getInt("file_no"));
				bf.setFile_level(rset.getInt("file_level"));
				bf.setFile_type(rset.getString("file_type"));
				
				System.out.println("bf : " + bf);
				
				list.add(bf);
			}
			
			
			hmap = new HashMap<String, Object>();
			hmap.put("board", b);
			hmap.put("boardFile", list);
			
			System.out.println("boardFile size : " + list.size());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return hmap;
	}

	public int updateReviewList(Connection con, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateReview");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getBoardId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		
		return result;
	}

	public int updateBoardFile(Connection con, ArrayList<BoardFile> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		System.out.println("updateBoardFile fileList : " + fileList);
		
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

	public int selectCurrval2(Connection con) {
		System.out.println("selectCurrval2넘어옴");
		
		Statement stmt = null;
		ResultSet rset = null;
		
		int bid = 0;
		
		System.out.println("쿼리문 작성2");
		String query = prop.getProperty("selectCurrval2");
		
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

	public int deleteReviewBoardFile(Connection con, String num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteReviewBoardFile");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, num);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBoardFile(Connection con, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBoardFile");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, b.getBoardId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


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

	public Board selectPreR(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		String query = prop.getProperty("selectPreReview");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(num));
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				b = new Board();
				b.setBoardId(rset.getInt("board_id"));
				b.setBoardNo(rset.getInt("board_no"));
				b.setBoardSort(rset.getString("board_sort"));
				b.setTitle(rset.getString("title"));
				b.setContent(rset.getString("content"));
				b.setBoardDate(rset.getDate("board_date"));
				b.setuCode(rset.getString("u_name"));
				b.setbCount(rset.getInt("b_count"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return b;
	}

	public Board selectNextR(Connection con, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		String query = prop.getProperty("selectNextReview");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(num));
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				b = new Board();
				
				b.setBoardId(rset.getInt("board_id"));
				b.setBoardNo(rset.getInt("board_no"));
				b.setBoardSort(rset.getString("board_sort"));
				b.setTitle(rset.getString("title"));
				b.setContent(rset.getString("content"));
				b.setBoardDate(rset.getDate("board_date"));
				b.setuCode(rset.getString("u_name"));
				b.setbCount(rset.getInt("b_count"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		
		return b;
	}

	public int updateAdmin(Connection con, String bid) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		System.out.println("reviewDao bid : " + bid);
		
		String query = prop.getProperty("updateAdminYn");
		
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
