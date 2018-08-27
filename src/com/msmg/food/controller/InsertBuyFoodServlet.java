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
import com.msmg.food.model.vo.Buy;
import com.msmg.payment.model.service.DestinationService;
import com.msmg.payment.model.vo.Destination;

@WebServlet("/insertBuy.fo")
public class InsertBuyFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertBuyFoodServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int go = Integer.parseInt(request.getParameter("go"));
		int dang = Integer.parseInt(request.getParameter("dang"));
		int head = Integer.parseInt(request.getParameter("head"));
		int day = Integer.parseInt(request.getParameter("day"));
		int ggi = Integer.parseInt(request.getParameter("ggi"));
		int side = Integer.parseInt(request.getParameter("side"));
		String resultlist = request.getParameter("result");
		int total_price = Integer.parseInt(request.getParameter("total_price"));
		String ucode = request.getParameter("user");
		String[] mcode = resultlist.split(", ");
		
		ArrayList<Destination> desList = new DestinationService().selectList(ucode);
		
		ArrayList<Buy> list = new ArrayList<Buy>();
		
		if(mcode != null){
			for(int i = 0 ; i < mcode.length; i++){
				Buy b = new Buy();
				b.setUcode(ucode);
				b.setMcode(mcode[i]);
				
				list.add(b);
			}
		}
		
		int result = new FoodService().insertMenuBuy(list);
		

		String page = "";
		
		if(result > 0){
			page = "/views/payment/paymentPage.jsp";
			request.setAttribute("totalprice", total_price);
			request.setAttribute("day", day);
			request.setAttribute("ggi", ggi);
			request.setAttribute("side", side);
			request.setAttribute("buyList", list);
			request.setAttribute("desList", desList);
			request.setAttribute("msg", "결제페이지로 이동");
		}else{
			page = "/views/common/errorPage.jsp";
			request.setAttribute("msg", "결제할 메뉴가 없습니다.");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
