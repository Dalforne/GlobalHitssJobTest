package com.global.hitss.store.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.global.hitss.store.domain.enums.StatePayment;

@Entity
@JsonTypeName("paymentCard")
public class PaymentCard extends Payment {
	
	private static final long serialVersionUID = 1L;
	
	private Integer nrParcels;
	
	public PaymentCard() {}

	public PaymentCard(Integer idPayment, StatePayment statePayment, Sale sale, Integer nrParcels) {
		super(idPayment, statePayment, sale);
		this.nrParcels = nrParcels;		
	}

	public Integer getNrParcels() {
		return nrParcels;
	}

	public void setNrParcels(Integer nrParcels) {
		this.nrParcels = nrParcels;
	}
	
	
	
	
}
