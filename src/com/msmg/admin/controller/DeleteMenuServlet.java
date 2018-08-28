package com.msmg.admin.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.admin.model.service.MenuService;

@WebServlet("/deleteMenu")
public class DeleteMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteMenuServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mCode=Integer.parseInt(request.getParameter("menuCode"));
		
		String root = request.getSession().getServletContext().getRealPath("/");
		
		System.out.println("root : " + root);
		
		String filePath=root + "images/food/";
		
		String fileEditName=new MenuService().selectMenuFileName(mCode);
		
		int result=new MenuService().deleteMenu(mCode);
		
		System.out.println("fileEName : " + fileEditName);
		
		if(result>0){
			System.out.println("삭제 성공");
			File file=new File(filePath + fileEditName);
			file.delete();
		}
		else{
			System.out.println("삭제 실패");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
