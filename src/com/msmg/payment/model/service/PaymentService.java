package com.msmg.payment.model.service;

import java.sql.Connection;

import com.msmg.payment.model.dao.PaymentDao;
import com.msmg.payment.model.vo.Payment;
import static com.msmg.common.JDBCTemplate.*;

public class PaymentService {
	 
	public int updateOrder(Payment p){
		Connection con = getConnection();
		
		int result = new PaymentDao().updateOrder(con, p);
		
		if(result > 0){
			commit(con); 
		} else { 
			rollback(con);
		}
		
		close(con);
		System.out.println("updateOrder Service 실행");
		return result;
		
	}

}
