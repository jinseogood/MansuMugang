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
 * Servlet implementation class NoticeDetailServlet
 */
@WebServlet("/noticeDetail.no")
public class NoticeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bno = request.getParameter("board_no");
		System.out.println("bno : " + bno);
		Notice no = new NoticeService().selectOne(bno);
		Notice preNo = new NoticeService().selectPreNo(bno);
		Notice nextNo = new NoticeService().selectNextNo(bno);
		ArrayList<Attachment> list = new NoticeService().selectAttachment(bno);
		
		
		System.out.println("nno : " +  nextNo);
		String page = "";
		
		if(no != null){
			page = "/views/board/notice/readBoard.jsp";
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
