package com.msmg.board.qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.board.qna.model.service.QnaService;

/**
 * Servlet implementation class UpdateReQnaServlet
 */
@WebServlet("/updateReQna.qna")
public class UpdateReQnaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReQnaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("smnoteval");
		int bid = Integer.parseInt(request.getParameter("bid"));
		int ucode = Integer.parseInt(request.getParameter("ucode"));
		int num = Integer.parseInt(request.getParameter("num"));
	
	
		int result = new QnaService().updateReQna(title, content, bid, ucode, num);

		
		if(result > 0){
			response.sendRedirect(request.getContextPath() + "/readQnaDetail.qna?board_id=" + bid);
		}else{
			
			//에러페이지로 forward
			request.setAttribute("msg", "qna 게시판 작성 에러");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
			
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
