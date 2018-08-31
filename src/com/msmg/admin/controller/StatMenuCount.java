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

@WebServlet("/statMenuCount")
public class StatMenuCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StatMenuCount() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Stat> mStatList=new StatService().countMenu();
		
		/*JSONObject result=new JSONObject();
		
		for(int i=0;i<mStatList.size();i++){
			String key=mStatList.get(i).getMenu_name();
			
			result.put(key, mStatList.get(i).getSale_count());
		}*/
		
		/*JSONArray result=new JSONArray();
		JSONObject mList=null;
		for(Stat s : mStatList){
			mList=new JSONObject();
			
			mList.put("menuName", s.getMenu_name());
			mList.put("saleCount", s.getSale_count());
			
			result.add(mList);
		}
		
		
		System.out.println("servlet result : " + result);*/
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		new Gson().toJson(mStatList, response.getWriter());
		
		/*PrintWriter out=response.getWriter();
		out.print(result.toJSONString());
		
		out.flush();
		out.close();*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
