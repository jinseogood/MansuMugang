package com.msmg.payment.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.msmg.payment.model.vo.Payment;

import static com.msmg.common.JDBCTemplate.*;

public class PaymentDao {
	
	private Properties prop = new Properties();
	
	   public PaymentDao(){
		      String fileName = PhoneDao.class.getResource("/sql/payment/payment-query.properties").getPath();
		       
		      try {
		         prop.load(new FileReader(fileName));
		      } catch (FileNotFoundException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      }
		   }

	public int updateOrder(Connection con, Payment p) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateOrder");
		System.out.println("updateOrder Dao 실행");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, p.getDiet_no());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		System.out.println(result);
		return result;
		
	} 

}
