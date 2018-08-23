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

import com.msmg.member.model.service.MemberService;
import com.msmg.member.model.vo.Member;

@WebServlet("/selectMemberList")
public class SelectMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectMemberServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Member> mList=new MemberService().selectMemberList();
		
		JSONArray result=new JSONArray();
		JSONObject mInfo=null;
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
