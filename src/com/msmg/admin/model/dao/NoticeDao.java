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

import com.msmg.admin.model.vo.Notice;

import static com.msmg.common.JDBCTemplate.*;

public class NoticeDao {
	private Properties prop=new Properties();
	
	public NoticeDao(){
		String fileName=NoticeDao.class.getResource("/sql/admin/admin-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<Notice> selectNoticeList(int currentPage, int limit, Connection con) {
		ArrayList<Notice> nList=new ArrayList<Notice>();
		//Statement st=null;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		//String query=prop.getProperty("selectNoticeList");
		String query=prop.getProperty("selectNoticeListPaging");
		
		try {
			//st=con.createStatement();
			//rset=st.executeQuery(query);
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pst=con.prepareStatement(query);
			pst.setInt(1, startRow);
			pst.setInt(2, endRow);
			
			rset=pst.executeQuery();
			
			while(rset.next()){
				Notice n=new Notice();
				
				n.setBoard_no(rset.getInt("board_no"));
				n.setTitle(rset.getString("title"));
				n.setU_name(rset.getString("u_name"));
				n.setContent(rset.getString("content"));
				n.setBoard_date(rset.getDate("board_date"));
				n.setB_count(rset.getInt("b_count"));
				
				nList.add(n);				
			}
			
			System.out.println("dao : " + nList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			//close(st);
			close(pst);
		}
		
		return nList;
	}

	public int getListCount(Connection con) {
		int listCount=0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("nListCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return listCount;
	}

	public int getSearchListCount(String type, String content, Connection con) {
		int listCount=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query="";
		
		if(type.equals("title")){
			query=prop.getProperty("nTitleCount");
		}
		else if(type.equals("u_name")){
			query=prop.getProperty("nUNameCount");
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

	public ArrayList<Notice> searchNoticeList(int currentPage, int limit, String type, String content, Connection con) {
		ArrayList<Notice> nSearchList=new ArrayList<Notice>();
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query="";
		
		if(type.equals("title")){
			query=prop.getProperty("searchNTitleListPaging");
		}
		else if(type.equals("u_name")){
			query=prop.getProperty("searchNUNameListPaging");
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
				Notice n=new Notice();
				
				n.setBoard_no(rset.getInt("board_no"));
				n.setTitle(rset.getString("title"));
				n.setU_name(rset.getString("u_name"));
				n.setContent(rset.getString("content"));
				n.setBoard_date(rset.getDate("board_date"));
				n.setB_count(rset.getInt("b_count"));
				
				nSearchList.add(n);				
			}
			
			System.out.println("dao : " + nSearchList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return nSearchList;
	}

}
