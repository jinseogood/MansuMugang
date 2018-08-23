package com.msmg.board.qna.controller;

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
@WebServlet("/deleteQna.qna")
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
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		HashMap<String, ArrayList<String>> deleteList = new NoticeService().deleteNotice(bno);
		
		String root = request.getSession().getServletContext().getRealPath("/");
		
		String photoPath = root + "attach_file/pic_file/";
		String docPath = root + "attach_file/doc_file/";
		
		ArrayList<String> photoList = deleteList.get("photo");
		ArrayList<String> docList = deleteList.get("doc");
		
		for(int i = 0; i < photoList.size(); i++){
			File deleteFile = new File(photoPath + photoList.get(i));
			deleteFile.delete();
		}
		
		for(int i = 0; i < docList.size(); i++){
			File deleteFile = new File(docPath + docList.get(i));
			deleteFile.delete();
		}
		
		String page = "";
		
		if(deleteList != null){
			response.sendRedirect(request.getContextPath() + "/noticeList.bo");
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
