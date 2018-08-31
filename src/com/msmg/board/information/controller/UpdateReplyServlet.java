package com.msmg.board.information.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.board.information.model.service.BoardService;
import com.msmg.board.information.model.vo.Reply;

/**
 * Servlet implementation class UpdateReplyServlet
 */
@WebServlet("/updateReply.in")
public class UpdateReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("댓글 수정 서블릿");
		
		String num = request.getParameter("num");
		String content = request.getParameter("content");
		String bno = request.getParameter("bno");
		String bid = request.getParameter("bid");
		
		System.out.println("num : " + num);
		System.out.println("content : " + content);
		System.out.println("bno : " + bno);
		
		/*num = 댓글 번호*/
		
		int result = new BoardService().updateReply(bno, num, content);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/selectOne.bo?num=" + bno + "&bid=" + bid);
		}else {
			request.setAttribute("msg", "댓글 수정 실패!");
			request.getRequestDispatcher("views/common/errorPge.jsp").forward(request, response);
		}
		
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
