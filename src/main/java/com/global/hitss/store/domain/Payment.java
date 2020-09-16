package com.global.hitss.store.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.global.hitss.store.domain.enums.StatePayment;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Payment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer idPayment;
	private Integer statePayment;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="id_sale")
	@MapsId
	private Sale sale;
	
	public Payment() {}

	public Payment(Integer idPayment, StatePayment statePayment, Sale sale) {
		super();
		this.idPayment = idPayment;
		this.statePayment = statePayment.getCod();
		this.sale = sale;
	}

	public Integer getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(Integer idPayment) {
		this.idPayment = idPayment;
	}

	public StatePayment getStatePayment() {
		return StatePayment.toEnum(statePayment);
	}

	public void setStatePayment(StatePayment statePayment) {
		this.statePayment = statePayment.getCod();
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPayment == null) ? 0 : idPayment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (idPayment == null) {
			if (other.idPayment != null)
				return false;
		} else if (!idPayment.equals(other.idPayment))
			return false;
		return true;
	}

	
}
