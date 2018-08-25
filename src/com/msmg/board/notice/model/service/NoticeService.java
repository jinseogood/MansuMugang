package com.msmg.board.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.msmg.board.notice.model.dao.NoticeDao;
import com.msmg.board.notice.model.vo.Attachment;
import com.msmg.board.notice.model.vo.Notice;
import com.msmg.board.qna.model.dao.QnaDao;

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

	public Notice selectOne(String bno) {
		Connection conn = getConnection();
		Notice no = null;
		
		int result = new NoticeDao().updateCount(conn, bno);
		
		if(result > 0){
			no = new NoticeDao().selectOne(conn, bno);
			
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


	public int insertThumbnail(Attachment at, int ucode) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().insertAttachment(conn, at, ucode);
		
		if(result > 0){
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteAttachment(String fileName) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().deleteAttachment(conn, fileName);
		
		if(result > 0){
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int updateBoard(Notice no, ArrayList<Attachment> fileList, int ucode) {
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
			result3 = new NoticeDao().insertDocument(conn, fileList, ucode);
		}
		
		System.out.println("result2 - " + result2);
		
		System.out.println("result3 - " + result3);
		if(result > 0){
			result = bno;
			commit(conn);
		}else{
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

	public Notice selectPreNo(String bno) {
		Connection conn = getConnection();
		
		Notice preNo = new NoticeDao().selectPreNo(conn, bno);
		
		close(conn);
		
		return preNo;
	}

	public Notice selectNextNo(String bno) {
		Connection conn = getConnection();
		
		Notice nextNo = new NoticeDao().selectNextNo(conn, bno);
		
		close(conn);
		
		return nextNo;
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

	public int editNotice(Notice no, ArrayList<Attachment> fileList, int ucode) {
		Connection conn = getConnection();
		System.out.println("글수정");
		int result = new NoticeDao().editBoard(conn, no);
		System.out.println("db파일 삭제");
		int result2 = new NoticeDao().deleteDocument(conn, no.getBoard_no());
		System.out.println("db파일 입력");
		if(fileList.size() > 0){
			int result3 = new NoticeDao().insertDocument(conn, fileList, ucode);
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
