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

import com.msmg.admin.model.vo.Info;

public class InfoDao {
	private Properties prop=new Properties();
	
	public InfoDao(){
		String fileName=InfoDao.class.getResource("/sql/admin/admin-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("infoListCount");
		
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

	public ArrayList<Info> selectInfoList(int currentPage, int limit, Connection con) {
		ArrayList<Info> infoList=new ArrayList<Info>();
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("selectInfoListPaging");
		
		try {
			
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pst=con.prepareStatement(query);
			pst.setInt(1, startRow);
			pst.setInt(2, endRow);
			
			rset=pst.executeQuery();
			
			while(rset.next()) {
				Info info = new Info();
				
				info.setBoardId(rset.getInt("board_id"));
				info.setBoardNo(rset.getInt("board_no"));
				info.setBoardSort(rset.getString("board_sort"));
				info.setTitle(rset.getString("title"));
				info.setContent(rset.getString("content"));
				info.setBoardDate(rset.getDate("board_date"));
				info.setuCode(rset.getString("u_name"));
				info.setBuyInfoNo(rset.getInt("buy_info_no"));
				info.setRefBno(rset.getInt("ref_bno"));
				info.setbCount(rset.getInt("b_count"));
				info.setWriteYn(rset.getString("write_yn"));
				
				infoList.add(info);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return infoList;
	}

}
