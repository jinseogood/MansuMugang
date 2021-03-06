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
		
		int result = new NoticeDao().updateCount(conn, bno); // 조회수 증가 후
		
		if(result > 0){
			no = new NoticeDao().selectOne(conn, bno); // 글 선택
			
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


	public int insertAttachment(Attachment at, int ucode) {
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
		
		//글번호도 새로 갱신하여 업데이트
		int result = new NoticeDao().updateBoard(conn, no);
		int result2 = 0;
		int result3 = 0;
		
		int bno = 0;
		int randbno = 0;
		
		if(result > 0){
			//새로 갱신 된 글번호
			bno = new NoticeDao().selectCurrval(conn);
			
			//현재 랜덤으로 지정된 글번호
			randbno = no.getBoard_no();

			//파일들에 글번호를 지정
			for(int i = 0; i < fileList.size(); i++){
				fileList.get(i).setBoard_no(bno);
			}
		}
		
		//랜덤값으로 입력된 사진들을 조회
		int photoCount = new NoticeDao().selectPhoto(conn, randbno);
		
		//사진이 있으면
		if(photoCount > 0){
			//사진의 글번호를 새로 갱신된 글번호로 변경
			result2 = new NoticeDao().updatePhotho(conn, bno, randbno);
		}
		
		//문서가 존재하면 문서 저장
		if(fileList.size() > 0){
			result3 = new NoticeDao().insertDocument(conn, fileList, ucode);
		}
		
		if((result > 0 && result2 > 0 && result3 > 0) || (result > 0 && result2 > 0)
				|| (result > 0 && result3 > 0) || result > 0){
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
		
		//변경내용 수정
		int result = new NoticeDao().editBoard(conn, no);
		
		//문서 삭제
		int result2 = new NoticeDao().deleteDocument(conn, no.getBoard_no());

		int result3 = 0;
		//새로 업로드한 파일이 존재시
		if(fileList.size() > 0){
			result3 = new NoticeDao().insertDocument(conn, fileList, ucode);
		}
		
		//수행 확인
		if((result > 0 && result2 > 0 && result3 > 0) || (result > 0 && result2 > 0) ||
				(result > 0 && result3 > 0) || result > 0){
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
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		
		
		ArrayList<String> docList = new NoticeDao().selectDoc(conn, bno); // 글번호에 관련된 문서 선택
		
		if(docList.size() > 0){ //문서가 있으면
			result1 = new NoticeDao().deleteDocument(conn, bno); //문서 삭제
		}
		
		ArrayList<String> photoList = new NoticeDao().selectPho(conn, bno); // 글번호에 관련된 사진 선택
		
		if(photoList.size() > 0){ //사진이 있으면
			result2 = new NoticeDao().deletePhoto(conn, bno); //사진 삭제
		}
		
		result3 = new NoticeDao().DeleteNotice(conn, bno); //공지 삭제
		
		//수행 결과 확인
		if((result1 > 0 && result3 > 0) || (result2 > 0 && result3 > 0) 
				|| (result1 > 0 && result2 > 0 && result3 > 0) || result3 > 0){
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
