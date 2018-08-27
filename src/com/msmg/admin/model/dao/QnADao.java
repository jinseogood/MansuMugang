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

import com.msmg.admin.model.vo.QnA;

import static com.msmg.common.JDBCTemplate.*;

public class QnADao {
	private Properties prop=new Properties();
	
	public QnADao(){
		String fileName=QnADao.class.getResource("/sql/admin/admin-query.properties").getPath();
		
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
		
		String query=prop.getProperty("qnaListCount");
		
		try {
			st=con.createStatement();
			rset=st.executeQuery(query);
			
			if(rset.next()){
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(st);
		}
		
		return listCount;
	}
	public ArrayList<QnA> selectQnAList(int currentPage, int limit, Connection con) {
		ArrayList<QnA> qList=new ArrayList<QnA>();
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("selectQnAListPaging");
		
		try {
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pst=con.prepareStatement(query);
			pst.setInt(1, startRow);
			pst.setInt(2, endRow);
			
			rset=pst.executeQuery();
			
			while(rset.next()){
				QnA qna=new QnA();
				
				qna.setBoard_id(rset.getInt("board_id"));
				qna.setBoard_no(rset.getInt("board_no"));
				qna.setTitle(rset.getString("title"));
				qna.setContent(rset.getString("content"));
				qna.setU_name(rset.getString("u_name"));
				qna.setBoard_date(rset.getDate("board_date"));
				qna.setB_count(rset.getInt("b_count"));
				qna.setRef_bno(rset.getInt("ref_bno"));
				
				qList.add(qna);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return qList;
	}
	
	public int getSearchListCount(String type, String content, Connection con) {
		int listCount=0;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query="";
		
		if(type.equals("title")){
			query=prop.getProperty("qTitleListCount");
		}
		else if(type.equals("u_name")){
			query=prop.getProperty("qUNameListCount");
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
	public ArrayList<QnA> searchQnAList(int currentPage, int limit, String type, String content, Connection con) {
		ArrayList<QnA> qSearchList=new ArrayList<QnA>();
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query="";
		
		if(type.equals("title")){
			query=prop.getProperty("searchQTitleListPaging");
		}
		else if(type.equals("u_name")){
			query=prop.getProperty("searchQUNameListPaging");
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
				QnA qna=new QnA();
				
				qna.setBoard_id(rset.getInt("board_id"));
				qna.setBoard_no(rset.getInt("board_no"));
				qna.setTitle(rset.getString("title"));
				qna.setContent(rset.getString("content"));
				qna.setU_name(rset.getString("u_name"));
				qna.setBoard_date(rset.getDate("board_date"));
				qna.setB_count(rset.getInt("b_count"));
				qna.setRef_bno(rset.getInt("ref_bno"));
				
				qSearchList.add(qna);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return qSearchList;
	}

}
