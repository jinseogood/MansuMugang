package com.msmg.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.admin.model.dao.NoticeDao;
import com.msmg.admin.model.vo.Notice;

import static com.msmg.common.JDBCTemplate.*;

public class NoticeService {

	public ArrayList<Notice> selectNoticeList() {
		Connection con=getConnection();
		
		ArrayList<Notice> nList=new NoticeDao().selectNoticeList(con);
		
		System.out.println("service : " + nList);
		
		close(con);
		
		return nList;
	}

}
