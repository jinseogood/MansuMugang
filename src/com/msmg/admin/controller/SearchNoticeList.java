package com.msmg.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.msmg.admin.model.service.NoticeService;
import com.msmg.admin.model.vo.Notice;
import com.msmg.admin.model.vo.PageInfo;

@WebServlet("/searchNoticeList")
public class SearchNoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchNoticeList() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("sType");
		String content=request.getParameter("sContent");
		
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = new NoticeService().getSearchListCount(type, content);
		
		limit = 10;
		
		maxPage = (int)((double)listCount / limit + 0.9);
		
		startPage = (((int)((double)currentPage / limit + 0.9)) -1) * limit + 1;
		
		endPage = startPage + limit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		ArrayList<Notice> nList=new NoticeService().searchNoticeList(currentPage, limit, type, content);
		
		System.out.println("servlet : " + nList);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		HashMap<String, Object> hmap=new HashMap<String, Object>();
		hmap.put("pi", pi);
		hmap.put("nList", nList);
		
		new Gson().toJson(hmap, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
