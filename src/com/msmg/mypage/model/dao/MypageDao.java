package com.msmg.mypage.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import com.msmg.mypage.model.vo.BuyAll;

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
		
		String query = prop.getProperty("selectBuyAll");
		
		
		return null;
	}

}
