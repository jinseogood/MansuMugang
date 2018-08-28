package com.msmg.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.admin.model.service.MaterialService;
import com.msmg.admin.model.service.MenuService;
import com.msmg.admin.model.vo.Material;
import com.msmg.admin.model.vo.Menu;

@WebServlet("/selectOneMenu")
public class SelectOneMenuList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectOneMenuList() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mCode=Integer.parseInt(request.getParameter("menuCode"));
		
		Menu m=new MenuService().selectOneMenu(mCode);
		ArrayList<Material> matList=new MaterialService().selectMatList();
		
		String page="";
		
		if(m != null){
			page="/views/admin/detailMenu.jsp";
			request.setAttribute("menu", m);
			request.setAttribute("matList", matList);
		}
		else{
			System.out.println("메뉴디테일 에러");
		}
		
		RequestDispatcher view=request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
