package com.msmg.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.msmg.member.model.vo.Member;
import com.msmg.member.model.vo.UserAllergy;

import static com.msmg.common.JDBCTemplate.*;

public class MemberDao {
	private Properties prop = new Properties();
	
	public MemberDao(){
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();

		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Member insertMember(Connection con, Member m) {
		Member member = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("insertMember");
		String query2 = prop.getProperty("selectMember"); 
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m.getU_id());
			pstmt.setString(2, m.getU_pwd());
			pstmt.setString(3, m.getU_name());
			
			result = pstmt.executeUpdate();
			
			pstmt2 = con.prepareStatement(query2);
			pstmt2.setString(1, m.getU_id());
			
			rset = pstmt2.executeQuery();
			
			
			
			while(rset.next()){
				member = new Member();
				
				member.setU_code(rset.getInt("u_code"));
				member.setU_id(rset.getString("u_id"));
				member.setU_pwd(rset.getString("u_pwd"));
				member.setU_name(rset.getString("u_name"));
				member.setDrop_yn(rset.getString("drop_yn"));
				member.setU_type(rset.getString("token"));
				member.setU_type(rset.getString("type"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(pstmt2);
			close(rset);
		}
		
		return member;
	}

	public Member loginCheck(Connection con, String userId, String userPwd) {
		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("loginSelect");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				loginUser = new Member();
				
				loginUser.setU_code(rset.getInt("u_code"));
				loginUser.setU_id(rset.getString("u_id"));
				loginUser.setU_pwd(rset.getString("u_pwd"));
				loginUser.setU_name(rset.getString("u_name"));
				loginUser.setDrop_yn(rset.getString("drop_yn"));
				loginUser.setToken(rset.getString("token"));
				loginUser.setU_type(rset.getString("type"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}
		
		return loginUser;
	}

	public int idCheck(Connection con, String uid) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("idCheck");
		
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, uid);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(result);
		
		return result;
	}

	public int insertAllergy(Connection con, ArrayList<UserAllergy> list, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertAllergy");
		
		for(int i = 0; i < list.size(); i++){
			try {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, list.get(i).getAl_code());
				System.out.println(list.get(i).getAl_code());
				pstmt.setString(2, list.get(i).getU_code());
				System.out.println(list.get(i).getU_code());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close(pstmt);
			}
			
		}
		
		System.out.println(result);
		
		return result;
	}

}
