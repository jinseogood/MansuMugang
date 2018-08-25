package com.msmg.board.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.msmg.board.information.model.vo.Reply;
import com.msmg.board.review.model.service.ReviewService;
import com.msmg.member.model.vo.Member;

/**
 * Servlet implementation class InsertReviewReplyServlet
 */
@WebServlet("/insertReviewReply.rev")
public class InsertReviewReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReviewReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writter = String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getU_code());
		String content = request.getParameter("content");
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		System.out.println(writter);
		System.out.println(content);
		System.out.println(bid);
		
		
		Reply r = new Reply();
		r.setBoard_id(bid);
		r.setRe_content(content);
		r.setU_code(writter);
		
		
		ArrayList<Reply> replyList = new ReviewService().insertReply(r);
		System.out.println(replyList);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(replyList, response.getWriter()); 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
