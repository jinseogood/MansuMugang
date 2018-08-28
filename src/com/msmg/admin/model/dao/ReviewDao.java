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

import com.msmg.admin.model.vo.Review;

import static com.msmg.common.JDBCTemplate.*;

public class ReviewDao {
	private Properties prop=new Properties();
	
	public ReviewDao(){
		String fileName=ReviewDao.class.getResource("/sql/admin/admin-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getListCount(Connection con) {
		int rListCount=0;
		Statement st=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("rListCount");
		
		try {
			st=con.createStatement();
			rset=st.executeQuery(query);
			
			if(rset.next()){
				rListCount=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rListCount;
	}
	public ArrayList<Review> selectReviewList(int currentPage, int limit, Connection con) {
		ArrayList<Review> rList=new ArrayList<Review>();
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("selectReviewListPaging");
		
		try {
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pst=con.prepareStatement(query);
			pst.setInt(1, startRow);
			pst.setInt(2, endRow);
			
			rset=pst.executeQuery();
			
			while(rset.next()) {
				Review r = new Review();
				
				r.setBoardId(rset.getInt("board_id"));
				r.setBoardNo(rset.getInt("board_no"));
				r.setBoardSort(rset.getString("board_sort"));
				r.setTitle(rset.getString("title"));
				r.setContent(rset.getString("content"));
				r.setBoardDate(rset.getDate("board_date"));
				r.setuCode(rset.getString("u_name"));
				r.setBuyInfoNo(rset.getInt("buy_info_no"));
				r.setRefBno(rset.getInt("ref_bno"));
				r.setbCount(rset.getInt("b_count"));
				r.setWriteYn(rset.getString("write_yn"));
				
				rList.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return rList;
	}
	public int getSearchListCount(String type, String content, Connection con) {
		int rSearchListCount=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query="";
		
		if(type.equals("title")){
			query=prop.getProperty("rTitleListCount");
		}
		else if(type.equals("u_name")){
			query=prop.getProperty("rUNameListCount");
		}
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, content);
			
			rset=pst.executeQuery();
			
			if(rset.next()){
				rSearchListCount=rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return rSearchListCount;
	}
	public ArrayList<Review> searchReviewList(int currentPage, int limit, String type, String content, Connection con) {
		ArrayList<Review> rSearchList=new ArrayList<Review>();
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query="";
		
		if(type.equals("title")){
			query=prop.getProperty("searchRTitleListPaging");
		}
		else{
			query=prop.getProperty("searchRUNameListPaging");
		}
		
		try {
			
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pst=con.prepareStatement(query);
			pst.setString(1, content);
			pst.setInt(2, startRow);
			pst.setInt(3, endRow);
			
			rset=pst.executeQuery();
			
			while(rset.next()) {
				Review r = new Review();
				
				r.setBoardId(rset.getInt("board_id"));
				r.setBoardNo(rset.getInt("board_no"));
				r.setBoardSort(rset.getString("board_sort"));
				r.setTitle(rset.getString("title"));
				r.setContent(rset.getString("content"));
				r.setBoardDate(rset.getDate("board_date"));
				r.setuCode(rset.getString("u_name"));
				r.setBuyInfoNo(rset.getInt("buy_info_no"));
				r.setRefBno(rset.getInt("ref_bno"));
				r.setbCount(rset.getInt("b_count"));
				r.setWriteYn(rset.getString("write_yn"));
				
				rSearchList.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return rSearchList;
	}

}
