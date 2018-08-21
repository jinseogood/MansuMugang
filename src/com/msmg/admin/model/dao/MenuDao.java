package com.msmg.admin.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.msmg.admin.model.vo.Menu;

public class MenuDao {
	private Properties prop=new Properties();
	
	public MenuDao(){
		String fileName=MenuDao.class.getResource("sql/admin/admin-query.properties").getPath();
		
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

}
