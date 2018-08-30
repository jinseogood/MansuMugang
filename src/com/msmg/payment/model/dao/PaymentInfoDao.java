package com.msmg.payment.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.msmg.payment.model.vo.PaymentInfo;
import static com.msmg.common.JDBCTemplate.*;

public class PaymentInfoDao {
	
	private Properties prop = new Properties();
	
	public PaymentInfoDao(){
	      String fileName = PaymentInfoDao.class.getResource("/sql/payment/paymentInfo-query.properties").getPath();
	      
	      try {
	         prop.load(new FileReader(fileName));
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   
	}

	public int insertPaymentInfo(Connection con, PaymentInfo pi) {
		
		PreparedStatement pstmt = null; 
/*		PreparedStatement pstmt2 = null;*/
		
		int result = 0;
		
		String query = prop.getProperty("insertPaymentInfo");
/*		String query2 = prop.getProperty("updateMenuCount");*/
		 
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, pi.getSort());
			pstmt.setString(2,  pi.getBuy_sort());
			pstmt.setString(3, pi.getDiet_no());
			
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
