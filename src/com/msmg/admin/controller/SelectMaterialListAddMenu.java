package com.msmg.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.admin.model.service.MaterialService;
import com.msmg.admin.model.vo.Material;

@WebServlet("/selectMatAddMenu")
public class SelectMaterialListAddMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectMaterialListAddMenu() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Material> matList=new MaterialService().selectMatList();
		
		System.out.println("servlet : " + matList);
		
		String page="";
		
		if(matList != null){
			page="/views/admin/addMenu.jsp";
			request.setAttribute("matList", matList);
		}
		else{
			System.out.println("error");
		}
		
		RequestDispatcher view=request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
