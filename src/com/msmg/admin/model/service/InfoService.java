package com.msmg.admin.model.service;


import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.admin.model.dao.InfoDao;
import com.msmg.admin.model.vo.Info;

import static com.msmg.common.JDBCTemplate.*;

public class InfoService {
	
	public int getListCount() {
		Connection con = getConnection();
		
		int listCount = new InfoDao().getListCount(con);
		
		close(con);
		
		return listCount;
	}
	
	public ArrayList<Info> selectInfoList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<Info> list = new InfoDao().selectInfoList(currentPage, limit, con);
		
		close(con);
		
		return list;
		
	}

	public int getSearchListCount(String type, String content) {
		Connection con=getConnection();
		
		int sListCount=new InfoDao().getSearchListCount(type, content, con);
		
		close(con);
		
		return sListCount;
	}

	public ArrayList<Info> searchInfoList(int currentPage, int limit, String type, String content) {
		Connection con=getConnection();
		
		ArrayList<Info> sInfoList=new InfoDao().searchInfoList(currentPage, limit, type, content, con);
		
		close(con);
		
		return sInfoList;
	}

}
