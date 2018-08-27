package com.msmg.food.model.dao;

import static com.msmg.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import com.msmg.food.model.vo.Buy;
import com.msmg.food.model.vo.Menu;
import com.msmg.food.model.vo.MenuList;
import com.msmg.food.model.vo.SelectFood;

public class SelectFoodDao {
	private Properties prop = new Properties();
	
	public SelectFoodDao(){
		String fileName = SelectFoodDao.class.getResource("/sql/food/food-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Menu> selectFood(Connection con, SelectFood sf, int user) {
		ArrayList<Menu> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "";
		Menu m = null;
		
		try {
			if(sf.getGo() == 1 && sf.getDang() == 0 && sf.getHead() == 0){
				//query = prop.getProperty("selectFoodALL");
				query = prop.getProperty("selectFoodGo");
			}else if(sf.getGo() == 0 && sf.getDang() == 1 && sf.getHead() == 0){
				query = prop.getProperty("selectFoodDang");
			}else if(sf.getGo() == 0 && sf.getDang() == 0 && sf.getHead() == 1){
				query = prop.getProperty("selectFoodHead");
			}else if(sf.getGo() == 1 && sf.getDang() == 1 && sf.getHead() == 0){
				query = prop.getProperty("selectFoodGoDang");
			}else if(sf.getGo() == 1 && sf.getDang() == 0 && sf.getHead() == 1){
				query = prop.getProperty("selectFoodGoHead");
			}else if(sf.getGo() == 0 && sf.getDang() == 1 && sf.getHead() == 1){
				query = prop.getProperty("selectFoodDangHead");
			}else{
				query = prop.getProperty("selectFoodGoDangHead");
			}
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, user);
			
			rset = pstmt.executeQuery();
			
	
			list = new ArrayList<Menu>();
			
			while(rset.next()){
				m = new Menu();
				
				m.setImg_name(rset.getString("menu_img_ename"));
				m.setImg_src(rset.getString("menu_img_src"));
				m.setInfo(rset.getString("menu_info"));
				m.setName(rset.getString("menu_name"));
				m.setMain_grad(rset.getString("menu_main"));
				m.setSub_grad(rset.getString("menu_sub"));
				m.setPrice(rset.getInt("price"));
				m.setMenu_code(rset.getString("menu_code"));
				
				list.add(m);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertMenuBuy(Connection con, ArrayList<Buy> list) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertMenuBuy");
		
		long time = System.currentTimeMillis();
		 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddhhmmss");
		 
		String nowTime = dayTime.format(new Date(time));
		
		String user_date = nowTime+list.get(0).getUcode();
		
		for(int i = 0 ; i < list.size() ; i++){
			try {
				pstmt = con.prepareStatement(query);
			
				pstmt.setString(1, list.get(i).getUcode());
				pstmt.setString(2, list.get(i).getMcode());
				pstmt.setString(3, user_date);
			
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				close(pstmt);
			}
		}
		return result;
	}

	public ArrayList<MenuList> menuListG(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MenuList> list = null;
		String query = prop.getProperty("menuListG");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			if(rset != null){
				list = new ArrayList<MenuList>();
				
				while(rset.next()){
					MenuList ml = new MenuList();
					
					ml.setMenu_info(rset.getString("menu_info"));
					ml.setImg_name(rset.getString("menu_img_ename"));
					ml.setMenu_name(rset.getString("menu_name"));
					ml.setMenu_code(rset.getString("menu_code"));
					
					list.add(ml);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<MenuList> menuListD(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MenuList> list = null;
		String query = prop.getProperty("menuListD");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			if(rset != null){
				list = new ArrayList<MenuList>();
				
				while(rset.next()){
					MenuList ml = new MenuList();
					
					ml.setMenu_info(rset.getString("menu_info"));
					ml.setImg_name(rset.getString("menu_img_ename"));
					ml.setMenu_name(rset.getString("menu_name"));
					ml.setMenu_code(rset.getString("menu_code"));
					
					list.add(ml);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<MenuList> menuListH(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MenuList> list = null;
		String query = prop.getProperty("menuListH");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			
			if(rset != null){
				list = new ArrayList<MenuList>();
				
				while(rset.next()){
					MenuList ml = new MenuList();
					
					ml.setMenu_info(rset.getString("menu_info"));
					ml.setImg_name(rset.getString("menu_img_ename"));
					ml.setMenu_name(rset.getString("menu_name"));
					ml.setMenu_code(rset.getString("menu_code"));
					
					list.add(ml);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertLike(Connection con, int u_code, int m_code) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertLike");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, u_code);
			pstmt.setInt(2, m_code);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
	}

	public int deleteLike(Connection con, int u_code, int m_code) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteLike");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, u_code);
			pstmt.setInt(2, m_code);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
		}
		
		return result;
	}

}

