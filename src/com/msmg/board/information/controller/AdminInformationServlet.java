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
 * Servlet implementation class AdminInformationServlet
 */
@WebServlet("/adminInfor")
public class AdminInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		System.out.println("num : " + num);
		
		 
		Board b = new BoardService().AselectOne(num);
		
		/*Board preB = new BoardService().AselectPreB(num);
		Board nextB = new BoardService().AselectNextB(num);*/
		ArrayList<Reply> replyList = new BoardService().selectReply(num);
		
		System.out.println("servlet:"+b);
		
		
		String page = "";
		
		if(b != null) {
			page = "views/board/information/adminInformationDetail.jsp";
			request.setAttribute("b", b);
			/*request.setAttribute("preB", preB);
			request.setAttribute("nextB", nextB);*/
			request.setAttribute("r", replyList);
			
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 상세 조회 실패!");
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
