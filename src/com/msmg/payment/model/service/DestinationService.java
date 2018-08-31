package com.msmg.payment.model.service;

import java.sql.Connection;
import java.util.ArrayList;


import com.msmg.payment.model.dao.DestinationDao;
import com.msmg.payment.model.vo.Destination;


import static com.msmg.common.JDBCTemplate.*;
 
public class DestinationService {

	public int insertDestination(Destination d) {
		
		System.out.println("배송지 입력 서비스 실행");
		
		Connection con = getConnection(); 
		
		int result = new DestinationDao().insertDestination(con, d);
		 
		if(result > 0) {
			commit(con);
		} else { 
			rollback(con);
		}
		
		close(con);
		
		return result;
		
	}

	public ArrayList<Destination> selectList(String u_code) {
		
		System.out.println("배송지 설렉트 리스트 서비스 실행");
		
		Connection con = getConnection();
		
		ArrayList<Destination> list = new DestinationDao().selectList(con, u_code);
		
		close(con); 
		
		return list;
	}
	


}
