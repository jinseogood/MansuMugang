package com.msmg.board.review.model.service;

import static com.msmg.common.JDBCTemplate.close;
import static com.msmg.common.JDBCTemplate.commit;
import static com.msmg.common.JDBCTemplate.getConnection;
import static com.msmg.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.msmg.board.information.model.vo.Board;
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


}
