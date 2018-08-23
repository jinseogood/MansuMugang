package com.msmg.payment.controller;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.payment.model.service.DestinationService;
import com.msmg.payment.model.vo.Destination;

/** 
 * Servlet implementation class InsertDelivery
 */
@WebServlet("/insertDestination.pm")
public class InsertDestinationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDestinationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String postcode = request.getParameter("postcode");
		String destination1 = request.getParameter("addr1");
		String destination2 = request.getParameter("addr2");
		String destination3 = request.getParameter("addr3");
		String finDest = "";
		String ucode = request.getParameter("u_code");
		
		
		if(destination1 != null && destination2 != null && destination3 != null){
			finDest = postcode + "{*}" + destination1 + "{*}" + destination2 + "{*}" + destination3;
		};

		Destination d = new Destination();
		d.setDestionation(finDest);
		d.setU_code(ucode);
		
		int result = new DestinationService().insertDestination(d);
		
		if (result > 0){
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
