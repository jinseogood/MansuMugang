package com.msmg.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.admin.model.service.MenuService;
import com.msmg.admin.model.vo.Menu;

@WebServlet("/addMenu")
public class InsertMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertMenuServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menuName=request.getParameter("menuName");
		String mainMat=request.getParameter("mainMat");
		String subMat=request.getParameter("subMat");
		String price=request.getParameter("price");
		
		Menu menu=new Menu();
		menu.setMenuName(menuName);
		menu.setMainMat(mainMat);
		menu.setSubMat(subMat);
		menu.setPrice(Integer.parseInt(price));
		
		int result=new MenuService().insertMenu(menu);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
