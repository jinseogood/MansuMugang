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
import com.msmg.admin.model.vo.Material;
import com.msmg.admin.model.vo.Menu;

@WebServlet("/selectMenuList")
public class SelectMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectMenuServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Menu> menuList=new MenuService().selectMenuList();
		
		JSONArray result=new JSONArray();
		JSONObject menuInfo=null;
		for(Menu menu : menuList){
			menuInfo=new JSONObject();
			
			menuInfo.put("menuCode", URLEncoder.encode(menu.getMenuCode(), "UTF-8"));
			menuInfo.put("menuName", URLEncoder.encode(menu.getMenuName(), "UTF-8"));
			menuInfo.put("mainMat", URLEncoder.encode(menu.getMainMat(), "UTF-8"));
			menuInfo.put("subMat", URLEncoder.encode(menu.getSubMat(), "UTF-8"));
			menuInfo.put("price", menu.getPrice());
			
			result.add(menuInfo);
		}
		
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
