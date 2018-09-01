package com.msmg.mypage.model.dao;
   
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.msmg.mypage.model.vo.Board;
import com.msmg.mypage.model.vo.BuyAll;

import static com.msmg.common.JDBCTemplate.*;

public class MypageDao {
	private Properties prop = new Properties();
	
	public MypageDao(){
		String fileName = MypageDao.class.getResource("/sql/mypage/mypage-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<BuyAll> selectBuyAll(Connection con, BuyAll ba) {
		System.out.println("마페 다오에 옴 ");
		ArrayList<BuyAll> bList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BuyAll b = null;
		
		System.out.println("마페다오에 바이올 ba 잘왔나 확인 : " + ba);
		
		String query = prop.getProperty("selectBuyAll");
		System.out.println(query);
		
		try {
			System.out.println("트라이캐치 안들어오지!!!!");
			pstmt = con.prepareStatement(query);
			
			System.out.println("pstmt uCode 담기 전 까진ㄴ????" + ba.getU_code());
			pstmt.setString(1, ba.getU_code());
		
			System.out.println("알셋에 올리기 전 까진 오냐???????????????????");
			rset = pstmt.executeQuery();
		
			bList = new ArrayList<BuyAll>();
			System.out.println("여기까지라도 오냐고");
			
			while(rset.next()){
				b = new BuyAll();
				
				b.setU_code(rset.getString("u_code"));
				b.setBuy_date(rset.getDate("buy_date"));
				b.setStatus(rset.getString("status"));
				b.setDiet_no(rset.getString("diet_no"));
				b.setPrice(rset.getInt("price2"));
				b.setUser_menu_name(rset.getString("user_menu_name"));
				b.setBuy_sort(rset.getString("buy_sort"));
				b.setBuy_status(rset.getString("buy_status"));
				
				System.out.println("와일문 안에 객체 b : " + b);
				bList.add(b);
				
				System.out.println("bList 에드한담에 : " + bList);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
			
		}
		
		System.out.println("마이페이지다오에서 bList(리턴전) : " + bList);
		
		return bList;
	}

	public ArrayList<Board> selectBoard(Connection con, Board b) {
		ArrayList<Board> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board board = null;
		
		String query = prop.getProperty("selectBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getU_code());
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			
			
			while(rset.next()){
				board = new Board();
				
				board.setBoard_no(rset.getInt("board_no"));
				board.setBoard_sort(rset.getString("board_sort"));
				board.setTitle(rset.getString("title"));
				board.setContent(rset.getString("content"));
				board.setBoard_date(rset.getDate("board_date"));
				board.setU_code(rset.getString("u_code"));
				board.setBuy_info_num(rset.getInt("buy_info_num"));
				board.setB_count(rset.getInt("b_count"));
				board.setRef_bno(rset.getInt("ref_bno"));
				board.setBoard_id(rset.getInt("board_id"));
				board.setWrite_yn(rset.getString("write_yn"));
				board.setAdmin_yn(rset.getString("admin_yn"));
				
				list.add(board);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}
		
		
		
		
		
		
		
		return list;
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
				
				b.setBoard_id(rset.getInt("board_id"));
				b.setBoard_no(rset.getInt("board_no"));
				b.setBoard_sort(rset.getString("board_sort"));
				b.setTitle(rset.getString("title"));
				b.setContent(rset.getString("content"));
				b.setBoard_date(rset.getDate("board_date"));
				b.setU_code(rset.getString("u_name"));
				b.setBuy_info_num(rset.getInt("buy_info_no"));
				b.setRef_bno(rset.getInt("ref_bno"));
				b.setB_count(rset.getInt("b_count"));
				b.setWrite_yn(rset.getString("write_yn"));
				
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

}
