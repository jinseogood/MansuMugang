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
   
/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/updateMember.me")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {  
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String[] alCode = request.getParameterValues("allergy");
		System.out.println("userPwd");
		System.out.println("servlet alCode : " + alCode);
		
		Member m = new Member();
		m.setU_id(uid);
		m.setU_pwd(userPwd);
		m.setU_name(userName);
		System.out.println("멤버서비스로 멤버m 보내기 전 " + m);
		int result = new MemberService().updateMember(m);
		
		
		
		System.out.println("알리스트 전 까지 옴");
		
		ArrayList<UserAllergy> alList = new ArrayList<UserAllergy>();
		System.out.println("알리스트 후 이프 전");
		if(alCode != null){
			System.out.println("이프문 들어옴");
			for(int i = 0; i < alCode.length; i++){
				System.out.println("포문 들어옴");
				UserAllergy ua = new UserAllergy();
				ua.setAl_code(alCode[i]);
				ua.setU_code(String.valueOf((int)((Member)request.getSession().getAttribute("loginUser")).getU_code()));
				/*ua.setU_code(Integer.toString(member.getU_code()));*/
				System.out.println("알리스트 에드 하기 전에 ua : " + ua);
				alList.add(ua);
				System.out.println("업데이트알러지써블릿에서 알리스트 출력 " + alList);
			}
		}
		
		int result1 = new MemberService().updateAllergy(alList, m);
		
		String page = "";
		if(result != 0 || result1 != 0){
			page = "";
		}else{
			page = "/views/common/errorPage.jsp";
			request.setAttribute("msg", "회원정보수정 실패!");
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
