package com.msmg.food.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.food.model.service.FoodService;
import com.msmg.food.model.vo.MenuList;

@WebServlet("/MenuListH.fo")
public class MenuListH extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MenuListH() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MenuList> list = new ArrayList<MenuList>();
		
		list = new FoodService().menuListH();
		//System.out.println(list);
		String page = "";
		
		if(list != null){
			page = "/views/menu/menuIntro3.jsp";
			request.setAttribute("list", list);
			request.setAttribute("msg", "메뉴 리스트");
		}else{
			page = "/views/common/errorPage.jsp";
			request.setAttribute("msg", "해당하는 메뉴가 없습니다.");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
