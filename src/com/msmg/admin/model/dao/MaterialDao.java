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

import com.msmg.admin.model.vo.Material;

import static com.msmg.common.JDBCTemplate.*;

public class MaterialDao {
	private Properties prop=new Properties();
	
	public MaterialDao(){
		String fileName=MaterialDao.class.getResource("/sql/admin/admin-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int insertMaterial(Material m, Connection con) {
		int result=0;
		PreparedStatement pst=null;
		
		String query=prop.getProperty("insertMaterial");
		
		try {
			pst=con.prepareStatement(query);
			pst.setString(1, m.getM_name());
			pst.setString(2, m.getA_code());
			pst.setString(3, m.getD_go());
			pst.setString(4, m.getD_dang());
			pst.setString(5, m.getD_head());
			
			result=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pst);
		}
		
		return result;
	}


	public ArrayList<Material> selectMatList(int currentPage, int limit, Connection con) {
		ArrayList<Material> matList=new ArrayList<Material>();
		//Statement st=null;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		//String query=prop.getProperty("selectMatList");
		String query=prop.getProperty("selectMatListPaging");
		
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
				Material m=new Material();
				
				m.setM_code(rset.getString("grad_code"));
				m.setM_name(rset.getString("grad_name"));
				m.setA_code(rset.getString("al_code"));
				m.setD_go(rset.getString("go"));
				m.setD_dang(rset.getString("dang"));
				m.setD_head(rset.getString("head"));
				
				matList.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			//close(st);
			close(pst);
		}
		
		return matList;
	}


	//페이징 처리 시 게시판 글 수 확인용 메소드
	public int getListCount(Connection con) {
		int listCount=0;
		Statement st=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("matlistCount");
		
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


	public ArrayList<Material> selectMatList(Connection con) {
		ArrayList<Material> matList=new ArrayList<Material>();
		Statement st=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("selectMatList");
		
		try {
			st=con.createStatement();
			rset=st.executeQuery(query);
			
			while(rset.next()){
				Material mat=new Material();
				
				mat.setM_code(rset.getString("grad_code"));
				mat.setM_name(rset.getString("grad_name"));
				mat.setA_code(rset.getString("al_code"));
				mat.setD_go(rset.getString("go"));
				mat.setD_dang(rset.getString("dang"));
				mat.setD_head(rset.getString("head"));
				
				matList.add(mat);				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(st);
		}
		
		
		return matList;
	}

}
