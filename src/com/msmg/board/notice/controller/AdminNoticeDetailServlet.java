package com.msmg.board.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.board.notice.model.service.NoticeService;
import com.msmg.board.notice.model.vo.Attachment;
import com.msmg.board.notice.model.vo.Notice;

/**
 * Servlet implementation class AdminNoticeDetailServlet
 */
@WebServlet("/noticeDetail.admin")
public class AdminNoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bno = request.getParameter("board_no");
		
		Notice no = new NoticeService().selectOne(bno); //해당 글 내용
		ArrayList<Attachment> list = new NoticeService().selectAttachment(bno); // 해당 글 관련 첨부파일
		
		Notice preNo = new NoticeService().selectPreNo(bno); //이전글 내역
		Notice nextNo = new NoticeService().selectNextNo(bno); //다음글 내역
		
		String page = "";
		
		if(no != null){
			page = "/views/board/notice/adminNoticeDetail.jsp";
			request.setAttribute("no", no);
			request.setAttribute("preNo", preNo);
			request.setAttribute("nextNo", nextNo);
			request.setAttribute("list", list);
			
		}else{
			page = "../../common/errorPage.jsp";
			request.setAttribute("msg", "글쓰기 에러");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
