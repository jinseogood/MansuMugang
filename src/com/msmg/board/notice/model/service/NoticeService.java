package com.msmg.board.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.board.notice.model.dao.NoticeDao;
import com.msmg.board.notice.model.vo.Notice;

import static com.msmg.common.JDBCTemplate.*;

public class NoticeService {

	public int getListCount() {
		Connection conn = getConnection();
		
		int result = new NoticeDao().getListCount(conn);
		
		close(conn);
		
		return result;
	}

	public ArrayList<Notice> selectList(int currentPage, int pageLimit) {
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectList(conn, currentPage, pageLimit);
		
		close(conn);
		
		return list;
	}

	public Notice selectOne(String bid) {
		Connection conn = getConnection();
		
		Notice no = new NoticeDao().selectOne(conn, bid);
		
		close(conn);
		
		return no;
	}

}
