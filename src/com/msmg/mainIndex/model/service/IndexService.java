package com.msmg.mainIndex.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.mainIndex.model.dao.IndexDao;
import com.msmg.mainIndex.model.vo.MenuIndex;

import static com.msmg.common.JDBCTemplate.*;

public class IndexService {

	public ArrayList<MenuIndex> selectGoTopMenu() {
		Connection conn = getConnection();
		
		ArrayList<MenuIndex> list = new IndexDao().selectGoTopMenu(conn);
			
		close(conn);
		
		return list;
	}

	public ArrayList<MenuIndex> selectDangTopMenu() {
		Connection conn = getConnection();
		
		ArrayList<MenuIndex> list = new IndexDao().selectDangTopMenu(conn);
			
		close(conn);
		
		return list;
	}

	public ArrayList<MenuIndex> selectHeadTopMenu() {
		Connection conn = getConnection();
		
		ArrayList<MenuIndex> list = new IndexDao().selectHeadTopMenu(conn);
			
		close(conn);
		
		return list;
	}

}
