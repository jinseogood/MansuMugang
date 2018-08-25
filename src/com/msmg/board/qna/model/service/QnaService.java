package com.msmg.board.qna.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.board.qna.model.dao.QnaDao;
import com.msmg.board.qna.model.vo.Qna;
import com.msmg.board.qna.model.vo.Attachment;

import static com.msmg.common.JDBCTemplate.*;

public class QnaService {
	
	public int getAdminCode() {
		Connection conn = getConnection();
		
		int adminCode = new QnaDao().getAdminCode(conn);
		
		close(conn);
		
		return adminCode;
	}

	public int getListCount(int adminCode, int code) {
		Connection conn = getConnection();
		
		int result = new QnaDao().getListCount(conn, adminCode, code);
		
		close(conn);
		
		return result;
	}

	public ArrayList<Qna> selectList(int currentPage, int pageLimit, int adminCode, int code) {
		Connection conn = getConnection();
		
		ArrayList<Qna> list = new QnaDao().selectList(conn, currentPage, pageLimit, adminCode, code);
		
		System.out.println("service : " + list);
		
		close(conn);
		
		return list;
	}

	public Qna selectOne(int bid) {
		Connection conn = getConnection();
		Qna qna = null;
		
		int result = new QnaDao().updateCount(conn, bid);
		
		if(result > 0){
			qna = new QnaDao().selectOne(conn, bid);
			
			if(qna != null){
				commit(conn);
			}else{
				rollback(conn);
			}
		}
		
		close(conn);
		
		return qna;
	}

	public int insertQna(int ucode) {
		Connection conn = getConnection();
		
		int result = new QnaDao().insertQna(conn, ucode);
		int bid = 0;
		
		if(result > 0){
			bid = new QnaDao().selectBid(conn, ucode);
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		return bid;
	}


	public int insertImg(Attachment at) {
		Connection conn = getConnection();
		
		int result = new QnaDao().insertImg(conn, at);
		
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
		
		int result = new QnaDao().deleteImg(conn, fileName);
		
		if(result > 0){
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int updateQna(String title, String content, int bid, int ucode) {
		Connection conn = getConnection();
		
		int nowBno = new QnaDao().selectNowBno(conn, ucode);
		
		int result = new QnaDao().updateQna(conn, title, content, bid, nowBno);
			
		int photoCount = new QnaDao().selectPhoto(conn, bid, ucode);
		
		if(photoCount > 0){
			int result2 = new QnaDao().updatePhotho(conn, bid, ucode, nowBno);
		}
		System.out.println("result : " + result + " / nowBno : " + nowBno);
		System.out.println("photoCount : " + photoCount);
		if(result > 0){
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

	

	public Qna selectOneEdit(String num) {
		Connection conn = getConnection();
		
		Qna qna = new QnaDao().selectOneEdit(conn, num);
		
		close(conn);
		
		return qna;
	}

	public int editQna(int bid, String title, String content) {
		Connection conn = getConnection();

		int result = new QnaDao().editQna(conn, bid, title, content);
		
		if(result > 0){
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

	public int deleteQna(int bid) {
		Connection conn = getConnection();
		
		
		int result1 = new QnaDao().selectPho(conn, bid);
		
		if(result1 > 0){
			int result = new QnaDao().deletePhoto(conn, bid);
		}
		
		int result = new QnaDao().DeleteQna(conn, bid);
		
		if(result > 0){
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int insertReQna(int ucode, int bid) {
		Connection conn = getConnection();
		
		int result = new QnaDao().insertReQna(conn, ucode, bid);
		
		int refBno = 0;
		
		if(result > 0){
			refBno = new QnaDao().selectBid(conn, ucode);
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		return refBno;
	}

	public int updateReQna(String title, String content, int bid, int ucode, int num) {
		Connection conn = getConnection();
		
		int result = new QnaDao().updateReQna(conn, title, content, bid, num);
		
		if(result > 0){
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

	

}
