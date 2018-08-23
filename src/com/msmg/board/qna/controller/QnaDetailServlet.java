package com.msmg.board.qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.board.qna.model.service.QnaService;
import com.msmg.board.qna.model.vo.Qna;
import com.msmg.member.model.vo.Member;

/**
 * Servlet implementation class NoticeDetailServlet
 */
@WebServlet("/qnaDetail.qna")
public class QnaDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("board_id"));
		int code = ((Member)request.getSession().getAttribute("loginUser")).getU_code();
		
		Qna qna = new QnaService().selectOne(bid);
		Qna preQna = new QnaService().selectPreQna(bid, code);
		Qna nextQna = new QnaService().selectNextQna(bid, code);
		
		String page = "";
		
		if(qna != null){
			page = "/views/board/qna/readQna.jsp";
			request.setAttribute("qna", qna);
			request.setAttribute("preQna", preQna);
			request.setAttribute("nextQna", nextQna);
			
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
