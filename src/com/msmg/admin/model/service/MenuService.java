package com.msmg.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.msmg.admin.model.dao.MenuDao;
import com.msmg.admin.model.vo.MenuInfo;
import com.msmg.admin.model.vo.Menu;

import static com.msmg.common.JDBCTemplate.*;

public class MenuService {

	public int insertMenu(Menu menu, ArrayList<MenuInfo> fileList) {
		Connection con=getConnection();
		
		int result=0;
		
		int result1=new MenuDao().insertMenu(menu, con);
		
		if(result1>0){
			int menuCode=new MenuDao().selectCurrval(con);
			
			for(int i=0;i<fileList.size();i++){
				fileList.get(i).setMenuCode(menuCode);
			}
		}
		
		int result2=new MenuDao().insertMenuInfo(fileList, con);
		
		if(result1>0 && result2>0){
			commit(con);
			result=1;
		}
		else{
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public ArrayList<Menu> selectMenuList(int currentPage, int limit) {
		Connection con=getConnection();
		
		ArrayList<Menu> menuList=new MenuDao().selectMenuList(currentPage, limit, con);
		
		close(con);
		
		return menuList;
	}

	public int getListCount() {
		Connection con=getConnection();
		
		int listCount=new MenuDao().getListCount(con);
		
		close(con);
		
		return listCount;
	}

}
