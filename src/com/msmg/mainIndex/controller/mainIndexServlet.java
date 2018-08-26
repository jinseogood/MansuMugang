package com.msmg.mainIndex.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.mainIndex.model.service.IndexService;
import com.msmg.mainIndex.model.vo.MenuIndex;

/**
 * Servlet implementation class mainIndexServlet
 */
@WebServlet("/tt")
public class mainIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mainIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MenuIndex> goList = new IndexService().selectGoTopMenu();
		ArrayList<MenuIndex> dangList = new IndexService().selectDangTopMenu();
		ArrayList<MenuIndex> headList = new IndexService().selectHeadTopMenu();
		
		String page = "";
		
		if(goList != null && dangList != null && headList != null){
			page = "index.jsp";
			request.setAttribute("goList", goList);
			request.setAttribute("dangList", dangList);
			request.setAttribute("headList", headList);
		}else{
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "메인 리스트 에러");
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
