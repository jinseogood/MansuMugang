package com.msmg.member.model.service;

import com.msmg.member.model.dao.MemberDao;
import com.msmg.member.model.vo.Member;

import static com.msmg.common.JDBCTemplate.*;

import java.sql.Connection;

public class MemberService {

	public int insertMember(Member m) {
		Connection con = getConnection();
		
		int result = new MemberDao().insertMember(con, m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}

	public Member loginCheck(String userId, String userPwd) {
		Connection con = getConnection();
		
		Member loginUser = new MemberDao().loginCheck(con, userId, userPwd);
	
		close(con);
	
		return loginUser;
	}

}
