package com.msmg.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.admin.model.dao.NoticeDao;
import com.msmg.admin.model.vo.Notice;

import static com.msmg.common.JDBCTemplate.*;

public class NoticeService {

	public ArrayList<Notice> selectNoticeList(int currentPage, int limit) {
		Connection con=getConnection();
		
		ArrayList<Notice> nList=new NoticeDao().selectNoticeList(currentPage, limit, con);
		
		System.out.println("service : " + nList);
		
		close(con);
		
		return nList;
	}

	public int getListCount() {
		Connection con=getConnection();
		
		int listCount=new NoticeDao().getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public int getSearchListCount(String type, String content) {
		Connection con=getConnection();
		
		int listCount=new NoticeDao().getSearchListCount(type, content, con);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Notice> searchNoticeList(int currentPage, int limit, String type, String content) {
		Connection con=getConnection();
		
		ArrayList<Notice> nSearchList=new NoticeDao().searchNoticeList(currentPage, limit, type, content, con);
		
		close(con);
		
		return nSearchList;
	}

}
