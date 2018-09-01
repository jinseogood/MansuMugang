package com.msmg.food.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.food.model.service.FoodService;
import com.msmg.food.model.vo.Cart;

/**
 * Servlet implementation class DeleteShoppingCartServlet 
 */
@WebServlet("/deleteCart.fo")
public class DeleteShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String diet_no = request.getParameter("diet_no");
		Cart c = new Cart();
		c.setDiet_no(diet_no);
		
		System.out.println("다이어트 코드 받아 오나용?" + diet_no);
		
		int result = new FoodService().deleteCart(c);
		
		
	
	
	
	
	
	
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
