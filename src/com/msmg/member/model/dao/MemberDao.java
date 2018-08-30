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

import com.msmg.member.model.vo.FindId;
import com.msmg.member.model.vo.Member;
import com.msmg.member.model.vo.SNSMember;
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
			pstmt.setString(4, m.getU_question());
			pstmt.setString(5, m.getU_answer());
			
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
				member.setU_question(rset.getString("u_question"));
				member.setU_answer(rset.getString("u_answer"));
				
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
			
			System.out.println("이주가 찍으라는 알셋 : " + rset);
			
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

	public int updateMember(Connection con, Member m) {
		PreparedStatement pstmt = null;
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
		}finally{
			close(pstmt);
		}
		
		return result;
	}

	public int updateAllergy(Connection con, ArrayList<UserAllergy> alList, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		int result2 = 0;
		PreparedStatement pstmt2 = null;
		
		String query = prop.getProperty("deleteAllergy");
		String query2 = prop.getProperty("insertAllergy");
		
			try {
				//기존 알러지 delete
				for(int i = 0; i < alList.size(); i++){
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, alList.get(i).getU_code());
				
				result = pstmt.executeUpdate();
				}
				
				for(int i = 0; i < alList.size(); i++){
				
				//수정 알러지 insert
				pstmt2 = con.prepareStatement(query2);
				
				pstmt2.setString(1, alList.get(i).getAl_code());
				System.out.println(alList.get(i).getAl_code());
				pstmt2.setString(2, alList.get(i).getU_code());
				System.out.println(alList.get(i).getU_code());
				
				result2 = pstmt2.executeUpdate();
				
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close(pstmt);
				close(pstmt2);
			}
			
		
		System.out.println(result2);
		
		return result2;
	}

	public FindId selectId(Connection con, FindId f) {
		FindId fi = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectId");
		
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, f.getUserName());
			pstmt.setString(2, f.getJoinQ());
			pstmt.setString(3, f.getJoinA());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				fi.setUserName(rset.getString("u_name"));
				fi.setJoinQ(rset.getString("u_question"));
				fi.setJoinA(rset.getString("u_answer"));
				fi.setUserId(rset.getString("u_id"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(rset);
		}
		
		System.out.println("다오에서 파인드아이디 : " + fi);
		
		return fi;
	}

	public int SNSLoginMember(Connection con, SNSMember sm) {
		int result = 0;
		int sw = 0;
		SNSMember m = null;
		ArrayList<SNSMember> list = new ArrayList<SNSMember>();
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String checkQuery = prop.getProperty("checkMember");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(checkQuery);
			
			while(rset.next()){
				m = new SNSMember();
				m.setmId(rset.getString("u_id"));
				
				list.add(m);
			}
			
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).getmId().equals(sm.getmId())){
					sw=1;
					break;
				}
			}
			
			String query = "";
			
			if(sw == 1){
				query = prop.getProperty("loginMember");
				
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, sm.getmId());
				
				result = pstmt.executeUpdate();
				
				if(result > 0){
					result = 99;
				}else{
					result = 0;
				}
			}else{
					query = prop.getProperty("insertSNSMember");
					
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, sm.getmId());
					pstmt.setString(2, sm.getmName());
					pstmt.setString(3, sm.getmToken());
					
					result = pstmt.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rset);
			close(pstmt);
		}
		
		
		
		
		return result;
	}

}
