package com.msmg.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.msmg.board.information.model.service.BoardService;
import com.msmg.board.information.model.vo.Board;
import com.google.gson.Gson;
import com.msmg.admin.model.vo.Material;
import com.msmg.admin.model.vo.PageInfo;

@WebServlet("/selectInfoList")
public class SelectInfoBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectInfoBoardServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = new BoardService().getListCount();
		
		limit = 10;
		
		maxPage = (int)((double)listCount / limit + 0.9);
		
		startPage = (((int)((double)currentPage / limit + 0.9)) -1) * limit + 1;
		
		endPage = startPage + limit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		ArrayList<Board> infoList=new BoardService().selectList(currentPage, limit);
		
		/*JSONArray result=new JSONArray();
		JSONObject boardInfo=null;
		JSONObject infoPage=new JSONObject();
		for(Board info : infoList){
			boardInfo=new JSONObject();
			
			boardInfo.put("bNo", info.getBoardNo());
			boardInfo.put("bTitle", URLEncoder.encode(info.getTitle(), "UTF-8"));
			boardInfo.put("bWriter", URLEncoder.encode(info.getuCode(), "UTF-8"));
			boardInfo.put("bDate", info.getBoardDate());
			boardInfo.put("bCount", info.getbCount());
			
			result.add(boardInfo);
		}
		infoPage.put("currentPage", pi.getCurrentPage());
		infoPage.put("listCount", pi.getListCount());
		infoPage.put("limit", pi.getLimit());
		infoPage.put("maxPage", pi.getMaxPage());
		infoPage.put("startPage", pi.getStartPage());
		infoPage.put("endPage", pi.getEndPage());
			
		result.add(infoPage);
			
		System.out.println(result);
			
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
			
		PrintWriter out=response.getWriter();
		out.print(result.toJSONString());
			
		out.flush();
		out.close();*/
		
		System.out.println("servlet pi : " + pi);
		System.out.println("servlet infoList : " + infoList);
					
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		Gson gson=new Gson();
		//gson.toJson(pi, response.getWriter());
		gson.toJson(infoList, response.getWriter());
		//new Gson().toJson(infoList, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
