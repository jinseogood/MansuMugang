package com.msmg.payment.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.msmg.payment.model.vo.Payment;

import static com.msmg.common.JDBCTemplate.*;

public class PaymentDao {
	
	private Properties prop = new Properties();

	public int updateOrder(Connection con, Payment p) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateOrder");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, p.getStatus());
			pstmt.setInt(2, p.getBuy_no());
			
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
