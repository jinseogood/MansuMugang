package com.msmg.board.notice.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.board.notice.model.service.NoticeService;

/**
 * Servlet implementation class DeleteNoticeServlet
 */
@WebServlet("/deleteNotice.no")
public class DeleteNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno")); // 글번호 가져오기
		
		 // 글번호에 관련된 내역 hashmap으로 리턴 리턴 및 DB삭제
		HashMap<String, ArrayList<String>> deleteList = new NoticeService().deleteNotice(bno);
		
		String root = request.getSession().getServletContext().getRealPath("/");
		
		String photoPath = root + "attach_file/pic_file/"; // 사진 저장 경로
		String docPath = root + "attach_file/doc_file/"; // 문서 저장 경로
		
		//리스트에 저장
		ArrayList<String> photoList = deleteList.get("photo");
		ArrayList<String> docList = deleteList.get("doc");
		
		//파일의 유무 확인
		for(int i = 0; i < photoList.size(); i++){
			File deleteFile = new File(photoPath + photoList.get(i)); //사진 파일 생성
			deleteFile.delete();
		}
		
		//파일의 유무 확인
		for(int i = 0; i < docList.size(); i++){
			File deleteFile = new File(docPath + docList.get(i)); //문서 파일 생성
			deleteFile.delete();
		}
		
		String page = "";
		
		if(deleteList != null){
			response.sendRedirect(request.getContextPath() + "/noticeList.no");
		}else{
			request.setAttribute("msg", "글 삭제 실패");
			request.getRequestDispatcher("../../common/errorPage.jsp").forward(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
