package com.msmg.admin.model.service;

import static com.msmg.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.admin.model.dao.ReviewDao;
import com.msmg.admin.model.vo.Review;

public class ReviewService {

	public int getListCount() {
		Connection con=getConnection();
		
		int rListCount=new ReviewDao().getListCount(con);
		
		close(con);
		
		return rListCount;
	}

	public ArrayList<Review> selectReviewList(int currentPage, int limit) {
		Connection con=getConnection();
		
		ArrayList<Review> rList=new ReviewDao().selectReviewList(currentPage, limit, con);
		
		close(con);
		
		return rList;
	}

	public int getSearchListCount(String type, String content) {
		Connection con=getConnection();
		
		int rSearchListCount=new ReviewDao().getSearchListCount(type, content, con);
		
		close(con);
		
		return rSearchListCount;
	}

	public ArrayList<Review> searchReviewList(int currentPage, int limit, String type, String content) {
		Connection con=getConnection();
		
		ArrayList<Review> rSearchList=new ReviewDao().searchReviewList(currentPage, limit, type, content, con);
		
		close(con);
		
		return rSearchList;
	}

}
