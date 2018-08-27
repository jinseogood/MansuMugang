package com.msmg.admin.model.service;

import static com.msmg.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.admin.model.dao.QnADao;
import com.msmg.admin.model.vo.QnA;

public class QnAService {

	public int getListCount() {
		Connection con=getConnection();
		
		int listCount=new QnADao().getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<QnA> selectQnAList(int currentPage, int limit) {
		Connection con=getConnection();
		
		ArrayList<QnA> qList=new QnADao().selectQnAList(currentPage, limit, con);
		
		close(con);
		
		return qList;
	}

	public int getSearchListCount(String type, String content) {
		Connection con=getConnection();
		
		int sListCount=new QnADao().getSearchListCount(type, content, con);
		
		close(con);
		
		return sListCount;
	}

	public ArrayList<QnA> searchQnAList(int currentPage, int limit, String type, String content) {
		Connection con=getConnection();
		
		ArrayList<QnA> qSearchList=new QnADao().searchQnAList(currentPage, limit, type, content, con);
		
		close(con);
		
		return qSearchList;
	}

}
