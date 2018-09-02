package com.msmg.board.review.model.service;

import static com.msmg.common.JDBCTemplate.close;
import static com.msmg.common.JDBCTemplate.commit;
import static com.msmg.common.JDBCTemplate.getConnection;
import static com.msmg.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.msmg.board.information.model.vo.Board;
import com.msmg.board.information.model.vo.Reply;
import com.msmg.board.review.model.dao.ReviewDao;
import com.msmg.board.review.model.vo.BoardFile;

public class ReviewService {

	public int insertReview(Board b, ArrayList<BoardFile> fileList) {
		Connection con = getConnection();
		
		int result = 0;
		
		int result1 = new ReviewDao().insertReviewContent(con, b);
		System.out.println("result1 : " + result1);
		
		if(result1 > 0) {
			int bid = new ReviewDao().selectCurrval(con);
			System.out.println("ReviewService : " + bid);
			
			for(int i = 0; i < fileList.size(); i++) {
				fileList.get(i).setBoard_id(bid);
			}
		}
		
		int result2 = new ReviewDao().insertBoardFile(con, fileList);
		System.out.println("result2 : " + result2);
		
		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public ArrayList<HashMap<String, Object>> selectReviewList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> list = new ReviewDao().selectReviewList(con, currentPage, limit);
		
		close(con);
		
		return list;
	}

	public HashMap<String, Object> selectOneReview(String num) {
		Connection con = getConnection();
		
		HashMap<String, Object> hmap = null;
		System.out.println("updateCount 전");
		int result = new ReviewDao().updateCount(con, num);
		System.out.println("update result : " + result);
		
		if(result > 0) {
			hmap = new ReviewDao().selectOneReviewMap(con, num);
			
			if(hmap != null) commit(con);
			else rollback(con);
		}
		
		close(con);
		
		return hmap;
	}

	public ArrayList<Reply> insertReply(Reply r) {
		Connection con = getConnection();
		ArrayList<Reply> replyList = null;
		
		int result = new ReviewDao().insertReply(con,r);
		
		if(result > 0) {
			commit(con);
			replyList = new ReviewDao().selectReplyList(con, r.getBoard_id());
		}else {
			rollback(con);
		}
		
		return replyList;
	}

	public int deleteReview(int bid) {
		Connection con = getConnection();
		int result = 0;
		
		result = new ReviewDao().deleteReview(con, bid);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public HashMap<String, Object> updateReview(String num) {
		Connection con = getConnection();
		
		HashMap<String, Object> hmap = new ReviewDao().updateReview(con, num);
		
		if(hmap != null) commit(con);
		else rollback(con);
		
		return hmap;
	}

	public int updateReviewList(Board b, ArrayList<BoardFile> fileList) {
		Connection con = getConnection();
		
		int result = 0;
		
		int result1 = new ReviewDao().updateReviewList(con,b);
		
		int result2 = new ReviewDao().deleteBoardFile(con, b);
		
		/*if(result1 > 0) {
			int bid = new ReviewDao().selectCurrval2(con);
			System.out.println("ReviewService : " + bid);
			
			for(int i = 0; i < fileList.size(); i++) {
				fileList.get(i).setBoard_id(bid);
			}
		}*/
		
		System.out.println("update fileList : " + fileList);
		int result3 = new ReviewDao().updateBoardFile(con, fileList);
		System.out.println("result3 : " + result3);
		
		if((result1 > 0 && result2 > 0 && result3 > 0) || (result1 > 0 & result3 > 0) || (result1 > 0 && result2 > 0) || (result1 > 0) ) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int deleteReviewBoardFile(String num) {
		Connection con = getConnection();
		
		int result = new ReviewDao().deleteReviewBoardFile(con, num);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<Reply> selectReply(String num) {
		Connection con = getConnection();
		ArrayList<Reply> replyList = null;
		
		replyList = new ReviewDao().selectReplyList(con, num);
	
		close(con);
		
		return replyList;
	}

	public int getListCount() {
		Connection con = getConnection();
		
		int listCount = new ReviewDao().getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public Board selectPreR(String num) {
		Connection con = getConnection();
		
		Board preR = new ReviewDao().selectPreR(con, num);
		
		close(con);
		
		return preR;
	}

	public Board selectNextR(String num) {
		Connection con = getConnection();
		
		Board nextR = new ReviewDao().selectNextR(con, num);
		
		close(con);
		
		return nextR;
	}

	public int updateAdmin(String bid) {
		Connection con = getConnection();
		
		int result = new ReviewDao().updateAdmin(con, bid);
		
		if(result > 0) commit(con);
		else rollback(con);
		close(con);
		
		return result;
	}

	public int updateReply(String num, String bid, String content) {
		Connection con = getConnection();
		
		int result = new ReviewDao().updateReply(con, num, bid, content);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int deleteReply(String num, String bid) {
		Connection con = getConnection();
		
		int result = new ReviewDao().deleteReply(con, num, bid);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	




}
