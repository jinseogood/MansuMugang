package com.msmg.mypage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.board.information.model.dao.BoardDao;
import com.msmg.mypage.model.dao.MypageDao;
import com.msmg.mypage.model.vo.Board;
import com.msmg.mypage.model.vo.BuyAll;

import static com.msmg.common.JDBCTemplate.*;
   
public class MypageService {

	public ArrayList<BuyAll> selectBuyAll(BuyAll ba) {
		Connection con = getConnection();
		
		ArrayList<BuyAll> bList = new MypageDao().selectBuyAll(con, ba);
		
		close(con);
		
		return bList;
	}

	public ArrayList<Board> selectBoard(Board b) {
		Connection con = getConnection();
		
		ArrayList<Board> list = new MypageDao().selectBoard(con, b);
		
		close(con);
		
		return list;
	}

	public int getListCount() {
		Connection con = getConnection();
		
		int listCount = new MypageDao().getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Board> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<Board> list = new MypageDao().selectList(con, currentPage, limit);
		
		close(con);
		
		return list;	
	}

}
