package com.msmg.payment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.payment.model.service.DestinationService;
import com.msmg.payment.model.service.PaymentInfoService;
import com.msmg.payment.model.service.PaymentService;
import com.msmg.payment.model.service.PhoneService;
import com.msmg.payment.model.vo.Destination;
import com.msmg.payment.model.vo.Payment;
import com.msmg.payment.model.vo.PaymentInfo;
import com.msmg.payment.model.vo.Phone;

/**
 * Servlet implementation class CommonServlet
 */
@WebServlet("/common.pm")
public class CommonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//배송지 입력 서블릿
		String postcode = request.getParameter("postcode");
		String destination1 = request.getParameter("addr1");
		String destination2 = request.getParameter("addr2");
		String destination3 = request.getParameter("addr3");
		String finDest = "";
		String ucode = request.getParameter("u_code");
		
		if(destination1 != null && destination2 != null && destination3 != null){
			finDest = postcode + "h8282h" + destination1 + "h8282h" + destination2 + "h8282h" + destination3;
		};

		Destination d = new Destination();
		d.setDestionation(finDest);
		d.setU_code(ucode);
		
		int result = new DestinationService().insertDestination(d);
		
		
		
		
		//전화번호 입력 서블릿
		String tel1 = request.getParameter("hpno1");
		String tel2 = request.getParameter("hpno2");
		String tel3 = request.getParameter("hpno3");
		String tel = "";
		String u_code = request.getParameter("u_code");
		
		if(tel1 != null){
			tel = tel1 + "-" + tel2 + "-" + tel3;
		};
		
		Phone ph = new Phone();
		ph.setU_code(u_code);
		ph.setTel(tel);
		
		int result2 = new PhoneService().insertPhone(ph);

		
		//결제 상태 변경 서블릿
		String diet_no = request.getParameter("diet_no");
		
		Payment p = new Payment();
		p.setDiet_no(diet_no);
		
		int result3 = new PaymentService().updateOrder(p);
		
		
		// 상세 결제 정보 입력 서블릿
		String sort = request.getParameter("sort");
		String buy_sort = request.getParameter("buy_sort");
		
		PaymentInfo pi = new PaymentInfo();
		pi.setSort(sort);
		pi.setBuy_sort(buy_sort);
		pi.setDiet_no(diet_no);
		
		
		int result4 = new PaymentInfoService().insertPaymentInfo(pi);
		
		
		String imp = request.getParameter("rsp.merchant_uid");
		System.out.println("rsp.merchant_uid입니다" + imp);
		

		
		if(result > 0 || result2 > 0 || result3 > 0 || result4 > 0) {
			response.sendRedirect("views/payment/paymentConfirm.jsp");
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
