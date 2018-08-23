package com.msmg.payment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.payment.model.service.PaymentService;
import com.msmg.payment.model.vo.Payment;

/**
 * Servlet implementation class UpdateOrderServlet
 */
@WebServlet("/updateOrder.pm")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int buy_no = request.getParameter("buy_no");
		String u_code = request.getParameter("u_code");
		String menu_code = request.getParameter("menu_code");
		Date buy_date = request.getParameter("buy_date");
		String status = request.getParameter("status");
		
		Payment p = new Payment();
		p.setBuy_no(buy_no);
		p.setU_code(u_code);
		p.setMenu_code(menu_code);
		p.setBuy_date(buy_date);
		p.setStatus(status);
		
		int result = new PaymentService().updateOrder(p);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
