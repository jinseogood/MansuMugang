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
import com.msmg.board.review.model.vo.BoardFile;

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
		 
		replyList = new BoardDao().selectReplyList(con, num);
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

	public Board selectPreB(String num) {
		System.out.println("selectPreB" + num);
		
		Connection con = getConnection();
		
		Board preB = new BoardDao().selectPreB(con, num);
		
		close(con);
		
		return preB;
	}

	public Board selectNextB(String num) {
		Connection con = getConnection();
		
		Board nextB = new BoardDao().selectNextB(con, num);
		
		close(con);
		
		return nextB;
	}

	public int insertBoardFile(BoardFile bf, int ucode) {
		Connection con = getConnection();
		
		int result = new BoardDao().insertBoardFile(con, bf, ucode);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int deleteBoardFile(String fileName) {
		Connection con = getConnection();
		
		int result = new BoardDao().deleteBoardFile(con, fileName);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return result;
	}

	public int deleteReply(String bid) {
		Connection con = getConnection();
		
		int result = new BoardDao().deleteReply(con, bid);
		
		if(result > 0) commit(con);
		else rollback(con);

		close(con);
		
		return result;
	}

	public int updateReply(String bno, String num, String content) {
		Connection con = getConnection();
		
		int result = new BoardDao().updateReply(con, bno, num, content);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}


}
