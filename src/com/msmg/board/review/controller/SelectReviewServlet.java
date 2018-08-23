package com.msmg.board.review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.board.review.model.service.ReviewService;

/**
 * Servlet implementation class SelectReviewServlet
 */
@WebServlet("/selectList.rev")
public class SelectReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectReviewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<HashMap<String, Object>> list = new ReviewService().selectReviewList();
		
		String page = "";
		
		System.out.println("servlet : " + list);
		
		if(list != null) {
			page = "views/board/review/reviewThumbnailList.jsp";
			request.setAttribute("list", list);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "사진 게시판 조회 실패!");
		}
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
