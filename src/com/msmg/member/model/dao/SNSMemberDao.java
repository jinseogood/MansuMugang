package com.msmg.member.model.dao;

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

import com.msmg.member.model.vo.Member;

import static com.msmg.common.JDBCTemplate.*;

public class SNSMemberDao {
	private Properties prop=new Properties();
	
	public SNSMemberDao(){
		String fileName=SNSMemberDao.class.getResource("/sql/member/SNSMember-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Member loginMember(Member m, Connection con) {
		int result=0;
		int sw=0;
		Member member=null;
		ArrayList<Member> list=new ArrayList<Member>();
		Statement st=null;
		PreparedStatement pst=null;
		PreparedStatement pst2=null;
		ResultSet rset=null;
		ResultSet rset2=null;
		
		String checkQuery=prop.getProperty("checkMember");
		
		try {
			st=con.createStatement();
			rset=st.executeQuery(checkQuery);
			
			while(rset.next()){
				member=new Member();
				member.setU_id(rset.getString("u_id"));
				
				list.add(member);
			}
			
			for(int i=0;i<list.size();i++){
				if(list.get(i).getU_id().equals(member.getU_id())){
					sw=1;
					break;
				}
			}
			System.out.println("swswwswsw " + sw);
			
			String query="";
			
			if(sw==1){
				query=prop.getProperty("loginMember");
				String selectUCode = prop.getProperty("selectUCode");
				
				pst=con.prepareStatement(query);
				pst.setString(1, member.getU_id());
				
				result=pst.executeUpdate();
				
				if(result>0){
					result=99;
					pst2=con.prepareStatement(selectUCode);
					
					pst2.setString(1, member.getU_id());
					
					rset2=pst2.executeQuery();
					
					while(rset2.next()){
						member.setU_code(rset2.getInt("u_code"));
						member.setU_id(rset2.getString("u_id"));
						member.setU_name(rset2.getString("u_name"));
					}
				}
				else{
					result=0;
				}
				
			}
			else{
				
				query=prop.getProperty("insertMember");
				
				pst=con.prepareStatement(query);
				pst.setString(1, member.getU_id());
				pst.setString(2, member.getU_name());
				pst.setString(3, member.getToken());
				
				result=pst.executeUpdate();
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!" + result);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(st);
			close(rset);
			close(pst);
		}
		
		return member;
	}
}
