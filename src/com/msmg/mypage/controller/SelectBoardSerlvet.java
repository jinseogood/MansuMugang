package com.msmg.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.member.model.vo.Member;
import com.msmg.mypage.model.service.MypageService;
import com.msmg.mypage.model.vo.Board;

/**
 * Servlet implementation class SelectBoardSerlvet
 */
@WebServlet("/selectBoard.mp")
public class SelectBoardSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBoardSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ucode = String.valueOf((int)((Member)request.getSession().getAttribute("loginUser")).getU_code());
		
		Board b = new Board();
		b.setU_code(ucode);
		
		ArrayList<Board> list = new MypageService().selectBoard(b);
		
		String page="";
		
		page = "views/member/MyPosts.jsp";
		request.setAttribute("list", list);
		
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
