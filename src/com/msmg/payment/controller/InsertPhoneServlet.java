package com.msmg.payment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.payment.model.service.PhoneService;
import com.msmg.payment.model.vo.Phone;

/**
 * Servlet implementation class InsertPhoneServlet
 */
@WebServlet("/insertPhone.pm")
public class InsertPhoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertPhoneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String tel1 = request.getParameter("hpno1");
	String tel2 = request.getParameter("hpno2");
	String tel3 = request.getParameter("hpno3");
	String tel = "";
	String u_code = request.getParameter("u_code");
	
	if(tel1 != null){
		tel = tel1 + "{*}" + tel2 + "{*}" + tel3;
	};
	
	Phone ph = new Phone();
	ph.setU_code(u_code);
	ph.setTel(tel);
	
	
	int result = new PhoneService().insertPhone(ph);
	
	if(result > 0) {
		response.sendRedirect("views/payment/paymentPage.jsp");
		//넘어가는 페이지 진서 오빠 페이지로 돌리기
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
