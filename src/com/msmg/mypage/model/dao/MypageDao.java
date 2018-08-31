package com.msmg.mypage.model.dao;
   
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
			
			System.out.println("pstmt uCode 담기 전 까진ㄴ????");
			pstmt.setString(1, ba.getU_code());
		
			System.out.println("알셋에 올리기 전 까진 오냐???????????????????");
			rset = pstmt.executeQuery();
		
			bList = new ArrayList<BuyAll>();
			System.out.println("여기까지라도 오냐고");
			
			if(rset.next()){
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

}
