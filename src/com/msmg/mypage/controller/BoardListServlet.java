package com.msmg.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.mypage.model.service.MypageService;
import com.msmg.mypage.model.vo.Board;
import com.msmg.mypage.model.vo.PageInfo;


/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardList.mp")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = new MypageService().getListCount();
		
		limit = 10;
		
		maxPage = (int)((double)listCount / limit + 0.9);
		
		System.out.println("maxPage : " + maxPage);
		
		startPage = (((int)((double)currentPage / limit + 0.9)) -1) * limit + 1;
		
		endPage = startPage + limit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		ArrayList<Board> list = new MypageService().selectList(currentPage, limit);
		System.out.println(list);
		
		String page = "";
		
		page = "views/member/MyPosts.jsp";
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
