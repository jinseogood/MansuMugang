package com.msmg.admin.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.msmg.admin.model.vo.Menu;
import com.msmg.admin.model.vo.MenuInfo;

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
		PreparedStatement pst2=null;
		
		String query=prop.getProperty("insertMenu");
		String query2=prop.getProperty("insertGradMenu");
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, menu.getMenuName());
			pst.setString(2, menu.getMainMat());
			pst.setString(3, menu.getSubMat());
			pst.setInt(4, menu.getPrice());
			
			result=pst.executeUpdate();
			
			if(!menu.getSubMat().equals("NO")){
				PreparedStatement pst2_sub=null;
				
				pst2=con.prepareStatement(query2);
				pst2.setInt(1, Integer.parseInt(menu.getMainMat()));
				
				int result2=pst2.executeUpdate();
				
				pst2_sub=con.prepareStatement(query2);
				pst2_sub.setInt(1, Integer.parseInt(menu.getSubMat()));
				
				int result2_sub=pst2_sub.executeUpdate();
			}
			else{
				pst2=con.prepareStatement(query2);
				pst2.setInt(1, Integer.parseInt(menu.getMainMat()));
				
				int result2=pst2.executeUpdate();
			}
			
			System.out.println(result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pst);
		}
		
		return result;
	}


	public ArrayList<Menu> selectMenuList(int currentPage, int limit, Connection con) {
		ArrayList<Menu> menuList=new ArrayList<Menu>();
		//Statement st=null;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		//String query=prop.getProperty("selectMenuList");
		String query=prop.getProperty("selectMenuListPaging");
		
		try {
			//st=con.createStatement();
			//rset=st.executeQuery(query);
			
			int startRow=(currentPage - 1) * limit + 1;
			int endRow=startRow + limit - 1;
			
			pst=con.prepareStatement(query);
			pst.setInt(1, startRow);
			pst.setInt(2, endRow);
			
			rset=pst.executeQuery();
			
			while(rset.next()){
				Menu m=new Menu();
				
				m.setMenuCode(Integer.parseInt(rset.getString("menu_code")));
				m.setMenuName(rset.getString("menu_name"));
				m.setMainMat(rset.getString("menu_main"));
				m.setSubMat(rset.getString("menu_sub"));
				m.setPrice(rset.getInt("price"));
				m.setMenuInfo(rset.getString("menu_info"));
				
				menuList.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			//close(st);
			close(pst);
		}
		
		return menuList;
	}


	public int selectCurrval(Connection con) {
		int menuCode=0;
		Statement st=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("selectCurrval");
		
		try {
			st=con.createStatement();
			rset=st.executeQuery(query);
			
			if(rset.next()){
				menuCode=rset.getInt("currval");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(st);
		}
		
		return menuCode;
	}


	public int insertMenuInfo(ArrayList<MenuInfo> fileList, Connection con) {
		int result=0;
		PreparedStatement pst=null;
		
		String query=prop.getProperty("insertMenuInfo");
		
		try {
			for(int i=0;i<fileList.size();i++){
				pst=con.prepareStatement(query);
				pst.setString(1, fileList.get(i).getOriginName());
				pst.setString(2, fileList.get(i).getFilePath());
				pst.setString(3, fileList.get(i).getInfo());
				pst.setString(4, fileList.get(i).getEditName());
				
				result+=pst.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pst);
		}
		
		return result;
	}


	public int getListCount(Connection con) {
		int listCount=0;
		Statement st=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("menulistCount");
		
		try {
			st=con.createStatement();
			rset=st.executeQuery(query);
			
			if(rset.next()){
				listCount=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(st);
		}
		
		return listCount;
	}


	public int getSearchListCount(String type, String content, Connection con) {
		int listCount=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		System.out.println("dao type : " + type);
		
		String query="";
		
		if(type.equals("menu_code")){
			query=prop.getProperty("menuCodeListCount");
		}
		else if(type.equals("menu_name")){
			query=prop.getProperty("menuNameListCount");
		}
		else if(type.equals("menu_main")){
			query=prop.getProperty("menuMainListCount");
		}
		else if(type.equals("menu_sub")){
			query=prop.getProperty("menuSubListCount");
		}
		else if(type.equals("menu_info")){
			query=prop.getProperty("menuInfoListCount");
		}
		else if(type.equals("price")){
			query=prop.getProperty("priceListCount");
		}
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, content);
			
			rset=pst.executeQuery();
			
			if(rset.next()){
				listCount=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return listCount;
	}


	public ArrayList<Menu> searchMenuList(int currentPage, int limit, String type, String content, Connection con) {
		ArrayList<Menu> menuSearchList=new ArrayList<Menu>();
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query="";
		
		if(type.equals("menu_code")){
			query=prop.getProperty("searchMenuCodeListPaging");
		}
		else if(type.equals("menu_name")){
			query=prop.getProperty("searchMenuNameListPaging");
		}
		else if(type.equals("menu_main")){
			query=prop.getProperty("searchMenuMainListPaging");
		}
		else if(type.equals("menu_sub")){
			query=prop.getProperty("searchMenuSubListPaging");
		}
		else if(type.equals("menu_info")){
			query=prop.getProperty("searchMenuInfoListPaging");
		}
		else if(type.equals("price")){
			query=prop.getProperty("searchPriceListPaging");
		}
		
		try {
			
			int startRow=(currentPage - 1) * limit + 1;
			int endRow=startRow + limit - 1;
			
			System.out.println("dao sql : " + query);
			
			pst=con.prepareStatement(query);
			pst.setString(1, content);
			pst.setInt(2, startRow);
			pst.setInt(3, endRow);
			
			rset=pst.executeQuery();
			
			while(rset.next()){
				Menu m=new Menu();
				
				m.setMenuCode(Integer.parseInt(rset.getString("menu_code")));
				m.setMenuName(rset.getString("menu_name"));
				m.setMainMat(rset.getString("menu_main"));
				m.setSubMat(rset.getString("menu_sub"));
				m.setPrice(rset.getInt("price"));
				m.setMenuInfo(rset.getString("menu_info"));
				
				menuSearchList.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return menuSearchList;
	}

}
