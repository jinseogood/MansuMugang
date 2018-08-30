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
import com.msmg.food.model.vo.Like;
import com.msmg.food.model.vo.MenuList;


@WebServlet("/MenuListDLike.fo")
public class MenuListDLike extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MenuListDLike() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MenuList> list = new ArrayList<MenuList>();
		ArrayList<Like> MenuList = new ArrayList<Like>();
		list = new FoodService().menuListD();
		int u_code = 0;
		
		if(request.getParameter("user") != null){
			u_code = Integer.parseInt(request.getParameter("user"));
		}
		String page = "";
		if(list != null){
			if(MenuList != null){
				MenuList = new FoodService().likeCheck(u_code);
				request.setAttribute("MenuList", MenuList);
			}	
			page = "/views/menu/menuLikeIntro2.jsp";
			request.setAttribute("list", list);
			request.setAttribute("msg", "메뉴 리스트");
		}else{
			page = "/views/common/errorPage.jsp";
			request.setAttribute("msg", "해당하는 메뉴가 없습니다.");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

}
