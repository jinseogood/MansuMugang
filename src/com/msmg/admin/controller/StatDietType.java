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

@WebServlet("/statDietType")
public class StatDietType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StatDietType() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dietGoCount=new StatService().countGo();
		int dietDangCount=new StatService().countDang();
		int dietHeadCount=new StatService().countHead();
		int dietGDCount=new StatService().countGD();
		int dietGHCount=new StatService().countGH();
		int dietDHCount=new StatService().countDH();
		int dietGDHCount=new StatService().countGDH();
		
		JSONObject result=new JSONObject();
		
		result.put("go", dietGoCount);
		result.put("dang", dietDangCount);
		result.put("head", dietHeadCount);
		result.put("gd", dietGDCount);
		result.put("gh", dietGHCount);
		result.put("dh", dietDHCount);
		result.put("gdh", dietGDHCount);
		
		System.out.println("dietType servlet : " + result);
		
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
