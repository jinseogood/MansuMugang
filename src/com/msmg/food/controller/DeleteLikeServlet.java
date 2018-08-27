package com.msmg.food.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.food.model.service.FoodService;
import com.msmg.food.model.vo.Like;

@WebServlet("/DeleteLike.fo")
public class DeleteLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteLikeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int u_code = Integer.parseInt(request.getParameter("user_no"));
		int m_code = Integer.parseInt(request.getParameter("num"));
		
		int result = new FoodService().deleteLike(u_code, m_code);
		
		Like l = new Like(u_code, m_code);
		
		response.getWriter().print(l);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
