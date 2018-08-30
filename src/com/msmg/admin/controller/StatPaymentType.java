package com.msmg.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.msmg.admin.model.service.StatService;

@WebServlet("/statPayType")
public class StatPaymentType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StatPaymentType() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int payCard=new StatService().countCard();
		int payMoney=new StatService().countMoney();
		
		JSONObject result=new JSONObject();
		
		result.put("card", payCard);
		result.put("money", payMoney);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out=response.getWriter();
		out.print(result.toJSONString());
		
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
