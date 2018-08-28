package com.msmg.board.information.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.board.information.model.service.BoardService;
import com.msmg.board.information.model.vo.Board;
import com.msmg.member.model.vo.Member;

@WebServlet("/insert.bo")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardInsertServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String uCode = String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getU_code());
		String num = request.getParameter("num");
		
		System.out.println(title);
		System.out.println(content);
		System.out.println(uCode);
		System.out.println(num);
		
		Board b = new Board();
		b.setTitle(title);
		b.setContent(content);
		b.setuCode(uCode);
		b.setBoardNo(Integer.parseInt(num));
		
		
		int result = new BoardService().insertBoard(b);
		System.out.println("result :" + result);
		
		
		String page = "";
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/selectList.bo");
		}else {
			request.setAttribute("msg", "게시판 작성 실패!");
			request.getRequestDispatcher("views/common/errorPage.js").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
