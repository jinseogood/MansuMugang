package com.msmg.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.admin.model.service.OrderService;

@WebServlet("/updateOrderStatus")
public class UpdateOrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateOrderStatusServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dietNo=request.getParameter("dietNo");
		String status=request.getParameter("status");
		
		int result=new OrderService().updateStatus(dietNo, status);
		
		if(result>0){
			response.sendRedirect(request.getContextPath() + "/selectOneOrderList?dietNo="+dietNo+"&currentPage=1");
		}
		else{
			System.out.println("상태 수정 오류");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
