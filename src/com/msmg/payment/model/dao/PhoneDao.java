package com.msmg.payment.model.dao;
 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.msmg.payment.model.vo.Phone;
import static com.msmg.common.JDBCTemplate.*;

public class PhoneDao {
   
   private Properties prop = new Properties();
   
   public PhoneDao(){
      String fileName = PhoneDao.class.getResource("/sql/phone/phone-query.properties").getPath();
      
      try {
         prop.load(new FileReader(fileName));
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public int insertPhone(Connection con, Phone ph) {
      
      PreparedStatement pstmt = null;
      
      int result = 0;
      
      String query = prop.getProperty("insertPhone");
      try {
         pstmt = con.prepareStatement(query);
         pstmt.setString(1, ph.getTel());
         pstmt.setString(2, ph.getU_code());
         
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