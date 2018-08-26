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
@WebServlet("/imgDelete.no")
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
		String src = request.getParameter("src"); //경로
		String root = request.getSession().getServletContext().getRealPath("/"); //웹서버 컨테이너 경로 
		String[] srcArr = src.split("/");
		
		System.out.println(src);
		
		String fileName = "";
		
		//파일이름 가져오기
		for(int i = 0; i < srcArr.length; i++){
			fileName = srcArr[i];
		}
		
		int result = new NoticeService().deleteAttachment(fileName); //이미지 db에서 삭제
		
		String savePath = root + "attach_file/pic_file/";
		
		//파일 생성 후 삭제
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
