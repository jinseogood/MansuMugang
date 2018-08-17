package com.msmg.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.msmg.member.model.service.MemberService;
import com.msmg.member.model.vo.Member;

/**
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet("/insertMember.me")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("userId");
		String userPwd = request.getParameter("password");
		String userName = request.getParameter("userName");
		
		System.out.println("jjj");
		
		
	
		Member m = new Member();
		m.setU_id(uid);
		m.setU_pwd(userPwd);
		m.setU_name(userName);
		
		int result = new MemberService().insertMember(m);
		
		String page = "";
		if(result > 0){
			page = "/views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 가입 성공!");
		}else{
			page = "/views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 가입 실패!!");
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
