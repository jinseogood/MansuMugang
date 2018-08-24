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
import com.msmg.food.model.vo.Menu;
import com.msmg.food.model.vo.SelectFood;

@WebServlet("/selectFoodList.fo")
public class SelectFoodList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SelectFoodList() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int user = Integer.parseInt(request.getParameter("user"));
		int go = Integer.parseInt(request.getParameter("go"));
		int dang = Integer.parseInt(request.getParameter("dang"));
		int head = Integer.parseInt(request.getParameter("head"));
		int three_day = Integer.parseInt(request.getParameter("three_day"));
		int seven_day = Integer.parseInt(request.getParameter("seven_day"));
		int one_ggi = Integer.parseInt(request.getParameter("one_ggi"));
		int two_ggi = Integer.parseInt(request.getParameter("two_ggi"));
		int three_ggi = Integer.parseInt(request.getParameter("three_ggi"));
		int side = Integer.parseInt(request.getParameter("side"));
		int day = 0;
		int ggi = 0;
		
		if(three_day == 0){
			day = seven_day;
		}else{
			day = three_day;
		}
		
		if(one_ggi != 0){
			ggi = one_ggi;
		}else if(two_ggi != 0){
			ggi = two_ggi;
		}else{
			ggi = three_ggi;
		}
		
		SelectFood sf = new SelectFood(go, dang, head, day, ggi, side);
		
		ArrayList<Menu> list = null;
		
		list = new FoodService().selectFood(sf, user);
		
		System.out.println(list);

				String page = "";
				
				if(list != null){
					page = "/views/foodPlan/last_plan.jsp";
					request.setAttribute("list", list);
					request.setAttribute("sf", sf);
					request.setAttribute("msg", "메뉴 리스트");
				}else{
					System.out.println("오긴오냐");
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
