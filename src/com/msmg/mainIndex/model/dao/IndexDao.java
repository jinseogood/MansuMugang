package com.msmg.mainIndex.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.msmg.mainIndex.model.vo.MenuIndex;
import static com.msmg.common.JDBCTemplate.*;

public class IndexDao {
	Properties prop = new Properties();

	public IndexDao(){
		String fileName = IndexDao.class.getResource("/sql/Index/Index-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<MenuIndex> selectGoTopMenu(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<MenuIndex> list = new ArrayList<MenuIndex>();
		MenuIndex mi = null;
		
		String query = prop.getProperty("selectGoTopMenu");
		
		try {
			stmt = conn.createStatement();
		
			rset = stmt.executeQuery(query);
			
			while(rset.next()){
				mi = new MenuIndex();
				
				mi.setMenu_code(rset.getInt("menu_code"));
				mi.setMenu_img_ename(rset.getString("menu_img_ename"));
				mi.setMenu_img_oname(rset.getString("menu_img_oname"));
				mi.setMenu_img_src(rset.getString("menu_img_src"));
				mi.setMenu_info(rset.getString("menu_info"));
				mi.setMenu_main(rset.getString("menu_main"));
				mi.setMenu_name(rset.getString("menu_name"));
				mi.setMenu_sub(rset.getString("menu_sub"));
				mi.setPrice(rset.getInt("price"));
				mi.setSale_count(rset.getInt("sale_count"));
				
				list.add(mi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return list;
	}

	public ArrayList<MenuIndex> selectDangTopMenu(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<MenuIndex> list = new ArrayList<MenuIndex>();
		MenuIndex mi = null;
		
		String query = prop.getProperty("selectDangTopMenu");
		
		try {
			stmt = conn.createStatement();
		
			rset = stmt.executeQuery(query);
			
			while(rset.next()){
				mi = new MenuIndex();
				
				mi.setMenu_code(rset.getInt("menu_code"));
				mi.setMenu_img_ename(rset.getString("menu_img_ename"));
				mi.setMenu_img_oname(rset.getString("menu_img_oname"));
				mi.setMenu_img_src(rset.getString("menu_img_src"));
				mi.setMenu_info(rset.getString("menu_info"));
				mi.setMenu_main(rset.getString("menu_main"));
				mi.setMenu_name(rset.getString("menu_name"));
				mi.setMenu_sub(rset.getString("menu_sub"));
				mi.setPrice(rset.getInt("price"));
				mi.setSale_count(rset.getInt("sale_count"));
				
				list.add(mi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return list;
	}

	public ArrayList<MenuIndex> selectHeadTopMenu(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<MenuIndex> list = new ArrayList<MenuIndex>();
		MenuIndex mi = null;
		
		String query = prop.getProperty("selectHeadTopMenu");
		
		try {
			stmt = conn.createStatement();
		
			rset = stmt.executeQuery(query);
			
			while(rset.next()){
				mi = new MenuIndex();
				
				mi.setMenu_code(rset.getInt("menu_code"));
				mi.setMenu_img_ename(rset.getString("menu_img_ename"));
				mi.setMenu_img_oname(rset.getString("menu_img_oname"));
				mi.setMenu_img_src(rset.getString("menu_img_src"));
				mi.setMenu_info(rset.getString("menu_info"));
				mi.setMenu_main(rset.getString("menu_main"));
				mi.setMenu_name(rset.getString("menu_name"));
				mi.setMenu_sub(rset.getString("menu_sub"));
				mi.setPrice(rset.getInt("price"));
				mi.setSale_count(rset.getInt("sale_count"));
				
				list.add(mi);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return list;
	}

}
