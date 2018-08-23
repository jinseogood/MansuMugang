package com.msmg.food.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertBuy.fo")
public class InsertBuyFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertBuyFoodServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("넘어오냐");
		int go = Integer.parseInt(request.getParameter("go"));
		int dang = Integer.parseInt(request.getParameter("dang"));
		int head = Integer.parseInt(request.getParameter("head"));
		int day = Integer.parseInt(request.getParameter("day"));
		int ggi = Integer.parseInt(request.getParameter("ggi"));
		int side = Integer.parseInt(request.getParameter("side"));
		String result = request.getParameter("result");
		int total_price = Integer.parseInt(request.getParameter("total_price"));
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
