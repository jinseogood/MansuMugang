package com.msmg.admin.model.service;

import java.sql.Connection;

import com.msmg.admin.model.dao.MenuDao;
import com.msmg.admin.model.vo.Menu;

import static com.msmg.common.JDBCTemplate.*;

public class MenuService {

	public int insertMenu(Menu menu) {
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

}
