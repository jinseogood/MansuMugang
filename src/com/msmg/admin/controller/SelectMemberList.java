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

import com.msmg.admin.model.vo.PageInfo;
import com.msmg.member.model.service.MemberService;
import com.msmg.member.model.vo.Member;

@WebServlet("/selectMemberList")
public class SelectMemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectMemberList() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage;
		int limit;
		int maxPage;
		int startPage;
		int endPage;
		
		currentPage=1;
				
		if(request.getParameter("currentPage") != null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount=new MemberService().getListCount();
		
		limit=10;
		
		maxPage=(int)((double)listCount / limit + 0.9);
				
		startPage=((int)(((double)currentPage / limit + 0.9) - 1) * limit + 1);
				
		endPage=startPage+limit-1;
				
		if(maxPage < endPage){
			endPage=maxPage;
		}
				
		PageInfo pi=new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		ArrayList<Member> mList=new MemberService().selectMemberList(currentPage, limit);
		
		JSONArray result=new JSONArray();
		JSONObject mInfo=null;
		JSONObject mPage=new JSONObject();
		for(Member m : mList){
			mInfo=new JSONObject();
			
			mInfo.put("mCode", m.getU_code());
			mInfo.put("mName", URLEncoder.encode(m.getU_name(), "UTF-8"));
			mInfo.put("mId", URLEncoder.encode(m.getU_id(), "UTF-8"));
			mInfo.put("mTel", URLEncoder.encode(m.getU_tel(), "UTF-8"));
			mInfo.put("mAddr", URLEncoder.encode(m.getU_addr(), "UTF-8"));
			mInfo.put("mType", URLEncoder.encode(m.getU_type(), "UTF-8"));
			mInfo.put("mDrop", URLEncoder.encode(m.getDrop_yn(), "UTF-8"));
			
			result.add(mInfo);
		}
		mPage.put("currentPage", pi.getCurrentPage());
		mPage.put("listCount", pi.getListCount());
		mPage.put("limit", pi.getLimit());
		mPage.put("maxPage", pi.getMaxPage());
		mPage.put("startPage", pi.getStartPage());
		mPage.put("endPage", pi.getEndPage());
		
		result.add(mPage);
		
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
