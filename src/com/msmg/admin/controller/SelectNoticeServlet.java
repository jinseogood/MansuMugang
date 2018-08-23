package com.msmg.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.msmg.admin.model.service.NoticeService;
import com.msmg.admin.model.vo.Notice;

@WebServlet("/selectNoticeList")
public class SelectNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectNoticeServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Notice> nList=new NoticeService().selectNoticeList();
		
		System.out.println("servlet : " + nList);
		
		/*JSONArray result=new JSONArray();
		JSONObject nInfo=null;
		for(Notice n : nList){
			nInfo=new JSONObject();
			
			nInfo.put("n_no", n.getBoard_no());
			nInfo.put("n_title", URLEncoder.encode(n.getTitle(), "UTF-8"));
			nInfo.put("n_writer", URLEncoder.encode(n.getU_name(), "UTF-8"));
			nInfo.put("n_content", URLEncoder.encode(n.getContent(), "UTF-8"));
			nInfo.put("n_date", n.getBoard_date());
			nInfo.put("n_count", n.getB_count());
			
			result.add(nInfo);
		}
		
		System.out.println("result : " + result);
		
		PrintWriter out=response.getWriter();
		out.print(result.toJSONString());
		
		out.flush();
		out.close();*/
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		new Gson().toJson(nList, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
