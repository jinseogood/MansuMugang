package com.msmg.board.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.board.qna.model.service.QnaService;
import com.msmg.board.qna.model.vo.PageInfo;
import com.msmg.board.qna.model.vo.Qna;
import com.msmg.member.model.vo.Member;


/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/qnaList.qna")
public class QnaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member user = (Member)request.getSession().getAttribute("loginUser");
		
		if(user != null){
		
		int currentPage;
		int listLimit;
		int pageLimit;
		int maxPage;
		int startPage;
		int endPage;
		int code = (int)user.getU_code();
	
		currentPage = 1;
		if(request.getParameter("currentPage") != null){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int adminCode = new QnaService().getAdminCode();
		
		int listCount = new QnaService().getListCount(adminCode, code); //15
		
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
		
		
		ArrayList<Qna> list = new QnaService().selectList(currentPage, listLimit, adminCode, code);
		
		
		String page = "";
		
		if(list != null){
			page = "views/board/qna/qnaList.jsp";
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
		}else{
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "리스트 에러");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
		}else{
			
		String page = "views/common/errorPage.jsp";
		request.setAttribute("msg", "접근 에러");
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
			
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
