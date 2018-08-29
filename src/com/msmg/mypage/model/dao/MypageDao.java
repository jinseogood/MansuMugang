package com.msmg.mypage.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.msmg.mypage.model.vo.BuyAll;

import static com.msmg.common.JDBCTemplate.*;

public class MypageDao {
	private Properties prop = new Properties();
	
	public MypageDao(){
		String fileName = MypageDao.class.getResource("/sql/mypage/mypage-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<BuyAll> selectBuyAll(Connection con, BuyAll ba) {
		ArrayList<BuyAll> bList = new ArrayList<BuyAll>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BuyAll b = null;
		
		
		String query = prop.getProperty("selectBuyAll");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, ba.getU_code());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){  
				b = new BuyAll();
				b.setBuy_no(rset.getInt("buy_no"));
				b.setU_code(rset.getString("u_code"));
				b.setMenu_code(rset.getString("menu_code"));
				b.setBuy_date(rset.getDate("buy_date"));
				b.setStatus(rset.getString("status"));
				b.setBuy_info_no(rset.getInt("buy_info_no"));
				b.setSort(rset.getString("sort"));
				b.setAmount(rset.getInt("amount"));
				b.setBuy_sort(rset.getString("buy_sort"));
				b.setPrice(rset.getInt("price"));
				
				bList.add(b);
				
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

}
