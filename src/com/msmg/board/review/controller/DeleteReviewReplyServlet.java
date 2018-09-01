package com.msmg.board.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.board.review.model.service.ReviewService;

/**
 * Servlet implementation class DeleteReviewReplyServlet
 */
@WebServlet("/deleteReply.rev")
public class DeleteReviewReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReviewReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String num = request.getParameter("num");
		 String bid = request.getParameter("bid");
		 
		 int result = new ReviewService().deleteReply(num, bid);
		 
		 if(result > 0) {
				response.sendRedirect(request.getContextPath() + "/selectOne.rev?num=" + bid);
			}else {
				request.setAttribute("msg", "댓글 삭제 실패!");
				request.getRequestDispatcher("views/common/errorPge.jsp").forward(request, response);
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
