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

import com.msmg.admin.model.service.MenuService;
import com.msmg.admin.model.vo.Menu;
import com.msmg.admin.model.vo.PageInfo;

@WebServlet("/searchMenuList")
public class SearchMenuList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchMenuList() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("sType");
		String content=request.getParameter("sContent");
		
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage=1;
				
		if(request.getParameter("currentPage") != null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
				
		int listCount=new MenuService().getSearchListCount(type, content);
		
		limit=10;
				
		maxPage=(int)((double)listCount / limit + 0.9);
				
		startPage=((int)(((double)currentPage / limit + 0.9) - 1) * limit + 1);
				
		endPage=startPage+limit-1;
				
		if(maxPage < endPage){
			endPage=maxPage;
		}
				
		PageInfo pi=new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		ArrayList<Menu> menuList=new MenuService().searchMenuList(currentPage, limit, type, content);
		
		JSONArray result=new JSONArray();
		JSONObject menuInfo=null;
		JSONObject menuPage=new JSONObject();
		for(Menu menu : menuList){
			menuInfo=new JSONObject();
			
			menuInfo.put("menuCode", menu.getMenuCode());
			menuInfo.put("menuName", URLEncoder.encode(menu.getMenuName(), "UTF-8"));
			menuInfo.put("mainMat", URLEncoder.encode(menu.getMainMat(), "UTF-8"));
			menuInfo.put("subMat", URLEncoder.encode(menu.getSubMat(), "UTF-8"));
			menuInfo.put("price", menu.getPrice());
			menuInfo.put("info", URLEncoder.encode(menu.getMenuInfo(), "UTF-8"));
			
			result.add(menuInfo);
		}
		menuPage.put("currentPage", pi.getCurrentPage());
		menuPage.put("listCount", pi.getListCount());
		menuPage.put("limit", pi.getLimit());
		menuPage.put("maxPage", pi.getMaxPage());
		menuPage.put("startPage", pi.getStartPage());
		menuPage.put("endPage", pi.getEndPage());
		
		result.add(menuPage);
		
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
