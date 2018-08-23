package com.msmg.admin.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
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

	public ArrayList<Notice> selectNoticeList(Connection con) {
		ArrayList<Notice> nList=new ArrayList<Notice>();
		Statement st=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("selectNoticeList");
		
		try {
			st=con.createStatement();
			rset=st.executeQuery(query);
			
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
			close(st);
		}
		
		return nList;
	}

}
