package com.msmg.admin.model.service;

import static com.msmg.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.admin.model.dao.StatDao;
import com.msmg.admin.model.vo.Stat;

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

	public int countGo() {
		Connection con=getConnection();
		
		int dietGoCount=new StatDao().countGo(con);
		
		close(con);
		
		return dietGoCount;
	}

	public int countDang() {
		Connection con=getConnection();
		
		int dietDangCount=new StatDao().countDang(con);
		
		close(con);
		
		return dietDangCount;
	}

	public int countHead() {
		Connection con=getConnection();
		
		int dietHeadCount=new StatDao().countHead(con);
		
		close(con);
		
		return dietHeadCount;
	}

	public int countGD() {
		Connection con=getConnection();
		
		int dietGDCount=new StatDao().countGD(con);
		
		close(con);
		
		return dietGDCount;
	}

	public int countGH() {
		Connection con=getConnection();
		
		int dietGHCount=new StatDao().countGH(con);
		
		close(con);
		
		return dietGHCount;
	}

	public int countDH() {
		Connection con=getConnection();
		
		int dietDHCount=new StatDao().countDH(con);
		
		close(con);
		
		return dietDHCount;
	}

	public int countGDH() {
		Connection con=getConnection();
		
		int dietGDHCount=new StatDao().countGDH(con);
		
		close(con);
		
		return dietGDHCount;
	}

	public ArrayList<Stat> countGoMenu() {
		Connection con=getConnection();
		
		ArrayList<Stat> mStatList=new StatDao().countGoMenu(con);
		
		close(con);
		
		return mStatList;
	}
	
	public ArrayList<Stat> countDangMenu() {
		Connection con=getConnection();
		
		ArrayList<Stat> mStatList=new StatDao().countDangMenu(con);
		
		close(con);
		
		return mStatList;
	}
	
	public ArrayList<Stat> countHeadMenu() {
		Connection con=getConnection();
		
		ArrayList<Stat> mStatList=new StatDao().countHeadMenu(con);
		
		close(con);
		
		return mStatList;
	}


}
