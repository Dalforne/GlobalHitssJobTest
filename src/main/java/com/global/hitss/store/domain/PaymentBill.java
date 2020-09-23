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
	private Date tmDueDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date tmPayDay;
	
	public PaymentBill() {}

	public PaymentBill(Integer idPayment, StatePayment statePayment, Sale sale, Date tmDueDate, Date tmPayDay) {
		super(idPayment, statePayment, sale);
		this.tmDueDate = tmDueDate;
		this.tmPayDay = tmPayDay;
	}

	public Date getTmDueDate() {
		return tmDueDate;
	}

	public void setTmDueDate(Date tmDueDate) {
		this.tmDueDate = tmDueDate;
	}

	public Date getTmPayDay() {
		return tmPayDay;
	}

	public void setTmPayDay(Date tmPayDay) {
		this.tmPayDay = tmPayDay;
	}


}
