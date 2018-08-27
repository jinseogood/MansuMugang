package com.msmg.payment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.payment.model.service.PaymentInfoService;
import com.msmg.payment.model.vo.PaymentInfo;
 
/** 
 * Servlet implementation class InsertOrderHistoryServlet
 */
@WebServlet("/insertOrder.pm")
public class InsertOrderHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertOrderHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sort = request.getParameter("sort");
		int buy_no = request.getParameter("buy_no");
		int amount = request.getParameter("amount");
		String buy_sort = request.getParameter("buy_sort");
	
		PaymentInfo pi = new PaymentInfo();
		pi.setSort(sort);
		pi.setBuy_sort(buy_sort);
		pi.getAmount(amount);
		pi.setBuy_no(buy_no);
		
		int result = new PaymentInfoService().insertPaymentInfo(pi);
		
		if(result > 0){
			response.sendRedirect("view/payment/paymentConfirm.jsp");
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
