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
import com.msmg.board.review.model.vo.BoardFile;

/**
 * Servlet implementation class UpdateReviewServlet
 */
@WebServlet("/update.rev")
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		
		System.out.println(num);
		
		/*int result = new ReviewService().deleteReviewBoardFile(num);*/
		
		HashMap<String, Object> hmap = new ReviewService().updateReview(num);
		
		System.out.println("update hmap : " + hmap);
		
		String page = "";
		
		
		if(hmap != null) {
			page = "views/board/review/updateReviewForm.jsp";
			request.setAttribute("fileList", (ArrayList<BoardFile>)hmap.get("boardFile"));
			request.setAttribute("b", hmap.get("board"));
			
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "사진 수정 페이지 보기 실패!");
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
