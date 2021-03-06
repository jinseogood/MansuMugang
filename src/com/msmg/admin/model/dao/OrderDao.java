package com.msmg.admin.model.dao;

import static com.msmg.common.JDBCTemplate.*;

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

import com.msmg.admin.model.vo.Order;

public class OrderDao {
	private Properties prop=new Properties();
	
	public OrderDao(){
		String fileName=OrderDao.class.getResource("/sql/admin/admin-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getListCount(Connection con) {
		int listCount=0;
		Statement st=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("oListCount");
		
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

	public ArrayList<Order> selectOrderList(int currentPage, int limit, Connection con) {
		ArrayList<Order> oList=new ArrayList<Order>();
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("selectOrderListPaging");
		
		try {
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pst=con.prepareStatement(query);
			pst.setInt(1, startRow);
			pst.setInt(2, endRow);
			
			rset=pst.executeQuery();
			
			while(rset.next()){
				Order o=new Order();
				
				o.setDiet_no(rset.getString("diet_no"));
				o.setDiet_name(rset.getString("user_menu_name"));
				o.setU_name(rset.getString("u_name"));
				o.setBuy_date(rset.getDate("buy_date"));
				o.setStatus(rset.getString("buy_status"));
				
				oList.add(o);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return oList;
	}

	public int getSearchListCount(String type, String content, Connection con) {
		int oSearchListCount=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query="";
		
		if(type.equals("diet_no")){
			query=prop.getProperty("oDietNoListCount");
		}
		else if(type.equals("diet_name")){
			query=prop.getProperty("oDietNameListCount");
		}
		else if(type.equals("u_name")){
			query=prop.getProperty("oUNameListCount");
		}
		else if(type.equals("buy_date")){
			query=prop.getProperty("oBuyDateListCount");
		}
		else if(type.equals("status")){
			query=prop.getProperty("oBuyStatusListCount");
		}
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, content);
			
			rset=pst.executeQuery();
			
			if(rset.next()){
				oSearchListCount=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return oSearchListCount;
	}

	public ArrayList<Order> searchOrderList(int currentPage, int limit, String type, String content, Connection con) {
		ArrayList<Order> oSearchList=new ArrayList<Order>();
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query="";
		
		if(type.equals("diet_no")){
			query=prop.getProperty("searchODietNoListPaging");
		}
		else if(type.equals("diet_name")){
			query=prop.getProperty("searchODietNameListPaging");
		}
		else if(type.equals("u_name")){
			query=prop.getProperty("searchOUNameListPaging");
		}
		else if(type.equals("buy_date")){
			query=prop.getProperty("searchOBuyDateListPaging");
		}
		else if(type.equals("status")){
			query=prop.getProperty("searchOBuyStatusListPaging");
		}
		
		try {
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pst=con.prepareStatement(query);
			pst.setString(1, content);
			pst.setInt(2, startRow);
			pst.setInt(3, endRow);
			
			rset=pst.executeQuery();
			
			while(rset.next()){
				Order o=new Order();
				
				o.setDiet_no(rset.getString("diet_no"));
				o.setDiet_name(rset.getString("user_menu_name"));
				o.setU_name(rset.getString("u_name"));
				o.setBuy_date(rset.getDate("buy_date"));
				o.setStatus(rset.getString("buy_status"));
				
				oSearchList.add(o);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return oSearchList;
	}
	
	public int getSelectOneListCount(String dietNo, Connection con) {
		int listCount=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("oSelectListCount");
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, dietNo);
			
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

	public ArrayList<Order> selectOneOrderList(int currentPage, int limit, String dietNo, Connection con) {
		ArrayList<Order> oSelectOneList=new ArrayList<Order>();
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("selectOneOrderPaging");
		
		try {
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pst=con.prepareStatement(query);
			pst.setString(1, dietNo);
			pst.setInt(2, startRow);
			pst.setInt(3, endRow);
			
			rset=pst.executeQuery();
			
			while(rset.next()){
				Order o=new Order();
				
				o.setU_name(rset.getString("u_name"));
				o.setMenu_code(rset.getInt("menu_code"));
				o.setMenu_name(rset.getString("menu_name"));
				o.setBuy_date(rset.getDate("buy_date"));
				o.setStatus(rset.getString("buy_status"));
				o.setDiet_no(rset.getString("diet_no"));
				o.setPrice(rset.getInt("price"));
				o.setAmount(rset.getInt("amount"));
				
				oSelectOneList.add(o);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return oSelectOneList;
	}

	public int selectOneOrderPriceList(String dietNo, Connection con) {
		int totalPrice=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("oneOrderPrice");
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, dietNo);
			
			rset=pst.executeQuery();
			
			if(rset.next()){
				totalPrice=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return totalPrice;
	}

	public int updateStatus(String dietNo, String status, Connection con) {
		int result=0;
		PreparedStatement pst=null;
		
		String query=prop.getProperty("updateStatus");
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, status);
			pst.setString(2, dietNo);
			
			result=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pst);
		}
		
		return result;
	}

}
