package com.msmg.board.information.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.board.information.model.service.BoardService;
import com.msmg.member.model.vo.Member;
 
@WebServlet("/selectWrite.bo")
public class SelectBoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectBoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ucode = String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getU_code());
		
		System.out.println(ucode);
		
		int result = new BoardService().selectWrite(ucode);
		System.out.println("Servlet result : " + result);
		
		String page = "";
		
		if(result > 0) {
			page = "/views/board/information/informationWrite.jsp";
			request.setAttribute("random", result);
		}else {
			page = "/views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 작성 실패!");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
