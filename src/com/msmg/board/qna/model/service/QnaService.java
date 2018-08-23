package com.msmg.board.qna.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.msmg.board.notice.model.dao.NoticeDao;
import com.msmg.board.notice.model.vo.Attachment;
import com.msmg.board.notice.model.vo.Notice;
import com.msmg.board.qna.model.dao.QnaDao;
import com.msmg.board.qna.model.vo.Qna;

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
			System.out.println("bno = " + bno + " / randbno = " + randbno);
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

	public Qna selectPreQna(int bid, int code) {
		Connection conn = getConnection();
		
		Qna preQna = new QnaDao().selectPreQna(conn, bid, code);
		
		close(conn);
		
		return preQna;
	}

	public Qna selectNextQna(int bid, int code) {
		Connection conn = getConnection();
		
		Qna nextQna = new QnaDao().selectNextQna(conn, bid, code);
		
		close(conn);
		
		return nextQna;
	}

	public ArrayList<Attachment> selectAttachment(String bno) {
		Connection conn = getConnection();
		
		ArrayList<Attachment> list = new NoticeDao().selectAttachment(conn, bno);
		
		close(conn);
		
		return list;
	}

	public Attachment downloadFile(String editName) {
		Connection conn = getConnection();
		
		Attachment file = new NoticeDao().selectOneAttachment(conn, editName);
		
		close(conn);
		
		return file;
	}

	public Notice selectOneEdit(String num) {
		Connection conn = getConnection();
		
		Notice no = new NoticeDao().selectOneEdit(conn, num);
		
		close(conn);
		
		return no;
	}

	public int editNotice(Notice no, ArrayList<Attachment> fileList) {
		Connection conn = getConnection();
		System.out.println("글수정");
		int result = new NoticeDao().editBoard(conn, no);
		System.out.println("db파일 삭제");
		int result2 = new NoticeDao().deleteDocument(conn, no.getBoard_no());
		System.out.println("db파일 입력");
		if(fileList.size() > 0){
			int result3 = new NoticeDao().insertDocument(conn, fileList);
		}
		
		if(result > 0){
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

	public ArrayList<String> selectChangeName(int bno) {
		Connection conn = getConnection();
		
		ArrayList<String> list = new NoticeDao().selectChangeName(conn, bno);
		
		close(conn);
		
		return list;
	}

	public HashMap<String, ArrayList<String>> deleteNotice(int bno) {
		Connection conn = getConnection();
		HashMap<String, ArrayList<String>> deleteList = null;
		
		ArrayList<String> docList = new NoticeDao().selectDoc(conn, bno);
		
		if(docList.size() > 0){
			int result = new NoticeDao().deleteDocument(conn, bno);
		}
		
		ArrayList<String> photoList = new NoticeDao().selectPho(conn, bno);
		
		if(photoList.size() > 0){
			int result = new NoticeDao().deletePhoto(conn, bno);
		}
		
		int result = new NoticeDao().DeleteNotice(conn, bno);
		
		if(result > 0){
			deleteList = new HashMap<String, ArrayList<String>>();
			
			deleteList.put("doc", docList);
			deleteList.put("photo", photoList);
			
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		return deleteList;
	}

	

}
