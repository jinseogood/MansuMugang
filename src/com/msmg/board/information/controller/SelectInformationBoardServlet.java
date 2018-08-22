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

@WebServlet("/selectInfor.bo")
public class SelectInformationBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectInformationBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		
		Board b = new BoardService().selectOne(num);
		
		String page = "";
		
		if(b != null) {
			page = "views/board/information/informationModify.jsp";
			request.setAttribute("b", b);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 수정용 상세보기 실패!");
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
