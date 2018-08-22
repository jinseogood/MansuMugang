package com.msmg.board.information.controller;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.msmg.board.information.model.service.BoardService;
import com.msmg.board.information.model.vo.Board;
import com.msmg.member.model.vo.Member;

/**
 * Servlet implementation class UpdateInformationBoardServlet
 */
@WebServlet("/updateInfor.bo")
public class UpdateInformationBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateInformationBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bid = request.getParameter("bid");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String date = request.getParameter("date");
		String uCode = String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getU_code());
		int bCount = Integer.parseInt(request.getParameter("count"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String boardSort = request.getParameter("boardSort");
		
		java.sql.Date day = null;
		
		if(date != "" || date != null) {
			String[] dateArr = date.split("-");
			int[] arr = new int[dateArr.length];
			
			for(int i = 0; i < dateArr.length; i++) {
				arr[i] = Integer.parseInt(dateArr[i]);
			}
			
			day = new java.sql.Date(new GregorianCalendar(arr[0], arr[1]-1, arr[2]).getTimeInMillis());
			System.out.println(day);
		}else {
			day = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
		}
		
		Board b = new Board();
		b.setTitle(title);
		b.setBoardId(Integer.parseInt(bid));
		b.setContent(content);
		b.setBoardDate(day);
		b.setuCode(uCode);
		b.setbCount(bCount);
		b.setBoardNo(boardNo);
		b.setBoardSort(boardSort);
		
		int result = new BoardService().updateBoard(b);
		System.out.println(result);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(result, response.getWriter());
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
