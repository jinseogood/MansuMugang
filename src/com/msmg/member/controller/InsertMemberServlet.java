package com.msmg.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.msmg.member.model.service.MemberService;
import com.msmg.member.model.vo.Member;
import com.msmg.member.model.vo.UserAllergy;
  
@WebServlet("/insertMember.me")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public InsertMemberServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String[] alCode = request.getParameterValues("allergy");
		String joinQ = request.getParameter("joinQ");
		String joinA = request.getParameter("joinA");
		
		System.out.println(uid);  
		System.out.println(userPwd);
		System.out.println(userName);
		System.out.println(joinQ);
		System.out.println(joinA);
		System.out.println("인써트 멤버 써블릿 알코드 : " + alCode);
		System.out.println("비밀번호 틀렷는데 서블릿에 왓다");
		Member m = new Member();
		m.setU_id(uid);
		m.setU_pwd(userPwd);
		m.setU_name(userName);
		m.setU_question(joinQ);
		m.setU_answer(joinA);
		Member member = new MemberService().insertMember(m);
		
		
		
		
		
		ArrayList<UserAllergy> list = new ArrayList<UserAllergy>();
		if(alCode != null){
			for(int i = 0; i < alCode.length; i++){
				UserAllergy ua = new UserAllergy();
				ua.setAl_code(alCode[i]);
				ua.setU_code(Integer.toString(member.getU_code()));
				
				list.add(ua);  
				System.out.println("알러지 리스트를 에드햇다" + list);
			}
		}

		int result = new MemberService().insertAllergy(list, m);
		
		String page = "";
		if(member != null || result != 0){
			page = "";
		}else{
			page = "/views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 가입 실패!!");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
