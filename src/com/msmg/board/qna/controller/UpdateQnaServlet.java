package com.msmg.board.qna.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.msmg.board.notice.model.service.NoticeService;
import com.msmg.board.notice.model.vo.Attachment;
import com.msmg.board.notice.model.vo.Notice;
import com.msmg.board.qna.model.service.QnaService;
import com.msmg.common.RenameFilePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UpdateBoardServlet
 */
@WebServlet("/updateQna.qna")
public class UpdateQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQnaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String title = request.getParameter("title");
			String content = request.getParameter("smnoteval");
			int bid = Integer.parseInt(request.getParameter("bid"));
			int ucode = Integer.parseInt(request.getParameter("ucode"));
		
		
			int result = new QnaService().updateQna(title, content, bid, ucode);

			
			if(result > 0){
				response.sendRedirect(request.getContextPath() + "/qnaList.qna");
			}else{
				
				//에러페이지로 forward
				request.setAttribute("msg", "qna 게시판 작성 에러");
				request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
				
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
