package com.msmg.admin.model.service;

import com.msmg.admin.model.dao.MaterialDao;
import com.msmg.admin.model.vo.Material;

import static com.msmg.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

public class MaterialService {

	public int insertMaterial(Material m) {
		Connection con=getConnection();
		
		int result=new MaterialDao().insertMaterial(m, con);
		
		if(result>0){
			commit(con);
		}
		else{
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public ArrayList<Material> selectMatList(int currentPage, int limit) {
		Connection con=getConnection();
		
		ArrayList<Material> matList=new MaterialDao().selectMatList(currentPage, limit, con);
		
		close(con);
		
		return matList;
	}

	public int getListCount() {
		Connection con=getConnection();
		
		int listCount=new MaterialDao().getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<Material> selectMatList() {
		Connection con=getConnection();
		
		ArrayList<Material> matList=new MaterialDao().selectMatList(con);
		
		close(con);
		
		return matList;
	}

}
