package com.msmg.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.msmg.admin.model.service.StatService;
import com.msmg.admin.model.vo.Stat;

@WebServlet("/statDangMenuCount")
public class StatDangMenuCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StatDangMenuCount() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Stat> mStatList=new StatService().countDangMenu();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("dmenu count servlet : " + mStatList);
		
		new Gson().toJson(mStatList, response.getWriter());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
