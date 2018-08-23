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
 * Servlet implementation class SelectAllergyServlet
 */
@WebServlet("/selectAllergy.me")
public class SelectAllergyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllergyServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ucode = String.valueOf((int)((Member)request.getSession().getAttribute("loginUser")).getU_code());
		
		System.out.println("써블릿에 들어옴 " + ucode);
		  
		UserAllergy al = new UserAllergy();
		al.setU_code(ucode);
		
		ArrayList<UserAllergy> alList = new MemberService().selectAlList(al);
		
		/*alList.add(al);*/
		System.out.println(alList);
		
		
		String page = "";
		
		page = "views/member/EditMyInformation.jsp";
		request.setAttribute("alList", alList);
		
		
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
