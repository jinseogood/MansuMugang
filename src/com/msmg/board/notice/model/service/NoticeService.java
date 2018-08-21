package com.msmg.board.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.board.model.dao.BoardDao;
import com.msmg.board.notice.model.dao.NoticeDao;
import com.msmg.board.notice.model.vo.Attachment;
import com.msmg.board.notice.model.vo.Notice;

import static com.kh.jsp.common.JDBCTemplate.close;
import static com.kh.jsp.common.JDBCTemplate.commit;
import static com.kh.jsp.common.JDBCTemplate.getConnection;
import static com.kh.jsp.common.JDBCTemplate.rollback;
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

	public int insertBoard() {
		Connection conn = getConnection();
		
		int result = new NoticeDao().insertBoard(conn);
		
		if(result > 0){
			commit(conn);
		}else{
			rollback(conn);
		}
		
		
		return result;
	}

	public String selectDate() {
		Connection conn = getConnection();
		
		String date = new NoticeDao().selectDate(conn);
		
		close(conn);
		
		
		return date;
	}

	public int insertThumbnail(Notice no, ArrayList<Attachment> fileList) {
		Connection conn = getConnection();
		
		int result = 0;
		
			
			for(int i = 0; i < fileList.size(); i++){
				fileList.get(i).setBno(no.getBoard_no());
		}
		
		int result2 = new NoticeDao().insertAttachment(conn, fileList);
		
		if(result1 > 0 && result2 > 0){
			commit(conn);
			result = 1;
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
