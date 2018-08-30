package com.msmg.member.controller;
  
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.member.model.service.MemberService;
import com.msmg.member.model.vo.SNSMember;

/**
 * Servlet implementation class InsertkakaologinServlet
 */
@WebServlet("/insertkakaologin.me")
public class InsertkakaologinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertkakaologinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("id");
		String userName = request.getParameter("nickname");
		String refreshToken = request.getParameter("refreshToken");
		
		SNSMember sm = new SNSMember();
		sm.setmId(userId);
		sm.setmName(userName);
		sm.setmToken(refreshToken);
		
		
		int result = new MemberService().SNSloginMember(sm);
		
		if(result == 99){
			request.setAttribute("msg", "로그인 성공");
		}
		else if(result<99&&result>0){
			request.setAttribute("msg", "가입 성공");
		}
		else{
			request.setAttribute("msg", "로그인 및 가입 실패");
		}
		
		RequestDispatcher view=request.getRequestDispatcher("result.jsp");
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
