package com.global.hitss.store.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.global.hitss.store.domain.enums.StatePayment;

@Entity
@JsonTypeName("paymentBill")
public class PaymentBill extends Payment {
	
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtDueDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dtPayDay;
	
	public PaymentBill() {}

	public PaymentBill(Integer idPayment, StatePayment statePayment, Sale sale, Date dtDueDate, Date dtPayDay) {
		super(idPayment, statePayment, sale);
		this.dtDueDate = dtDueDate;
		this.dtPayDay = dtPayDay;
	}

	public Date getDtDueDate() {
		return dtDueDate;
	}

	public void setDtDueDate(Date dtDueDate) {
		this.dtDueDate = dtDueDate;
	}

	public Date getTmPayDay() {
		return dtPayDay;
	}

	public void setDtPayDay(Date dtPayDay) {
		this.dtPayDay = dtPayDay;
	}


}
