package com.msmg.payment.model.service;

import java.sql.Connection;

import com.msmg.payment.model.dao.PhoneDao;
import com.msmg.payment.model.vo.Phone;

import static com.msmg.common.JDBCTemplate.*;

public class PhoneService {
	
	public int insertPhone(Phone ph){
		Connection con = getConnection();
		
		int result = new PhoneDao().insertPhone(con, ph);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
		
		
		
	}

}
