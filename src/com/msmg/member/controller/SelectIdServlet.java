package com.msmg.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.member.model.service.MemberService;
import com.msmg.member.model.vo.FindId;
    
/**
 * Servlet implementation class SelectIdServlet
 */
@WebServlet("/selectId.me")
public class SelectIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String joinQ = request.getParameter("joinQ");
		String joinA = request.getParameter("joinA");
		
		System.out.println("오니?");
		FindId f = new FindId();
		f.setUserName(userName);
		f.setJoinQ(joinQ);
		f.setJoinA(joinA);
		
		FindId fi = new MemberService().selectId(f);
		
		String page = "";
		
		
		page = "views/member/FindIdPassword.jsp";
		request.setAttribute("fi", fi);
		
		
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
