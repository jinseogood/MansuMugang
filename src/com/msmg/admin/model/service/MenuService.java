package com.msmg.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.admin.model.dao.MenuDao;
import com.msmg.admin.model.vo.Attachment;
import com.msmg.admin.model.vo.Menu;

import static com.msmg.common.JDBCTemplate.*;

public class MenuService {

	public int insertMenu(Menu menu, ArrayList<Attachment> fileList) {
		Connection con=getConnection();
		
		int result=new MenuDao().insertMenu(menu, con);
		
		if(result>0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public ArrayList<Menu> selectMenuList() {
		Connection con=getConnection();
		
		ArrayList<Menu> menuList=new MenuDao().selectMenuList(con);
		
		close(con);
		
		return menuList;
	}

}
