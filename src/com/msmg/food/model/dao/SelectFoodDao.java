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

import com.msmg.food.model.vo.Menu;
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

	public ArrayList<Menu> selectFood(Connection con, SelectFood sf) {
		ArrayList<Menu> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "";
		
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
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Menu>();
			
			while(rset.next()){
				Menu m = new Menu();
				
				m.setImg_name(rset.getString("menu_img_name"));
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

}

