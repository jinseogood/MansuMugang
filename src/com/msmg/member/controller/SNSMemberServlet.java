package com.msmg.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.msmg.member.model.service.SNSMemberService;
import com.msmg.member.model.vo.Member;
import com.msmg.member.model.vo.SNSMember;

@WebServlet("/snsLogin.me")
public class SNSMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SNSMemberServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId=request.getParameter("id");
		System.out.println(userId);
		String userName=request.getParameter("nickname");
		System.out.println(userName);
		String refreshToken=request.getParameter("refreshToken");
		System.out.println(refreshToken);
		/*SNSMember sm=new SNSMember();
		sm.setmId(userId);
		sm.setmName(userName);
		sm.setmToken(refreshToken);*/
		
		Member m = new Member();
		m.setU_id(userId);
		m.setU_name(userName);
		m.setToken(refreshToken);
		
		Member member=new SNSMemberService().loginMember(m);
		
		System.out.println("kakao : " + member);
		
		if(member != null){
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", member);
			
			RequestDispatcher view=request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}
		else{
			System.out.println("카카오 가입 안됨");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
