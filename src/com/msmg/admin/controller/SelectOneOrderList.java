package com.msmg.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.admin.model.service.OrderService;
import com.msmg.admin.model.vo.Order;
import com.msmg.admin.model.vo.PageInfo;

@WebServlet("/selectOneOrderList")
public class SelectOneOrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectOneOrderList() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dietNo=request.getParameter("dietNo");
		
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage=1;
				
		if(request.getParameter("currentPage") != null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount=new OrderService().getSelectOneListCount(dietNo);
		
		limit=10;
		
		maxPage=(int)((double)listCount / limit + 0.9);
				
		startPage=((int)(((double)currentPage / limit + 0.9) - 1) * limit + 1);
				
		endPage=startPage+limit-1;
				
		if(maxPage < endPage){
			endPage=maxPage;
		}
				
		PageInfo pi=new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		ArrayList<Order> oSelectList=new OrderService().selectOneOrderList(currentPage, limit, dietNo);
		
		System.out.println("selectOneOrder Servlet : " + oSelectList);
		
		String page="";
		
		if(oSelectList != null){
			page="views/admin/detailOrder.jsp";
			request.setAttribute("oSelectList", oSelectList);
			request.setAttribute("pi", pi);
		}
		else{
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 조회 실패!!");
		}
		
		RequestDispatcher view=request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
