package com.msmg.board.review.model.service;

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

	public ArrayList<HashMap<String, Object>> selectReviewList() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> list = new ReviewDao().selectReviewList(con);
		
		close(con);
		
		return list;
	}

	public HashMap<String, Object> selectOneReview(String num) {
		Connection con = getConnection();
		
		HashMap<String, Object> hmap = null;
		
		int result = new ReviewDao().updateCount(con, num);
		
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
		
		System.out.println("update fileList : " + fileList);
		int result2 = new ReviewDao().updateBoardFile(con, fileList);
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



}
