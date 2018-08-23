package com.msmg.board.qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.board.qna.model.service.QnaService;
import com.msmg.member.model.vo.Member;

/**
 * Servlet implementation class writeReQnaServlet
 */
@WebServlet("/writeRe.qna")
public class writeReQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public writeReQnaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ucode = ((Member)request.getSession().getAttribute("loginUser")).getU_code();
		int bid = Integer.parseInt(request.getParameter("num"));
		System.out.println("답글할 글 id " + bid);
		int result = new QnaService().insertReQna(ucode, bid);
		
		String page = "";
		
		if(result > 0){
		page = "/views/board/qna/writeReQna.jsp";
		request.setAttribute("bid", result);
		request.setAttribute("ucode", ucode);
		request.setAttribute("num", bid);
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
