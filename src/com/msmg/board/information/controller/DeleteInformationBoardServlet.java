package com.msmg.board.information.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.msmg.board.information.model.service.BoardService;

@WebServlet("/deleteInfor.bo")
public class DeleteInformationBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteInformationBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("넘어옴");
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		System.out.println("bid : " + bid);
	
		int result = new BoardService().deleteBoard(bid);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(result, response.getWriter());
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
