package com.msmg.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msmg.admin.model.service.MaterialService;
import com.msmg.admin.model.vo.Material;

@WebServlet("/addMaterial")
public class InsertMaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertMaterialServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matName=request.getParameter("matName");
		String alleCode=request.getParameter("alleCode");
		String disease1=request.getParameter("disease_go");
		String disease2=request.getParameter("disease_dang");
		String disease3=request.getParameter("disease_head");
		/*String[] disease=request.getParameterValues("disease");
		String diseases="";
		
		if(disease != null){
			for(int i=0;i<disease.length;i++){
				if(i==0){
					diseases+=disease[i];
				}
				else{
					diseases += ", " + disease[i];
				}
			}
		}*/
		
		if(disease1 != null){
			disease1="1";
		}
		else{
			disease1="0";
		}
		
		if(disease2 != null){
			disease2="1";
		}
		else{
			disease2="0";
		}
		
		if(disease3 != null){
			disease3="1";
		}
		else{
			disease3="0";
		}
		
		Material m=new Material();
		m.setM_name(matName);
		m.setA_code(alleCode);
		m.setD_go(disease1);
		m.setD_dang(disease2);
		m.setD_head(disease3);
		
		int result=new MaterialService().insertMaterial(m);
		
		String page="";
		
		if(result>0){
			page="/views/admin/addMaterial.jsp";
			request.setAttribute("msg", "재료 추가 성공!");
		}
		else{
			page="/views/admin/addMaterial.jsp";
			request.setAttribute("msg", "재료 추가 실패!");
		}
		
		RequestDispatcher view=request.getRequestDispatcher(page);
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
