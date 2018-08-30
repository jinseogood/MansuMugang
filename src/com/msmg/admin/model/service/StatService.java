package com.msmg.admin.model.service;

import static com.msmg.common.JDBCTemplate.*;

import java.sql.Connection;

import com.msmg.admin.model.dao.StatDao;

public class StatService {

	public int countCard() {
		Connection con=getConnection();
		
		int payCard=new StatDao().countCard(con);
		
		close(con);
		
		return payCard;
	}

	public int countMoney() {
		Connection con=getConnection();
		
		int payMoney=new StatDao().countMoney(con);
		
		close(con);
		
		return payMoney;
	}

}
