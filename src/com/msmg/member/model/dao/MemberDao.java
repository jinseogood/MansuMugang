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
	
	public int insertMember(Connection con, Member m) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m.getU_id());
			pstmt.setString(2, m.getU_pwd());
			pstmt.setString(3, m.getU_name());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		return result;
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

	public ArrayList<Member> selectMemberList(Connection con) {
		ArrayList<Member> mList=new ArrayList<Member>();
		Statement st=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("selectMemberList");
		
		try {
			st=con.createStatement();
			rset=st.executeQuery(query);
			
			while(rset.next()){
				Member m=new Member();
				m.setU_code(Integer.parseInt(rset.getString("u_code")));
				m.setU_name(rset.getString("u_name"));
				m.setU_id(rset.getString("u_id"));
				m.setU_type(rset.getString("type"));
				m.setDrop_yn(rset.getString("drop_yn"));
				
				mList.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(st);
		}
		
		return mList;
	}

}
