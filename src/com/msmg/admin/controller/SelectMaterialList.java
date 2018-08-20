package com.msmg.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.msmg.admin.model.service.MaterialService;
import com.msmg.admin.model.vo.Material;

@WebServlet("/selectMatList")
public class SelectMaterialList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectMaterialList() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Material> matList=new MaterialService().selectMatList();
		
		/*String page="";
		
		if(matList != null){
			JSONArray result=new JSONArray();
			JSONObject matInfo=null;
			for(Material mat : matList){
				matInfo=new JSONObject();
				
				matInfo.put("matCode", URLEncoder.encode(mat.getM_code(), "UTF-8"));
				matInfo.put("matName", URLEncoder.encode(mat.getM_name(), "UTF-8"));
				matInfo.put("alleCode", URLEncoder.encode(mat.getA_code(), "UTF-8"));
				matInfo.put("d_go", URLEncoder.encode(mat.getD_go(), "UTF-8"));
				matInfo.put("d_dang", URLEncoder.encode(mat.getD_dang(), "UTF-8"));
				matInfo.put("d_head", URLEncoder.encode(mat.getD_head(), "UTF-8"));
				
				result.add(matInfo);
			}
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			
			PrintWriter out=response.getWriter();
			out.print(result.toJSONString());
			
			out.flush();
			out.close();
		}
		else{
			page="/views/common/errorPage.jsp";
			request.setAttribute("msg", "관리자 재료 조회 실패");
			RequestDispatcher view=request.getRequestDispatcher(page);
			view.forward(request, response);
		}*/
		
		JSONArray result=new JSONArray();
		JSONObject matInfo=null;
		for(Material mat : matList){
			matInfo=new JSONObject();
			
			matInfo.put("matCode", URLEncoder.encode(mat.getM_code(), "UTF-8"));
			matInfo.put("matName", URLEncoder.encode(mat.getM_name(), "UTF-8"));
			matInfo.put("alleCode", URLEncoder.encode(mat.getA_code(), "UTF-8"));
			matInfo.put("d_go", URLEncoder.encode(mat.getD_go(), "UTF-8"));
			matInfo.put("d_dang", URLEncoder.encode(mat.getD_dang(), "UTF-8"));
			matInfo.put("d_head", URLEncoder.encode(mat.getD_head(), "UTF-8"));
			
			result.add(matInfo);
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out=response.getWriter();
		out.print(result.toJSONString());
		
		out.flush();
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
