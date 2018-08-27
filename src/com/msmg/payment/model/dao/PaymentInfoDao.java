package com.msmg.payment.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.msmg.payment.model.vo.PaymentInfo;
import static com.msmg.common.JDBCTemplate.*;

public class PaymentInfoDao {
	
	private Properties prop = new Properties();

	public int insertPaymentInfo(Connection con, PaymentInfo pi) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = prop.getProperty("insertPaymentInfo");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, pi.getSort());
			pstmt.setInt(2,  pi.getBuy_no());
			pstmt.setInt(3,  pi.getAmount());
			pstmt.setString(4,  pi.getBuy_sort());
			
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
		
		
		
	}

}
