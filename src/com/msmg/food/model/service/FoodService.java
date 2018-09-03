package com.msmg.food.model.service;

import static com.msmg.common.JDBCTemplate.close;
import static com.msmg.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.food.controller.MenuListG;
import com.msmg.food.model.dao.SelectFoodDao;
import com.msmg.food.model.vo.Buy;
import com.msmg.food.model.vo.Cart;
import com.msmg.food.model.vo.Like;
import com.msmg.food.model.vo.Menu;
import com.msmg.food.model.vo.MenuList;
import com.msmg.food.model.vo.SelectFood;
import com.msmg.member.model.dao.MemberDao;

public class FoodService {

	public ArrayList<Menu> selectFood(SelectFood sf, int user) {
		Connection con = getConnection();
		
		ArrayList<Menu> list = new SelectFoodDao().selectFood(con, sf, user);
		 
		close(con);
		return list;
	}

	public int insertMenuBuy(ArrayList<Buy> list, String user_date, String diet_name, int side) {
		Connection con = getConnection();
		
		int result = new SelectFoodDao().insertMenuBuy(con, list, user_date, diet_name, side);
		System.out.println("insertMenuBuy Service 실행");
		
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

	public ArrayList<Like> likeCheck(int i) {
		Connection con = getConnection();
		
		ArrayList<Like> MenuList = new SelectFoodDao().likeCheck(con, i);
		
		close(con);
		return MenuList;
	}

	public ArrayList<Cart> selectList(String ucode) {
		Connection con = getConnection();
		
		ArrayList<Cart> list = new SelectFoodDao().selectList(con, ucode);
		System.out.println("장바구니로 넣는 FoodService 실행");
		
		close(con);
		
		return list;
	}

	public int deleteCart(Cart c) {
		Connection con = getConnection();
		
		int result = new SelectFoodDao().deleteCart(c);
		
		close(con);
		
		
		return result;
	}

	public ArrayList<MenuList> menuListGLike(int u_code) {
		Connection con = getConnection();
		
		ArrayList<MenuList> result = new SelectFoodDao().menuListGLike(con, u_code);
		
		close(con);
		
		
		return result;
	}

	public ArrayList<MenuList> menuListDLike(int u_code) {
		Connection con = getConnection();
		
		ArrayList<MenuList> result = new SelectFoodDao().menuListDLike(con, u_code);
		
		close(con);
		
		
		return result;
	}

	public ArrayList<MenuList> menuListHLike(int u_code) {
		Connection con = getConnection();
		
		ArrayList<MenuList> result = new SelectFoodDao().menuListHLike(con, u_code);
		
		close(con);
		
		
		return result;
	}




}
