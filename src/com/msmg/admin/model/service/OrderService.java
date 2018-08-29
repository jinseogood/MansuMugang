package com.msmg.admin.model.service;

import static com.msmg.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.admin.model.dao.OrderDao;
import com.msmg.admin.model.vo.Order;

public class OrderService {

	public int getListCount() {
		Connection con=getConnection();
		
		int listCount=new OrderDao().getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Order> selectOrderList(int currentPage, int limit) {
		Connection con=getConnection();
		
		ArrayList<Order> oList=new OrderDao().selectOrderList(currentPage, limit, con);
		
		close(con);
		
		return oList;
	}

	public int getSearchListCount(String type, String content) {
		Connection con=getConnection();
		
		int oSearchListCount=new OrderDao().getSearchListCount(type, content, con);
		
		close(con);
		
		return oSearchListCount;
	}

	public ArrayList<Order> searchOrderList(int currentPage, int limit, String type, String content) {
		Connection con=getConnection();
		
		ArrayList<Order> oSearchList=new OrderDao().searchOrderList(currentPage, limit, type, content, con);
		
		close(con);
		
		return oSearchList;
	}

	public int getSelectOneListCount(String dietNo) {
		Connection con=getConnection();
		
		int listCount=new OrderDao().getSelectOneListCount(dietNo, con);
		
		close(con);
		
		return listCount;
	}
	
	public ArrayList<Order> selectOneOrderList(int currentPage, int limit, String dietNo) {
		Connection con=getConnection();
		
		ArrayList<Order> oSelectOneList=new OrderDao().selectOneOrderList(currentPage, limit, dietNo, con);
		
		close(con);
		
		return oSelectOneList;
	}

	public int selectOneOrderPriceList(String dietNo) {
		Connection con=getConnection();
		
		int totalPrice=new OrderDao().selectOneOrderPriceList(dietNo, con);
		
		close(con);
		
		return totalPrice;
	}

	public int updateStatus(String dietNo, String status) {
		Connection con=getConnection();
		
		int result=new OrderDao().updateStatus(dietNo, status, con);
		
		if(result>0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}
