package com.msmg.board.information.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.board.information.model.service.BoardService;

/**
 * Servlet implementation class DeleteReplyServlet
 */
@WebServlet("/deleteReply.in")
public class DeleteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("num");
		String bno = request.getParameter("bno");
		System.out.println("댓글 삭제 : " + bid);
		
		int result = new BoardService().deleteReply(bid);
		
		String page = "";
		
		/* 수정 필요 : if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/selectOne.bo?num=" + bno);
		}else {
			page = "/views/common/errorPage.jsp";
			request.setAttribute("msg", "댓글 삭제 실패!");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);*/
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
