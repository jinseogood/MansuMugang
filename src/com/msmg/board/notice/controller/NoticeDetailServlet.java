package com.msmg.board.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.board.notice.model.service.NoticeService;
import com.msmg.board.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeDetailServlet
 */
@WebServlet("/noticeDetail.bo")
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
		String bid = request.getParameter("board_id");
		
		Notice no = new NoticeService().selectOne(bid);
		Notice preNo = new NoticeService().selectPreNo(bid);
		Notice nextNo = new NoticeService().selectNextNo(bid);
		
		
		System.out.println("nno : " +  nextNo);
		String page = "";
		
		if(no != null){
			page = "/views/board/notice/readBoard.jsp";
			request.setAttribute("no", no);
			request.setAttribute("preNo", preNo);
			request.setAttribute("nextNo", nextNo);
			
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
