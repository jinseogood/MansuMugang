package com.msmg.payment.model.service;

import java.sql.Connection;

import com.msmg.payment.model.dao.DestinationDao;
import com.msmg.payment.model.vo.Destination;

import static com.msmg.common.JDBCTemplate.*;

public class DestinationService {

	public int insertDestination(Destination d) {
		Connection con = getConnection();
		
		int result = new DestinationDao().insertDestination(con, d);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}

}
