package com.msmg.food.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.food.model.service.FoodService;
import com.msmg.food.model.vo.Buy;
import com.msmg.food.model.vo.Cart;
import com.msmg.payment.model.service.DestinationService;
import com.msmg.payment.model.vo.Destination;

/**
 * Servlet implementation class InsertShoppingCartServlet
 */
@WebServlet("/insertCart.fo")
public class InsertShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public InsertShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int go = Integer.parseInt(request.getParameter("go"));
		int dang = Integer.parseInt(request.getParameter("dang"));
		int head = Integer.parseInt(request.getParameter("head"));
		int day = Integer.parseInt(request.getParameter("day"));
		int ggi = Integer.parseInt(request.getParameter("ggi"));
		int side = Integer.parseInt(request.getParameter("side"));
		String resultlist = request.getParameter("result");
		String m_resultlist = request.getParameter("menu_result");
		int total_price = Integer.parseInt(request.getParameter("total_price"));
		String ucode = request.getParameter("user");
		String[] price = m_resultlist.split(", ");
		String[] mcode = resultlist.split(", ");
		String diet_name = "";
		
		ArrayList<Destination> desList = new DestinationService().selectList(ucode);
		
		ArrayList<Buy> list = new ArrayList<Buy>();
		
		if(side == 1){
			if(go == 1){
				diet_name = "고혈압 "+ day + "일 " + ggi + "끼 식단(밑반찬 포함)";
			}else if(go == 1 && dang == 1){
				diet_name = "고혈압, 당뇨 "+ day + "일 " + ggi + "끼 식단(밑반찬 포함)";
			}else if(go == 1 && head == 1){
				diet_name = "고혈압, 뇌질환 "+ day + "일 " + ggi + "끼 식단(밑반찬 포함)";
			}else if(head == 1 && dang == 1){
				diet_name = "당뇨, 뇌질환 "+ day + "일 " + ggi + "끼 식단(밑반찬 포함)";
			}else if(dang == 1){
				diet_name = "당뇨 "+ day + "일 " + ggi + "끼 식단(밑반찬 포함)";
			}else if(head == 1){
				diet_name = "뇌질환 "+ day + "일 " + ggi + "끼 식단(밑반찬 포함)";
			}else{
				diet_name = "고혈압, 뇌질환, 당뇨 "+ day + "일 " + ggi + "끼 식단(밑반찬 포함)";
			}
		}else{
			if(go == 1){
				diet_name = "고혈압 "+ day + "일 " + ggi + "끼 식단(밑반찬 포함)";
			}else if(go == 1 && dang == 1){
				diet_name = "고혈압, 당뇨 "+ day + "일 " + ggi + "끼 식단(밑반찬 포함)";
			}else if(go == 1 && head == 1){
				diet_name = "고혈압, 뇌질환 "+ day + "일 " + ggi + "끼 식단(밑반찬 포함)";
			}else if(head == 1 && dang == 1){
				diet_name = "당뇨, 뇌질환 "+ day + "일 " + ggi + "끼 식단(밑반찬 포함)";
			}else if(dang == 1){
				diet_name = "당뇨 "+ day + "일 " + ggi + "끼 식단(밑반찬 포함)";
			}else if(head == 1){
				diet_name = "뇌질환 "+ day + "일 " + ggi + "끼 식단(밑반찬 포함)";
			}else{
				diet_name = "고혈압, 뇌질환, 당뇨 "+ day + "일 " + ggi + "끼 식단(밑반찬 포함)";
			}
		}
		if(mcode != null && price != null){
			for(int i = 0 ; i < mcode.length; i++){
				Buy b = new Buy();
				b.setUcode(ucode);
				b.setMcode(mcode[i]);
				b.setPrice(Integer.parseInt(price[i]));
				
				list.add(b);
			}
		}
		
		long time = System.currentTimeMillis();
		 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddhhmmss");
		 
		String nowTime = dayTime.format(new Date(time));
		
		String user_date = nowTime+ucode;
		
		int result = new FoodService().insertMenuBuy(list, user_date, diet_name, side);

		ArrayList<Cart> list1 = new FoodService().selectList(ucode);
		System.out.println("InsertShoppingCartServlet 실행");
		
		String page = "";
		 
		if(result > 0){
			/*page = "/views/member/ShoppingCart.jsp";
			request.setAttribute("totalprice", total_price);
			request.setAttribute("day", day);
			request.setAttribute("ggi", ggi);
			request.setAttribute("side", side);
			request.setAttribute("buyList", list);
			request.setAttribute("desList", desList);
			request.setAttribute("diet_no", user_date);
			request.setAttribute("diet_name", diet_name);
			request.setAttribute("msg", "장바구니로 이동");*/
			page = "views/member/ShoppingCart.jsp";
			request.setAttribute("list", list1);
		}else{
			page = "/views/common/errorPage.jsp";
			request.setAttribute("msg", "이동할 메뉴가 없습니다.");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
