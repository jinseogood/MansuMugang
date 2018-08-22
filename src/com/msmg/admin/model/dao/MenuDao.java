package com.msmg.admin.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.msmg.admin.model.vo.Menu;

import static com.msmg.common.JDBCTemplate.*;

public class MenuDao {
	private Properties prop=new Properties();
	
	public MenuDao(){
		String fileName=MenuDao.class.getResource("/sql/admin/admin-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int insertMenu(Menu menu, Connection con) {
		int result=0;
		PreparedStatement pst=null;
		
		String query=prop.getProperty("insertMenu");
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, menu.getMenuName());
			pst.setString(2, menu.getMainMat());
			pst.setString(3, menu.getSubMat());
			pst.setInt(4, menu.getPrice());
			
			result=pst.executeUpdate();
			
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pst);
		}
		
		return result;
	}

}
