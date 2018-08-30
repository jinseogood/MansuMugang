package com.msmg.member.model.service;

import com.msmg.member.model.dao.SNSMemberDao;
import com.msmg.member.model.vo.Member;
import com.msmg.member.model.vo.SNSMember;

import static com.msmg.common.JDBCTemplate.*;

import java.sql.Connection;

public class SNSMemberService {

	public Member loginMember(Member m) {
		Connection con=getConnection();
		
		Member member =new SNSMemberDao().loginMember(m, con);
		
		if(member != null){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		close(con);
		
		return member;
	}

}
