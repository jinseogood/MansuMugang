package com.msmg.board.qna.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.msmg.board.qna.model.service.QnaService;

/**
 * Servlet implementation class checkAlertServlet
 */
@WebServlet("/checkAlert.qna")
public class checkAlertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkAlertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ucode = Integer.parseInt(request.getParameter("ucode"));
		System.out.println("ajax 서블릿 : " + ucode);
		
		int result = new QnaService().checkQnaCount(ucode);
		System.out.println("result = " + result);
		if(result == 1){
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println("result = " + result);
			new Gson().toJson(result, response.getWriter());
		}else{
			int reNum = 0;
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");

			new Gson().toJson(reNum, response.getWriter());
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
