package com.msmg.payment.model.service;

import com.msmg.payment.model.dao.PaymentInfoDao;
import com.msmg.payment.model.vo.PaymentInfo;

import static com.msmg.common.JDBCTemplate.*;

import java.sql.Connection;

public class PaymentInfoService {

	public int insertPaymentInfo(PaymentInfo pi) {
		Connection con = getConnection();
		
		int result = new PaymentInfoDao().insertPaymentInfo(con, pi);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
		
	}

}
