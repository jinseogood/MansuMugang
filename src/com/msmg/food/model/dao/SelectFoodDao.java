package com.msmg.food.model.dao;

import static com.msmg.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		
		for(int i = 0 ; i < list.size() ; i++){
			try {
				pstmt = con.prepareStatement(query);
			
				pstmt.setString(1, list.get(i).getUcode());
				pstmt.setString(2, list.get(i).getMcode());
			
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

}

