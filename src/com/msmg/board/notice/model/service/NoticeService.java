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
		Notice no = null;
		
		int result = new NoticeDao().updateCount(conn, bid);
		
		if(result > 0){
			no = new NoticeDao().selectOne(conn, bid);
			
			if(no != null){
				commit(conn);
			}else{
				rollback(conn);
			}
		}
		
		close(conn);
		
		return no;
	}

	public int insertBoard(int ucode) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().insertBoard(conn, ucode);
		
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
		
		int result = new NoticeDao().updateBoard(conn, no);
		int result2 = 0;
		int result3 = 0;
		
		int bno = 0;
		int randbno = 0;
		
		if(result > 0){
			bno = new NoticeDao().selectCurrval(conn);
			
			randbno = no.getBoard_no();
			
			for(int i = 0; i < fileList.size(); i++){
				fileList.get(i).setBoard_no(bno);
			}
		}
		
		int photoCount = new NoticeDao().selectPhoto(conn, randbno);
		
		if(photoCount > 0){
			result2 = new NoticeDao().updatePhotho(conn, bno, randbno);
		}
		
		if(fileList.size() > 0){
			result3 = new NoticeDao().insertDocument(conn, fileList);
		}
		
		System.out.println("result2 - " + result2);
		
		System.out.println("result3 - " + result3);
		if(result > 0){
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

	public Notice selectPreNo(String bid) {
		Connection conn = getConnection();
		
		Notice preNo = new NoticeDao().selectPreNo(conn, bid);
		
		close(conn);
		
		return preNo;
	}

	public Notice selectNextNo(String bid) {
		Connection conn = getConnection();
		
		Notice nextNo = new NoticeDao().selectNextNo(conn, bid);
		
		close(conn);
		
		return nextNo;
	}

}
