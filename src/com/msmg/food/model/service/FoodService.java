package com.msmg.food.model.service;

import static com.msmg.common.JDBCTemplate.close;
import static com.msmg.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.food.controller.MenuListG;
import com.msmg.food.model.dao.SelectFoodDao;
import com.msmg.food.model.vo.Buy;
import com.msmg.food.model.vo.Menu;
import com.msmg.food.model.vo.MenuList;
import com.msmg.food.model.vo.SelectFood;

public class FoodService {

	public ArrayList<Menu> selectFood(SelectFood sf, int user) {
		Connection con = getConnection();
		
		ArrayList<Menu> list = new SelectFoodDao().selectFood(con, sf, user);
		
		close(con);
		return list;
	}

	public int insertMenuBuy(ArrayList<Buy> list) {
		Connection con = getConnection();
		
		int result = new SelectFoodDao().insertMenuBuy(con, list);
		
		close(con);
		return result;
	}

	public ArrayList<MenuList> menuListG() {
		
		Connection con = getConnection();
		
		ArrayList<MenuList> list = new SelectFoodDao().menuListG(con);
		
		close(con);
		return list;
	}

	public ArrayList<MenuList> menuListD() {
		Connection con = getConnection();
		
		ArrayList<MenuList> list = new SelectFoodDao().menuListD(con);
		
		close(con);
		return list;
	}

	public ArrayList<MenuList> menuListH() {
		Connection con = getConnection();
		
		ArrayList<MenuList> list = new SelectFoodDao().menuListH(con);
		
		close(con);
		return list;
	}

	public int insertLike(int u_code, int m_code) {
		Connection con = getConnection();
		
		int result = new SelectFoodDao().insertLike(con, u_code, m_code);
		
		close(con);
		return result;
	}

	public int deleteLike(int u_code, int m_code) {
		Connection con = getConnection();
		
		int result = new SelectFoodDao().deleteLike(con, u_code, m_code);
		
		close(con);
		return result;
	}

}
