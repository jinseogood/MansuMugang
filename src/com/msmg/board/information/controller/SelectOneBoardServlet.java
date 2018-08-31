package com.msmg.board.information.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.board.information.model.service.BoardService;
import com.msmg.board.information.model.vo.Board;
import com.msmg.board.information.model.vo.Reply;

/**
 * Servlet implementation class SelectOneBoardServlet
 */
@WebServlet("/selectOne.bo")
public class SelectOneBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectOneBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String bid = request.getParameter("bid");
		System.out.println("num : " + num);
		System.out.println("bid : " + bid);
		
		 
		Board b = new BoardService().selectOne(num);
		
		Board preB = new BoardService().selectPreB(num);
		Board nextB = new BoardService().selectNextB(num);
		ArrayList<Reply> replyList = new BoardService().selectReply(bid);
		
		System.out.println("servlet:"+b);
		
		
		String page = "";
		
		if(b != null) {
			page = "views/board/information/informationView.jsp";
			request.setAttribute("b", b);
			request.setAttribute("preB", preB);
			request.setAttribute("nextB", nextB);
			request.setAttribute("r", replyList);
			
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 상세 조회 실패!");
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
