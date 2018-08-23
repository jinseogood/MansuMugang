package com.msmg.board.qna.model.dao;

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

import com.msmg.board.qna.model.vo.Attachment;
import com.msmg.board.qna.model.vo.Qna;
import com.msmg.board.notice.model.vo.Notice;

public class QnaDao {
	private Properties prop = new Properties();
	
	public QnaDao(){
		String fileName = QnaDao.class.getResource("/sql/board/qna/qna-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getAdminCode(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int code = 0;
		
		String query = prop.getProperty("getAdminCode");
		
		try {
			stmt = conn.createStatement();
		
			rset = stmt.executeQuery(query);
			
			if(rset.next()){
				code = rset.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return code;
	}
	
	public int getListCount(Connection conn, int adminCode, int code) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getListCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, adminCode);
			pstmt.setInt(2, code);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<Qna> selectList(Connection conn, int currentPage, int pageLimit, int adminCode, int code) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Qna> list = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			int startRow = (currentPage - 1) * pageLimit + 1;
			int endRow = startRow + pageLimit - 1;
			
			System.out.println(startRow + " + " + endRow);
			
			pstmt.setInt(1, adminCode);
			pstmt.setInt(2, code);
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Qna>();
			
			while(rset.next()){
				Qna qna = new Qna();
				
				qna.setBoard_id(rset.getInt("board_id"));
				qna.setBoard_no(rset.getInt("board_no"));
				qna.setTitle(rset.getString("title"));
				qna.setContent(rset.getString("content"));
				qna.setU_name(rset.getString("u_name"));
				qna.setBoard_date(rset.getDate("board_date"));
				qna.setB_count(rset.getInt("b_count"));
				
				list.add(qna);
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
	public Qna selectOne(Connection conn, int bid) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Qna qna = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bid);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				qna = new Qna();
				
				qna.setBoard_id(rset.getInt("board_id"));
				qna.setTitle(rset.getString("title"));
				qna.setContent(rset.getString("content"));
				qna.setB_count(rset.getInt("b_count"));
				qna.setBoard_date(rset.getDate("board_date"));
				qna.setU_name(rset.getString("u_name"));
				qna.setBoard_no(rset.getInt("board_no"));
				qna.setRef_ucode(rset.getInt("ref_ucode"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return qna;
	}
	
	public int insertQna(Connection conn, int ucode) {
		PreparedStatement pstmt = null;
		int result = 0;
		int rand = new Random().nextInt(1000) + 1;
		
		
		String query = prop.getProperty("insertQna");
		
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
		
			return result;
	}
	
	public int insertImg(Connection conn, Attachment at) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, at.getOriginName());
			pstmt.setString(2, at.getChangeName());
			pstmt.setString(3, at.getFilePath());
			pstmt.setInt(4, at.getBoard_no());
			pstmt.setInt(5, at.getU_code());
			
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
		
		String query = prop.getProperty("deleteQna");
		
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
	public int updateQna(Connection conn, String title, String content, int bid, int nowBno) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateQna");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3,nowBno);
			pstmt.setInt(4, bid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public int selectNowBno(Connection conn, int ucode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int bid = 0;
		
		String query = prop.getProperty("selectNowBno");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ucode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				bid = rset.getInt(1);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
			
		}
		
		
		return bid;
	}
	
	public int updatePhotho(Connection conn, int bid, int ucode, int nowBno) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatePhoto");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, nowBno);
			pstmt.setInt(2, bid);
			pstmt.setInt(3, ucode);
			
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
	public int selectPhoto(Connection conn, int bid, int ucode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectPhotoCount");
		
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bid);
			pstmt.setInt(2, ucode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				System.out.println("selectPhoto : " + rset.getString(1));
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
	public int updateCount(Connection conn, int bid) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bid);
			pstmt.setInt(2, bid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<Attachment> selectAttachment(Connection conn, String bno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = null;
		
		String query = prop.getProperty("selectAttach");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				list = new ArrayList<Attachment>();
				Attachment at = new Attachment();
				
				at.setBoard_no(rset.getInt("board_no"));
				at.setBoard_sort(rset.getString("board_sort"));
				at.setChangeName(rset.getString("edit_name"));
				at.setFid(rset.getInt("file_no"));
				at.setFilePath(rset.getString("file_src"));
				at.setOriginName(rset.getString("origin_name"));
				at.setUploadDate(rset.getDate("file_date"));
				
				list.add(at);
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
	public Attachment selectOneAttachment(Connection conn, String editName) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Attachment at = null;
		
		String query = prop.getProperty("selectOneAttach");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, editName);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				at = new Attachment();
				
				at.setBoard_no(rset.getInt("board_no"));
				at.setBoard_sort(rset.getString("board_sort"));
				at.setChangeName(rset.getString("edit_name"));
				at.setFid(rset.getInt("file_no"));
				at.setFilePath(rset.getString("file_src"));
				at.setOriginName(rset.getString("origin_name"));
				at.setUploadDate(rset.getDate("file_date"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return at;
	}
	public Qna selectOneEdit(Connection conn, String num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Qna qna = null;
		
		String query = prop.getProperty("selectOneEdit");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, num);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				qna = new Qna();
				
				qna.setBoard_id(rset.getInt("board_id"));
				qna.setBoard_no(rset.getInt("board_no"));
				qna.setContent(rset.getString("content"));
				qna.setTitle(rset.getString("title"));
				
			}
			
			System.out.println(qna);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return qna;
	}
	public int deleteDocument(Connection conn, int board_no) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteDocument");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, String.valueOf(board_no));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	public int editQna(Connection conn, int bid, String title, String content) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("editQna");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public ArrayList<String> selectChangeName(Connection conn, int bno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<String> list = new ArrayList<String>();
		
		String query = prop.getProperty("selectChangeName");
		System.out.println("변화값 받아옴");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bno);
			
			System.out.println("쿼리 수행");
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				String name = rset.getString(1);
				
				list.add(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(list.size() > 0){
			return list;
		}else{
			return null;
		}
	}
	public int DeleteNotice(Connection conn, String bno) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		
		return 0;
	}
	public ArrayList<String> selectDoc(Connection conn, int bno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<String> list = new ArrayList<String>();
		
		String query = prop.getProperty("selectDoc");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				String name = rset.getString(1);
				
				list.add(name);
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
	public int selectPho(Connection conn, int bid) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("selectPhoto");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bid);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
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
	public int deletePhoto(Connection conn, int bid) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deletePhoto");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, String.valueOf(bid));
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	public int DeleteQna(Connection conn, int bid) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteQna");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectBid(Connection conn, int ucode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int result = 0;
		
		String query = prop.getProperty("selectBid");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ucode);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
	}

	public int insertReQna(Connection conn, int ucode, int bid) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReQna");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ucode);
			pstmt.setInt(2, bid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
			return result;
	}

	public int updateReQna(Connection conn, String title, String content, int bid, int num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateReQna");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3,	num);
			pstmt.setInt(4, bid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	

}