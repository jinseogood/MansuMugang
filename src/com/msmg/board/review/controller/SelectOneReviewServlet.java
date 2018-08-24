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

import com.msmg.board.information.model.vo.Board;
import com.msmg.board.review.model.service.ReviewService;
import com.msmg.board.review.model.vo.BoardFile;

/**
 * Servlet implementation class SelectOneReviewServlet
 */
@WebServlet("/selectOne.rev")
public class SelectOneReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("selectOne 넘어옴");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		System.out.println(num);
		
		HashMap<String, Object> hmap = new ReviewService().selectOneReview(num);
		
		String page = "";
		
		if(hmap != null) {
			page = "views/board/review/reviewThumbnailDetail.jsp";
			
			request.setAttribute("b", (Board)hmap.get("board"));
			request.setAttribute("fileList", (ArrayList<BoardFile>)hmap.get("boardFile"));
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "사진 게시판 상세 보기 실패!");
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
