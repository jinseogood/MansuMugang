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
 * Servlet implementation class EditNoticeServlet
 */
@WebServlet("/editQna.qna")
public class EditQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditQnaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		String title = request.getParameter("title");
		String content = request.getParameter("smnoteval");

		int result = new QnaService().editQna(bid, title, content);

		System.out.println("수정완료");

		if(result > 0){
			response.sendRedirect(request.getContextPath() + "/qnaDetail.qna?board_id=" + bid);
		}else{

		request.setAttribute("msg", "공지사항 작성 에러");
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
