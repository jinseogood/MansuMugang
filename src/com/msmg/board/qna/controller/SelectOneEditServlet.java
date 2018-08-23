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

/**
 * Servlet implementation class FixUpdateNoticeServlet
 */
@WebServlet("/selectOneEdit.Qna")
public class SelectOneEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		
		Qna qna = new QnaService().selectOneEdit(num);
		
		String page = "";
		
		if(qna != null){
			page = "/views/board/qna/editQna.jsp";
			request.setAttribute("qna", qna);
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
