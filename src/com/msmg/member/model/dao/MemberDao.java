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
	public ArrayList<Member> selectMemberList(int currentPage, int limit, Connection con) {
		ArrayList<Member> mList=new ArrayList<Member>();
		//Statement st=null;
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		//String query=prop.getProperty("selectMemberList");
		String query=prop.getProperty("selectMemberListPaging");
		
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
				Member m=new Member();
				m.setU_code(Integer.parseInt(rset.getString("u_code")));
				m.setU_name(rset.getString("u_name"));
				m.setU_id(rset.getString("u_id"));
				m.setU_tel(rset.getString("tel"));
				m.setU_addr(rset.getString("des"));
				m.setU_type(rset.getString("type"));
				m.setDrop_yn(rset.getString("drop_yn"));
				
				mList.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			//close(st);
		}
		
		return mList;

	}

	public ArrayList<String> selectAlList(Connection con, UserAllergy al) {
		ArrayList<String> alList = new ArrayList<String>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		System.out.println("userAllergy Dao");
		
		String query = prop.getProperty("selectUserAllergy");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, al.getU_code());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				/*alList = new ArrayList<UserAllergy>();*/
				
				
				alList.add(rset.getString("al_code"));
				
				System.out.println("dao에서 " + alList);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}
		System.out.println("다오 리턴 전 alList" +alList);
		return alList;
	} 

	public int deleteMember(Connection con, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m.getU_id());
			pstmt .setString(2, m.getU_pwd());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		
		return result;
	}

	public int EmailCheck(Connection con, String userId) {
		System.out.println("이멜첵 다오");
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("idCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			if(rset.next()){
				result = rset.getInt(1);
			}
			
			System.out.println("db갓다와서 " + result);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}
		
		System.out.println("이멜첵 다오 리턴 전 : " + result);
		return result;
	}

	public int getListCount(Connection con) {
		int listCount=0;
		Statement st=null;
		ResultSet rset=null;
		
		String query=prop.getProperty("memberlistCount");
		
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
		
		if(type.equals("u_code")){
			query=prop.getProperty("uCodeListCount");
		}
		else if(type.equals("u_name")){
			query=prop.getProperty("uNameListCount");
		}
		else if(type.equals("u_id")){
			query=prop.getProperty("uIdListCount");
		}
		else if(type.equals("tel")){
			query=prop.getProperty("telListCount");
		}
		else if(type.equals("des")){
			query=prop.getProperty("desListCount");
		}
		else if(type.equals("type")){
			query=prop.getProperty("typeListCount");
		}
		else if(type.equals("drop_yn")){
			query=prop.getProperty("statusListCount");
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

	public ArrayList<Member> searchMemberList(int currentPage, int limit, String type, String content, Connection con) {
		ArrayList<Member> mSearchList=new ArrayList<Member>();
		PreparedStatement pst=null;
		ResultSet rset=null;
		
		String query="";
		
		if(type.equals("u_code")){
			query=prop.getProperty("searchUCodeListPaging");
		}
		else if(type.equals("u_name")){
			query=prop.getProperty("searchUNameListPaging");
		}
		else if(type.equals("u_id")){
			query=prop.getProperty("searchUIdListPaging");
		}
		else if(type.equals("tel")){
			query=prop.getProperty("searchTelListPaging");
		}
		else if(type.equals("des")){
			query=prop.getProperty("searchDesListPaging");
		}
		else if(type.equals("type")){
			query=prop.getProperty("searchTypeListPaging");
		}
		else if(type.equals("drop_yn")){
			query=prop.getProperty("searchStatusListPaging");
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
				Member m=new Member();
				m.setU_code(Integer.parseInt(rset.getString("u_code")));
				m.setU_name(rset.getString("u_name"));
				m.setU_id(rset.getString("u_id"));
				m.setU_tel(rset.getString("tel"));
				m.setU_addr(rset.getString("des"));
				m.setU_type(rset.getString("type"));
				m.setDrop_yn(rset.getString("drop_yn"));
				
				mSearchList.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pst);
		}
		
		return mSearchList;
	}

	public Member updateMember(Connection con, Member m) {
		Member member = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("updateMember");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, m.getU_pwd());
			pstmt.setString(2, m.getU_id());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		return member;
	}

}
