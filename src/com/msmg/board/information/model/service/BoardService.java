package com.msmg.board.information.model.service;

import static com.msmg.common.JDBCTemplate.close;
import static com.msmg.common.JDBCTemplate.commit;
import static com.msmg.common.JDBCTemplate.getConnection;
import static com.msmg.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.msmg.board.information.model.dao.BoardDao;
import com.msmg.board.information.model.vo.Board;
import com.msmg.board.information.model.vo.Reply;

public class BoardService {

	//게시물 등록용 메소드
	public int insertBoard(Board b) {
		Connection con = getConnection();
		
		int result = new BoardDao().insertBoard(con, b);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public ArrayList<Board> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectList(con, currentPage, limit);
		
		close(con);
		
		return list;
		
	}

	public int getListCount() {
		Connection con = getConnection();
		
		int listCount = new BoardDao().getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public Board selectOne(String bid) {
		Connection con = getConnection();
		Board b = null;
		int result = 0;
		
		result = new BoardDao().updateCount(con, bid);
		
		System.out.println(result);
		
		if(result > 0) {
			b = new BoardDao().selectOne(con, bid);
			
			System.out.println("service:" + b);
			
			if(b != null) commit(con);
			else rollback(con);
		}
		
		close(con);
		
		return b;
	}

	public ArrayList<Reply> insertReply(Reply r) {
		Connection con = getConnection();
		ArrayList<Reply> replyList = null;
		
		int result = new BoardDao().insertReply(con,r);
		
		if(result > 0) {
			commit(con);
			replyList = new BoardDao().selectReplyList(con, r.getBoard_id());
		}else {
			rollback(con);
		}
		
		return replyList;
	}

	public ArrayList<Reply> selectReply(String num) {
		Connection con = getConnection();
		ArrayList<Reply> replyList = null;
		
		replyList = new BoardDao().selectReplyList(con, Integer.parseInt(num));
		System.out.println("serviceReply:"+replyList);
		
		close(con);
		
		return replyList;
	}

	public int updateBoard(Board b) {
		Connection con = getConnection();
		
		int result = new BoardDao().updateBoard(con,b);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return result;
	}

	public int deleteBoard(int bid) {
		Connection con = getConnection();
		int result = 0;
		
		result = new BoardDao().deleteBoard(con, bid);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int selectWrite(String ucode) {
		Connection con = getConnection();
		int result = 0;
		
		result = new BoardDao().selectWrite(con, ucode);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	
	

}
