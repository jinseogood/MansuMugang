package com.msmg.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addMenu")
public class InsertMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertMenuServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menuName=request.getParameter("menuName");
		String mainMat=request.getParameter("mainMat");
		String subMat=request.getParameter("subMat");
		String price=request.getParameter("price");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
