package com.msmg.board.notice.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.board.notice.model.service.NoticeService;

/**
 * Servlet implementation class ImgDeleteServlet
 */
@WebServlet("/imgDelete.bo")
public class ImgDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String src = request.getParameter("src");
		String data = request.getParameter("data");
		String root = request.getSession().getServletContext().getRealPath("/");
		String[] srcArr = src.split("/");
		
		System.out.println(src);
		
		String fileName = "";
		
		for(int i = 0; i < srcArr.length; i++){
			fileName = srcArr[i];
		}
		
		int result = new NoticeService().deleteImg(fileName);
		
		String savePath = root + "attach_file/pic_file/";
		
		File deleteFile = new File(savePath + fileName);
		deleteFile.delete();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
