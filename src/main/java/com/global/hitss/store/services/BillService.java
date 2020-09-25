package com.global.hitss.store.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.global.hitss.store.domain.PaymentBill;

@Service
public class BillService {
	
	public void setPaymentBill(PaymentBill pay, Date tmSale) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(tmSale);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pay.setDtDueDate(cal.getTime());
	}
}
