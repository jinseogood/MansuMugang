package com.msmg.member.model.service;

import com.msmg.member.model.dao.MemberDao;
import com.msmg.member.model.vo.Member;
import com.msmg.member.model.vo.UserAllergy;

import static com.msmg.common.JDBCTemplate.close;
import static com.msmg.common.JDBCTemplate.commit;
import static com.msmg.common.JDBCTemplate.rollback;
import static com.msmg.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

public class MemberService {

	public Member insertMember(Member m) {
		Connection con = getConnection();
		
		Member member = new MemberDao().insertMember(con, m);
		
		if(member != null) commit(con);
		else rollback(con);
		
		close(con);
		
		return member;
		
	}

	public Member loginCheck(String userId, String userPwd) {
		Connection con = getConnection();
		
		Member loginUser = new MemberDao().loginCheck(con, userId, userPwd);
	
		close(con);
	
		return loginUser;
	}


	public int idCheck(String uid) {
		Connection con = getConnection();
		
		int result = new MemberDao().idCheck(con, uid);
		
		close(con);
		
		return result;
	}

	public int insertAllergy(ArrayList<UserAllergy> list, Member m) {
		Connection con = getConnection();
		
		int result = new MemberDao().insertAllergy(con, list, m);
		
		close(con);
		
		return result;
  }
	public ArrayList<Member> selectMemberList() {
		Connection con=getConnection();
		
		ArrayList<Member> mList=new MemberDao().selectMemberList(con);
		
		close(con);
		
		return mList;

	}

	public ArrayList<UserAllergy> selectAlList(UserAllergy al) {
		Connection con = getConnection();
		
		ArrayList<UserAllergy> alList = new MemberDao().selectAlList(con, al);
		
		close(con);
		
		System.out.println("알레르기 서비스");
		return alList;
	}

	public int deleteMember(Member m) {
		Connection con = getConnection();
		
		int result = new MemberDao().deleteMember(con, m);
		
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}
