package com.msmg.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.member.model.vo.Member;
import com.msmg.mypage.model.service.MypageService;
import com.msmg.mypage.model.vo.BuyAll;
import com.msmg.payment.model.vo.Payment;
import com.msmg.payment.model.vo.PaymentInfo;

/**
 * Servlet implementation class SelectBuyInfo
 */
@WebServlet("/selectBuyAll.mp")
public class SelectBuyAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBuyAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ucode = String.valueOf((int)((Member)request.getSession().getAttribute("loginUser")).getU_code());
		
		BuyAll ba = new BuyAll();
		ba.setU_code(ucode);

		ArrayList<BuyAll> bList = new MypageService().selectBuyAll(ba);
		
		String page = "";
		
		page = "views/member/OrderHistory.jsp";
		request.setAttribute("bList", bList);
		
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
