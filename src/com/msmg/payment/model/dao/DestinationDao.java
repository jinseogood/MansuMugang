package com.msmg.payment.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.msmg.payment.model.vo.Destination;
import static com.msmg.common.JDBCTemplate.*;

public class DestinationDao {
	private Properties prop = new Properties();
	 
	public DestinationDao(){
		String fileName = DestinationDao.class.getResource("/sql/destination/destination-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public int insertDestination(Connection con, Destination d) {
		
		PreparedStatement pstmt = null;

		int result = 0;
		
		String query = prop.getProperty("insertDestination");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, d.getDestionation());
			pstmt.setString(2, d.getU_code());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
		
	}

/*	public Destination selectOne(Connection con, String u_code) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Destination d = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, u_code);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				d = new Destination();
				
				d.setDestionation(rset.getString("destination"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return d;
		
		
	}*/

	public ArrayList<Destination> selectList(Connection con, String u_code) {

		ArrayList<Destination> list = new ArrayList<Destination>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Destination d = null;
		
		String query = prop.getProperty("selectList");
		 
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1,  u_code);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				d = new Destination();
				
				d.setDestination_no(rset.getInt("destination_no"));
				d.setDestionation(rset.getString("des"));
				
				list.add(d);
			}
			
			System.out.println("dao:" + list);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
		
	}


	
	
	
	
	
	
	
}
