package com.msmg.mypage.model.service;

import java.sql.Connection;
import java.util.ArrayList;  

import com.msmg.mypage.model.dao.MypageDao;
import com.msmg.mypage.model.vo.BuyAll;

import static com.msmg.common.JDBCTemplate.*;

public class MypageService {

	public ArrayList<BuyAll> selectBuyAll(BuyAll ba) {
		Connection con = getConnection();
		
		ArrayList<BuyAll> bList = new MypageDao().selectBuyAll(con, ba);
		
		close(con);
		
		return bList;
	}

}
