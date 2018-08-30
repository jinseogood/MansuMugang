package com.msmg.admin.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static com.msmg.common.JDBCTemplate.*;

public class StatDao {
	private Properties prop=new Properties();
	
	public StatDao(){
		String fileName=StatDao.class.getResource("/sql/admin/admin-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int countCard(Connection con) {
		int payCard=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("cardPayCount");
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, "카드결제");
			
			rset=pst.executeQuery();
			
			if(rset.next()){
				payCard=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return payCard;
	}

	public int countMoney(Connection con) {
		int payMoney=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("moneyPayCount");
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, "무통장입금");
			
			rset=pst.executeQuery();
			
			if(rset.next()){
				payMoney=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return payMoney;
	}

}
