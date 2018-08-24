package com.msmg.food.model.service;

import static com.msmg.common.JDBCTemplate.close;
import static com.msmg.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.food.model.dao.SelectFoodDao;
import com.msmg.food.model.vo.Menu;
import com.msmg.food.model.vo.SelectFood;

public class FoodService {

	public ArrayList<Menu> selectFood(SelectFood sf, int user) {
		Connection con = getConnection();
		
		ArrayList<Menu> list = new SelectFoodDao().selectFood(con, sf, user);
		
		close(con);
		return list;
	}

}
