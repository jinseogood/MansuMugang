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
import com.msmg.board.notice.model.vo.Notice;
import com.msmg.board.notice.model.vo.PageInfo;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/noticeList.no")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage;
		int listLimit;
		int pageLimit;
		int maxPage;
		int startPage;
		int endPage;
	
		currentPage = 1;
		if(request.getParameter("currentPage") != null){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = new NoticeService().getListCount(); //15
		
		listLimit = 10;
		pageLimit = 5;
		
		maxPage = (int)((double)listCount / listLimit + 0.9);
		System.out.println("maxpage = " + maxPage);
		
		startPage = ((int)((double)currentPage / pageLimit + 0.8) - 1) * pageLimit + 1;
		System.out.println("startPage : " + startPage);
		endPage = startPage + pageLimit - 1;
		System.out.println("endPage : " + endPage);
		if(maxPage < endPage){
			endPage = maxPage;
		}
		System.out.println("maxPage : " + maxPage);
		PageInfo pi = new PageInfo(currentPage, listCount, listLimit, pageLimit, maxPage, startPage, endPage);
		
		ArrayList<Notice> list = new NoticeService().selectList(currentPage, listLimit);
		
		
		String page = "";
		
		if(list != null){
			page = "views/board/notice/notice.jsp";
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
		}else{
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "리스트 에러");
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
