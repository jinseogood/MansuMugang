package com.msmg.admin.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.msmg.admin.model.vo.Stat;

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

	public int countGo(Connection con) {
		int dietGoCount=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("dietGoCount");
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, "고");
			
			rset=pst.executeQuery();
			
			if(rset.next()){
				dietGoCount=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return dietGoCount;
	}

	public int countDang(Connection con) {
		int dietDangCount=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("dietDangCount");
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, "당");
			
			rset=pst.executeQuery();
			
			if(rset.next()){
				dietDangCount=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return dietDangCount;
	}

	public int countHead(Connection con) {
		int dietHeadCount=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("dietHeadCount");
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, "뇌");
			
			rset=pst.executeQuery();
			
			if(rset.next()){
				dietHeadCount=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return dietHeadCount;
	}

	public int countGD(Connection con) {
		int dietGDCount=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("dietGDCount");
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, "고");
			pst.setString(2, "당");
			
			rset=pst.executeQuery();
			
			if(rset.next()){
				dietGDCount=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return dietGDCount;
	}

	public int countGH(Connection con) {
		int dietGHCount=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("dietGHCount");
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, "고");
			pst.setString(2, "뇌");
			
			rset=pst.executeQuery();
			
			if(rset.next()){
				dietGHCount=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return dietGHCount;
	}

	public int countDH(Connection con) {
		int dietDHCount=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("dietDHCount");
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, "당");
			pst.setString(2, "뇌");
			
			rset=pst.executeQuery();
			
			if(rset.next()){
				dietDHCount=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return dietDHCount;
	}

	public int countGDH(Connection con) {
		int dietGDHCount=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("dietGDHCount");
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, "고");
			pst.setString(2, "당");
			pst.setString(3, "뇌");
			
			rset=pst.executeQuery();
			
			if(rset.next()){
				dietGDHCount=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return dietGDHCount;
	}

	public ArrayList<Stat> countMenu(Connection con) {
		ArrayList<Stat> mStatList=new ArrayList<Stat>();
		Statement st=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("countMenu");
		
		try {
			st=con.createStatement();
			rset=st.executeQuery(query);
			
			while(rset.next()){
				Stat s=new Stat();
				
				s.setMenu_name(rset.getString("menu_name"));
				s.setSale_count(rset.getInt("sale_count"));
				
				mStatList.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(st);
		}
		
		return mStatList;
	}

}
