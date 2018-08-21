package com.msmg.board.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.board.notice.model.dao.NoticeDao;
import com.msmg.board.notice.model.vo.Attachment;
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

	public int insertBoard() {
		Connection conn = getConnection();
		
		int result = new NoticeDao().insertBoard(conn);
		
		if(result > 0){
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}


	public int insertThumbnail(Attachment at) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().insertAttachment(conn, at);
		
		if(result > 0){
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteImg(String fileName) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().deleteImg(conn, fileName);
		
		if(result > 0){
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int updateBoard(Notice no, ArrayList<Attachment> fileList) {
		Connection conn = getConnection();
		
		int result = 0;
		
		int result1 = new NoticeDao().updateBoard(conn, no);
		
		int result2 = 0;
		
		int bno = 0;
		int randbno = 0;
		System.out.println("result1 - " + result1);
		if(result1 > 0){
			bno = new NoticeDao().selectCurrval(conn);
			
			randbno = no.getBoard_no();
			
			
			for(int i = 0; i < fileList.size(); i++){
				fileList.get(i).setBoard_no(bno);
			}
			
		}
		int result3 = new NoticeDao().insertDocument(conn, fileList);
		
		result2 = new NoticeDao().updatePhotho(conn, bno, randbno);
		System.out.println("result2 - " + result2);
		
		System.out.println("result3 - " + result3);
		if(result1 > 0 && result2 > 0 && result3 > 0){
			commit(conn);
			result = 1;
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

}
