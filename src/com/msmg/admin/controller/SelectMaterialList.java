package com.msmg.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.msmg.admin.model.service.MaterialService;
import com.msmg.admin.model.vo.Material;
import com.msmg.admin.model.vo.PageInfo;

@WebServlet("/selectMatList")
public class SelectMaterialList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectMaterialList() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage=1;
				
		if(request.getParameter("currentPage") != null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
				
		int listCount=new MaterialService().getListCount();
		
		limit=10;
				
		maxPage=(int)((double)listCount / limit + 0.9);
				
		startPage=((int)(((double)currentPage / limit + 0.9) - 1) * limit + 1);
				
		endPage=startPage+limit-1;
				
		if(maxPage < endPage){
			endPage=maxPage;
		}
				
		PageInfo pi=new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		ArrayList<Material> matList=new MaterialService().selectMatList(currentPage, limit);
		
		System.out.println(pi);
		
		if(matList != null){
			JSONArray result=new JSONArray();
			JSONObject matInfo=null;
			JSONObject matPage=new JSONObject();
			for(Material mat : matList){
				matInfo=new JSONObject();
				
				matInfo.put("matCode", URLEncoder.encode(mat.getM_code(), "UTF-8"));
				matInfo.put("matName", URLEncoder.encode(mat.getM_name(), "UTF-8"));
				matInfo.put("alleCode", URLEncoder.encode(mat.getA_code(), "UTF-8"));
				matInfo.put("d_go", URLEncoder.encode(mat.getD_go(), "UTF-8"));
				matInfo.put("d_dang", URLEncoder.encode(mat.getD_dang(), "UTF-8"));
				matInfo.put("d_head", URLEncoder.encode(mat.getD_head(), "UTF-8"));
				
				result.add(matInfo);
			}
			matPage.put("currentPage", pi.getCurrentPage());
			matPage.put("listCount", pi.getListCount());
			matPage.put("limit", pi.getLimit());
			matPage.put("maxPage", pi.getMaxPage());
			matPage.put("startPage", pi.getStartPage());
			matPage.put("endPage", pi.getEndPage());
			
			result.add(matPage);
			
			System.out.println(result);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out=response.getWriter();
			out.print(result.toJSONString());
			
			out.flush();
			out.close();
		}
		else{
			System.out.println("error");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
